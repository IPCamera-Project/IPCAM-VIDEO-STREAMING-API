package kh.com.kshrd.ipcam.controller.camera;

import kh.com.kshrd.ipcam.entity.camera.CameraType.CameraFactory.ICamFactory;
import kh.com.kshrd.ipcam.entity.camera.CameraType.PtzInterface;
import kh.com.kshrd.ipcam.service.impl.CommandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 
 * @author Chen Rina
 *
 */

@Controller
@RequestMapping("api/camControl")
public class IPCamControlController {
    @Autowired CommandServiceImpl commandService;

    @RequestMapping(value = "/cammerCammand",
                    method = RequestMethod.POST,
                    produces = "application/json")
    @ResponseBody
    public Boolean setCommandLeft(){//@RequestBody IPCam ipCam,@RequestParam("cmd")String cmd
        ICamFactory iCamFactory = new ICamFactory();
        PtzInterface ptzInterface = iCamFactory.getICam("Hikvision");
/*
        ptzInterface.setUser(ipCam.getUsername());
        ptzInterface.setPass(ipCam.getPassword());
        ptzInterface.setPort(ipCam.getWebPort());8/8/
        ptzInterface.left(cmd);*/

     /*   ptzInterface.setUser("admin");
        ptzInterface.setPass("12345");
        ptzInterface.setPort(80);
        ptzInterface.setHost("192.168.0.38");*/

        ptzInterface.left("80");

        return true;

    }

}
