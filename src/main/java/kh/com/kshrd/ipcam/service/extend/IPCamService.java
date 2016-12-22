package kh.com.kshrd.ipcam.service.extend;

import kh.com.kshrd.ipcam.entity.camera.IPCam;
import kh.com.kshrd.ipcam.entity.inputerEntity.IPCamInputer;
import kh.com.kshrd.ipcam.entity.inputerEntity.IPCameraModifier;

import java.util.List;

/**
 * Created by rina on 12/20/16.
 */

public interface IPCamService {
    IPCam findOne(int id);

    List<IPCam> findAll();

    boolean remove(int id);

    boolean update(IPCameraModifier object);

    boolean save(IPCamInputer object);
}
