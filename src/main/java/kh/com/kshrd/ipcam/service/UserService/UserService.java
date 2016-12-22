package kh.com.kshrd.ipcam.service.UserService;

import kh.com.kshrd.ipcam.entity.inputerEntity.UserInputer;
import kh.com.kshrd.ipcam.entity.inputerEntity.UserModifier;
import kh.com.kshrd.ipcam.entity.user.User;
import kh.com.kshrd.ipcam.repository.user.UserRepository;
import kh.com.kshrd.ipcam.service.CrudService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rina on 12/20/16.
 */
@Service
public class UserService  {
    @Autowired
    UserRepository userRepository;

    public User getUserById(int id) {
        return userRepository.getUserByID(id);
    }

    public  User getUserByEmail(String email){return userRepository.getUserByEmail(email);}

    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }

    public boolean remove(int id) {
        return userRepository.removeUser(id);
    }

    public boolean update(UserModifier object) {
        return userRepository.updateUser(object);
    }

    public boolean updateUserImage(String image, int user_id) {return userRepository.updateUserImage(image,user_id);}

    public boolean addUser(UserInputer object) {
        return userRepository.addUser(object);
    }
}
