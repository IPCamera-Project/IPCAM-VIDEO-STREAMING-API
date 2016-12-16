package kh.com.kshrd.ipcam.service.extend;

import kh.com.kshrd.ipcam.entity.camera.IPCam;
import kh.com.kshrd.ipcam.service.CrudService;

/**
 * TODO: if you want to add more method, then add here... 
 */
public interface IPCamService extends CrudService<IPCam>{

	public boolean insertCamera(String name,String serial,String ip,String webPort,String rtspPort,String username,String password,String streamURL,int modelID,int userID);
	
	public boolean updateCameraByID(int id,String name,String serial,String ip,String webPort,String rtspPort,String username,String password,String streamURL,int modelID,int userID);
}
