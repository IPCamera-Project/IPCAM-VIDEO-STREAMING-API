package kh.com.kshrd.ipcam.repository.user;

import kh.com.kshrd.ipcam.entity.user.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by rina on 12/22/16.
 */
@Repository
public interface RoleRepository {

    final String GET_ROLE_BY_ID = "SELECT role_id,name,description FROM tbl_role where role_id = #{role_id}";
    final String GET_ROLE_BY_NAME = "SELECT role_id,name,description FROM tbl_role where name = #{role_name}";


    @Select(GET_ROLE_BY_ID)
     Role getRoleById(@Param("role_id")int role_id);

    @Select(GET_ROLE_BY_NAME)
     Role getRoleByName(@Param("role_name")String roleName);
}
