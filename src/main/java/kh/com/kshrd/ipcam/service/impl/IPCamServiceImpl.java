package kh.com.kshrd.ipcam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.kshrd.ipcam.entity.camera.IPCam;
import kh.com.kshrd.ipcam.repository.camera.IPCamRepository;
import kh.com.kshrd.ipcam.service.extend.IPCamService;
/**
 * 
 * @author PHEARUN-PC
 *
 */
@Service
public class IPCamServiceImpl implements IPCamService{
	
	@Autowired
	private IPCamRepository repository;

	@Override
	public IPCam findOne(int id) {
		try {
			return repository.findOne(id);
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public List<IPCam> findAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
		}
		return null;
		
		
	}

	@Override
	public boolean remove(int id) {
		try {
			return repository.remove(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean update(IPCam object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean save(IPCam object) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean insertCamera(String name, String serial, String ip,
			String webPort, String rtspPort, String username, String password,
			String streamURL, int modelID, int userID) {
		
		try {
			return repository.insertCamera(name, serial, ip, webPort, rtspPort, username, password, streamURL, modelID, userID);
		} catch (Exception e) {
		}
		return false;
				
	}

	@Override
	public boolean updateCameraByID(int id, String name, String serial,
			String ip, String webPort, String rtspPort, String username,
			String password, String streamURL, int modelID, int userID) {
		try {
			return repository.updateCameraByID(id,name, serial, ip, webPort, rtspPort, username, password, streamURL, modelID, userID);
		} catch (Exception e) {
		}
		return false;
	}

}
