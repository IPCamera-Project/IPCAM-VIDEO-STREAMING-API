package kh.com.kshrd.ipcam.repository.camera;
import java.util.ArrayList;

import javax.websocket.server.PathParam;

import kh.com.kshrd.ipcam.entity.camera.Model;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.querydsl.core.types.Path;

@Repository
public interface ModelRepository {
		
	final String GET_ALL_MODEL			=	"SELECT tm.model_id,tm.name,tm.create_date,tm.image,tv.vender_id as vID ,tv.name as vName,tv.create_date as vDate,tv.logo "
											+ "FROM tbl_model tm "
											+ "LEFT JOIN tbl_vender tv "
											+ "ON tm.vender_id = tv.vender_id";
	
	
	final String GET_MODEL_BY_ID		=	"SELECT tm.model_id,tm.name,tm.create_date,tm.image,tv.vender_id as vID ,tv.name as vName,tv.create_date as vDate,tv.logo "
											+ "FROM tbl_model tm "
											+ "LEFT JOIN tbl_vender tv "
											+ "ON tm.vender_id = tv.vender_id "
											+ "WHERE tm.model_id = #{id}";
	
	
	final String DELETE_MODEL_BY_ID		=	"DELETE FROM tbl_model WHERE model_id = #{id}";
	final String UPDATE_MODEL_BY_ID		=	"UPDATE tbl_model SET name=#{name},vender_id=#{vender_id},image=#{image} WHERE model_id=#{id};";
	final String INSERT_MODEL			=	"INSERT INTO tbl_model(name,vender_id,image) VALUES (#{name},#{vender_id},#{image})";
				
    
	@Select(ModelRepository.GET_ALL_MODEL)
	@Results({
		@Result(property="id", column="model_id"),
		@Result(property="name", column="name"),		
		@Result(property="createDate", column="create_date"),
		@Result(property="image", column="image"),
		@Result(property="vender.id", column="vid"),
		@Result(property="vender.name", column="vname"),
		@Result(property="vender.createDate", column="vdate"),
		@Result(property="vender.logo", column="logo"),
	})
	ArrayList<Model> findAll();
	
	
	@Select(ModelRepository.GET_MODEL_BY_ID)
	@Results({
		@Result(property="id", column="model_id"),
		@Result(property="name", column="name"),		
		@Result(property="createDate", column="create_date"),
		@Result(property="image", column="image"),
		@Result(property="vender.id", column="vid"),
		@Result(property="vender.name", column="vname"),
		@Result(property="vender.createDate", column="vdate"),
		@Result(property="vender.logo", column="logo"),
	})
	Model findOne(int id);

	@Delete(ModelRepository.DELETE_MODEL_BY_ID)
	boolean remove(int id);

	@Update(ModelRepository.UPDATE_MODEL_BY_ID)
	boolean updateModelByID(@Param("id")int id, @Param("name")String name,@Param("vender_id")int vender_id,@Param("image")String image);

	/*@Insert(ModelRepository.INSERT_MODEL)
	boolean save(Model object);*/
	
	@Insert(ModelRepository.INSERT_MODEL)
	boolean save(@Param("name")String name,@Param("vender_id")int vender_id,@Param("image")String image);
	
	
}
