package kh.com.kshrd.ipcam.controller.camera;

import com.fasterxml.jackson.databind.util.JSONPObject;
import kh.com.kshrd.ipcam.entity.camera.CameraType.CameraFactory.ICamFactory;
import kh.com.kshrd.ipcam.entity.camera.CameraType.ICamCommand;
import kh.com.kshrd.ipcam.entity.camera.Command;
import kh.com.kshrd.ipcam.entity.camera.IPCam;
import kh.com.kshrd.ipcam.respone.Response;
import kh.com.kshrd.ipcam.service.impl.CommandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
    public Boolean setCommandLeft(@RequestBody IPCam ipCam,@RequestParam("cmd")String cmd){
        ICamFactory iCamFactory = new ICamFactory();
        ICamCommand iCamCommand = iCamFactory.getICam(ipCam.getName());

        iCamCommand.setUser(ipCam.getUsername());
        iCamCommand.setPass(ipCam.getPassword());
        iCamCommand.setPort(ipCam.getWebPort());
        iCamCommand.left(cmd);

        return true;

    }

}
