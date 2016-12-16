package kh.com.kshrd.ipcam.service.extend;

import org.springframework.stereotype.Service;

import kh.com.kshrd.ipcam.entity.camera.Model;
import kh.com.kshrd.ipcam.service.CrudService;

/**
 * TODO: if you want to add more method, then add here... 
 */
public interface ModelService extends CrudService<Model>{
	
	public boolean insertModel(String name,int vender_id,String image);
	
	public boolean updateModelByID(int id,String name,int vender_id,String image);

}
