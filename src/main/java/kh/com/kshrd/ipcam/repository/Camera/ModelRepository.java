package kh.com.kshrd.ipcam.repository.Camera;

import kh.com.kshrd.ipcam.entity.camera.Model;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ModelRepository {
		
	final String GET_ALL_MODEL			=	"select * from tbl_model where active = 1";
	
	
	final String GET_MODEL_BY_ID		=	"select * from tbl_model where active = 1 and model_id = #{model_id}";

    
	@Select(ModelRepository.GET_ALL_MODEL)
	/*@Results({
		@Result(property="vender",column = "vendor_id", one=@One(select = "kh.com.kshrd.ipcam.repository.Camera.VenderRepository.getVenderById"))
	})*/
	Model findAll();
	
	
	@Select("select * from tbl_model where active = 1 and model_id = #{model_id}")
	@Results({
		@Result(property="model_id", column="model_id"),
		@Result(property="name", column="name"),
		@Result(property="image", column="image"),
		@Result(property="vender_id", column="vender_id"),
		@Result(property="logo", column="logo"),
		@Result(property="vender",column = "vender_id", one = @One(select = "kh.com.kshrd.ipcam.repository.Camera.VenderRepository.getVenderById"))

	})
	Model findOne(@Param("model_id") int model_id);

}
