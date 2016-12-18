package kh.com.kshrd.ipcam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.kshrd.ipcam.entity.user.User;
import kh.com.kshrd.ipcam.repository.camera.ModelRepository;
import kh.com.kshrd.ipcam.repository.user.UserRepository;
import kh.com.kshrd.ipcam.service.extend.UserService;
/**
 * 
 * @author PHEARUN-PC
 *
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repository;

	@Override
	public User findOne(int id) {
		try {
			return repository.getUserByID(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean save(User object) {
		// TODO Auto-generated method stub
		return false;
	}

}
