package kh.com.kshrd.ipcam.service.extend;

import kh.com.kshrd.ipcam.entity.camera.Model;
import kh.com.kshrd.ipcam.entity.camera.inputerEntity.ModelInputer;
import kh.com.kshrd.ipcam.entity.camera.inputerEntity.ModelModifier;
import kh.com.kshrd.ipcam.service.CrudService;

import java.util.List;

/**
 * TODO: if you want to add more method, then add here... 
 */
public interface ModelService {

	Model getModelById(int id);

	List<Model> getAllModel();

	boolean remove(int id);

	boolean update(ModelModifier object);

	boolean save(ModelInputer object);

}
