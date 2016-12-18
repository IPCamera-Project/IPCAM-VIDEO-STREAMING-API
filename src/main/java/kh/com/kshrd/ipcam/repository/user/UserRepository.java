package kh.com.kshrd.ipcam.repository.user;
import kh.com.kshrd.ipcam.entity.user.User;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
	
	
	//THIS SQL USED IN IPCAMERA REPOSITORY. BY CHIVORN !
	final String GET_USER_BY_ID	=	"SELECT * FROM tbl_user WHERE user_id = #{id}";




	@Select(UserRepository.GET_USER_BY_ID)
	@Results({
		@Result(property="id", column="user_id"),
		@Result(property="name", column="display_name"),		
		@Result(property="username", column="username"),
		@Result(property="password", column="password"),
		@Result(property="image", column="image"),
		@Result(property="status", column="status"),
		@Result(property="createDate", column="create_date"),
	})
	User getUserByID(int id);
}