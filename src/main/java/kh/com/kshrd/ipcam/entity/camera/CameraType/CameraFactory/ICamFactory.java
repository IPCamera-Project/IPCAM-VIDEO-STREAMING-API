package kh.com.kshrd.ipcam.entity.camera.CameraType.CameraFactory;

import kh.com.kshrd.ipcam.entity.camera.CameraType.ICamCommand;
import kh.com.kshrd.ipcam.entity.camera.CameraType.Impl.Hikvision;
import kh.com.kshrd.ipcam.entity.camera.CameraType.Impl.Vivotek;

/**
 * Created by rina on 12/18/16.
 */
public class ICamFactory {
    /**
     *@ADD if you have more CAM type you must add new Object type here
     * @param ICam
     * @return camera type
     */
    public ICamCommand getICam(String ICam){
       if (ICam.equalsIgnoreCase("Hikvision")){
           return new Hikvision();
       }
       else if (ICam.equalsIgnoreCase("Vivotek")){
           return new Vivotek();
       }
       return null;
    }

    public static void main(String [] arg){
        ICamFactory iCamFactory = new ICamFactory();
        ICamCommand iCamCommand = iCamFactory.getICam("Vivotek");
        iCamCommand.setHost("192.168.1.2");
        iCamCommand.setUser("admin");
        iCamCommand.setPass("12345");
        iCamCommand.configeHttpClient();
        System.out.print(iCamCommand.left("left"));
    }
}
