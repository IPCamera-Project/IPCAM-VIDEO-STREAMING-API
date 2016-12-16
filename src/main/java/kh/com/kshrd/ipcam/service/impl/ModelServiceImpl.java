package kh.com.kshrd.ipcam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.kshrd.ipcam.entity.camera.Model;
import kh.com.kshrd.ipcam.repository.camera.ModelRepository;
import kh.com.kshrd.ipcam.service.extend.ModelService;

/**
 * 
 * @author PHEARUN-PC
 *
 */
@Service
public class ModelServiceImpl implements ModelService{
	
	@Autowired
	private ModelRepository repository;

	@Override
	public Model findOne(int id) {
		return repository.findOne(id);
	}

	@Override
	public List<Model> findAll() {
		return repository.findAll();
	}

	@Override
	public boolean remove(int id) {
		try {
			return repository.remove(id);
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public boolean update(Model object) {
		return false;
	}

	@Override
	public boolean save(Model object) {
		//return repository.save(object);
		return false;
	}

	@Override
	public boolean insertModel(String name, int vender_id, String image) {
		try {
			return repository.save(name,vender_id,image);
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public boolean updateModelByID(int id, String name, int vender_id,String image){
		try {
			return repository.updateModelByID(id,name,vender_id,image);
		} catch (Exception e) {			
		}
		return false;
	}

}
