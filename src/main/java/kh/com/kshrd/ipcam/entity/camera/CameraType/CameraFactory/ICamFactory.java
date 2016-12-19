package kh.com.kshrd.ipcam.entity.camera.CameraType.CameraFactory;

import kh.com.kshrd.ipcam.entity.camera.CameraType.PtzInterface;

import java.lang.reflect.Constructor;

/**
 * Created by rina on 12/18/16.
 */
public class ICamFactory {
    /**
     *@ADD if you have more CAM type you must add new Object type here
     * @return camera type
     */
    public PtzInterface getICam(String iCamClass){
        PtzInterface ptzInterface=null;
        try {
            ptzInterface = (PtzInterface) Class.forName("kh.com.kshrd.ipcam.entity.camera.CameraType.Impl."+iCamClass).newInstance();
        }
        catch (Exception e){
            System.out.print(e.getMessage());
        }
        return  ptzInterface;
    }

}
