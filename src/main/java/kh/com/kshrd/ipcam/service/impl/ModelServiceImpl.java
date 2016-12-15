package kh.com.kshrd.ipcam.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import kh.com.kshrd.ipcam.entity.camera.Model;
import kh.com.kshrd.ipcam.repository.camera.ModelRepository;
import kh.com.kshrd.ipcam.service.extend.ModelService;

/**
 * 
 * @author PHEARUN-PC
 *
 */
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
		return repository.remove(id);
	}

	@Override
	public boolean update(Model object) {
		return repository.update(object);
	}

	@Override
	public boolean save(Model object) {
		return repository.save(object);
	}

}
