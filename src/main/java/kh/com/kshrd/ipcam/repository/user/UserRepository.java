package kh.com.kshrd.ipcam.repository.user;
import kh.com.kshrd.ipcam.entity.inputerEntity.UserInputer;
import kh.com.kshrd.ipcam.entity.inputerEntity.UserModifier;
import kh.com.kshrd.ipcam.entity.user.User;

import org.apache.ibatis.annotations.*;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository {
	
	
	//THIS SQL USED IN IPCAMERA REPOSITORY. BY CHIVORN !
	final String GET_USER_BY_ID	=	"SELECT * FROM tbl_user WHERE user_id = #{user_id} and active = 1";

	final String GET_ALL_USER = "select tbl_user.* from tbl_user LEFT JOIN tbl_user_detail ON " +
								"tbl_user.user_id = tbl_user.user_id where tbl_user.active = 1";

	final String GET_USER_BY_EMAIL = " SELECT * FROM tbl_user WHERE email = #{email} and active = 1 ";

	final String INSERT_USER = "INSERT INTO tbl_user(username,password,email,image) " +
								"VALUES(#{username},#{password},#{email},#{image})";

	final String UPDATE_USER = "UPDATE tbl_user set (#{username,},#{password},#{email}) " +
								"WHERE user_id = #{user_id}";

	final String UPDATE_USER_IMAGE = "UPDATE tbl_user set image = #{image} where user_id = #{user_id}";

	final String REMOVE_USER = "UPDATE tbl_user set active = 1 where user_id = #{user_id}" ;


	@Select(GET_USER_BY_ID)
	@Results(value = {
			@Result(property = "role",column = "role")
	})
	User getUserByID(@Param("user_id") int user_id);

	@Select(GET_USER_BY_EMAIL)
	User getUserByEmail(@Param("email") String email);

	@Select(GET_ALL_USER)
	ArrayList<User> getAllUser();

	@Insert(INSERT_USER)
	boolean addUser(UserInputer userInputer);

	@Update(UPDATE_USER)
	boolean updateUser(UserModifier userModifier);

	@Update(UPDATE_USER_IMAGE)
	boolean updateUserImage(@Param("image")String image , @Param("user_id")int user_id);

	@Delete(REMOVE_USER)
	boolean removeUser(@Param("user_id")int user_id);

}
