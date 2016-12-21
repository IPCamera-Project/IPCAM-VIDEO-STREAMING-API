package kh.com.kshrd.ipcam.repository.Camera;

import java.util.ArrayList;

import kh.com.kshrd.ipcam.entity.camera.IPCam;
import kh.com.kshrd.ipcam.entity.camera.inputerEntity.IPCamInputer;
import kh.com.kshrd.ipcam.entity.camera.inputerEntity.IPCameraModifier;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface IPCamRepository {

	final String GET_ALL_CAMERA			=	"SELECT * FROM tbl_camera";
	
	final String GET_CAMERA_BY_ID		=	"SELECT * FROM tbl_camera WHERE camera_id = #{id}";


	final String REMOVE_CAMERA_BY_ID	=	"UPDATE tbl_camera SET active = 0 WHERE camera_id = #{id}";
	
	
	final String UPDATE_CAMERA_BY_ID	=	"UPDATE tbl_camera SET name=#{name},serial_number=#{serial_number}," +
											"ip_address=#{ip_address},web_port=#{web_port},rtsp_port=#{rtsp_port},username=#{username}," +
											"password=#{password},model_id=#{model_id},user_id=#{user_id} " +
											"WHERE camera_id=#{camera_id}";
	
	
	final String INSERT_CAMERA			=	"INSERT INTO tbl_camera (name,serial_number,ip_address,web_port,rtsp_port," +
											"username,password,model_id,user_id) VALUES(#{name},#{serial_number}," +
											"#{ip_address},#{web_port},#{rtsp_port},#{username},#{password}," +
											"#{model_id},#{user_id})";


	@Select(IPCamRepository.GET_ALL_CAMERA)
	@Results({
		@Result(property="id", column="camera_id"),
		@Result(property="name", column="name"),
		@Result(property="serial_number", column="serial_number"),
		@Result(property="ip_address", column="ip_address"),
		@Result(property="web_port", column="web_port"),
		@Result(property="username", column="username"),
		@Result(property="password", column="password"),
		@Result(property="stream_url", column="stream_url"),
			@Result(property="user", column="user_id", one = @One(select = "kh.com.kshrd.ipcam.repository.user.UserRepository.getUserByID")),
			@Result(property="model", column="model_id", one = @One(select = "kh.com.kshrd.ipcam.repository.Camera.ModelRepository.findOne"))

	})
	ArrayList<IPCam> findAll();


	@Select(IPCamRepository.GET_CAMERA_BY_ID)
	@Results({
		@Result(property="id", column="camera_id"),
		@Result(property="name", column="name"),
		@Result(property="serial_number", column="serial_number"),
		@Result(property="ip_address", column="ip_address"),
		@Result(property="web_port", column="web_port"),
		@Result(property="username", column="username"),
		@Result(property="password", column="password"),
		@Result(property="stream_url", column="stream_url"),
		@Result(property="user", column="user_id", one = @One(select = "kh.com.kshrd.ipcam.repository.user.UserRepository.getUserByID")),
		@Result(property="model", column="model_id", one = @One(select = "kh.com.kshrd.ipcam.repository.Camera.ModelRepository.findOne"))
	})
	IPCam findOne(int id);

	@Delete(REMOVE_CAMERA_BY_ID)
	boolean remove(int id);

	@Update(UPDATE_CAMERA_BY_ID)
	boolean updateCameraByID(IPCameraModifier ipCam);

	@Insert(INSERT_CAMERA)
	boolean saveCamera(IPCamInputer ipCam);




}
