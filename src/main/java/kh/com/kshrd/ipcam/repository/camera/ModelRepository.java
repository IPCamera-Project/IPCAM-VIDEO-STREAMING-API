package kh.com.kshrd.ipcam.repository.camera;
import java.util.ArrayList;

import kh.com.kshrd.ipcam.entity.camera.Model;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ModelRepository {
	
	final String GET_ALL_MODEL="SELECT * FROM tbl_model";	
	final String GET_MODEL_BY_ID="SELECT * FROM tbl_model WHERE model_id = #{id}";
	final String DELETE_MODEL_BY_ID="DELETE FROM tbl_model WHERE model_id = #{id}";
	final String UPDATE_MODEL_BY_ID="UPDATE tbl_model SET name=#{name},vender_id=#{vender.id},image=#{image} WHERE model_id=#{id};";
	final String INSERT_MODEL="INSERT INTO tbl_model VALUES(nextval('tbl_model_model_id_seq'),#{name},#{vender.id},now(),#{image})";
				

	@Select(ModelRepository.GET_ALL_MODEL)
	ArrayList<Model> findAll();
	@Results({
		@Result(property="id", column="model_id"),
		@Result(property="name", column="name"),
		@Result(property="vender.id", column="vender_id"),		
		@Result(property="createDate", column="create_date"),
		@Result(property="image", column="image")
	})
	
	@Select(ModelRepository.GET_MODEL_BY_ID)
	Model findOne(int id);
	@Results({
		@Result(property="id", column="model_id"),
		@Result(property="name", column="name"),
		@Result(property="vender.id", column="vender_id"),		
		@Result(property="createDate", column="create_date"),
		@Result(property="image", column="image")
	})

	@Delete(ModelRepository.DELETE_MODEL_BY_ID)
	boolean remove(int id);

	@Update(ModelRepository.UPDATE_MODEL_BY_ID)
	boolean update(Model object);

	@Insert(ModelRepository.INSERT_MODEL)
	boolean save(Model object);
}
