package kh.com.kshrd.ipcam.repository.camera;

import kh.com.kshrd.ipcam.entity.camera.Command;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by rina on 12/15/16.
 */
@Repository
public interface CommandRepository  {
     String INSERT = "INSERT INTO tbl_command( command, body, model_id) VALUES (#{command},#{body},#{model_id})";
     String SINGLE_SELECT = "SELECT * FROM tbl_command WHERE command_id = #{id}";

    @Insert(INSERT)
     boolean save(Command command);

    @Select(SINGLE_SELECT)
    Command findOne(@Param("id") int id);

}
