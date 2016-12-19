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

    @RequestMapping(value = "/cmd/{method}",
                    method = RequestMethod.POST,
                    produces = "application/json")
    @ResponseBody
    public Boolean setCommand(@PathVariable("method")String method,
                                  @RequestParam(defaultValue = "68",required = false)String sp
                                  ){
      /*  Integer speed = Integer.parseInt(sp);*/

        ICamFactory iCamFactory = new ICamFactory();
        PtzInterface command = iCamFactory.getICam("Hikvision");


            if(method.equalsIgnoreCase("left") && command.left(sp))
            {
                System.out.print("success");
            }
            else if(method.equalsIgnoreCase("right") && command.right(sp))
            {
                System.out.print("success");
            }
            else if(method.equalsIgnoreCase("up") && command.up(sp))
            {
                System.out.print("success");
            }
            else if(method.equalsIgnoreCase("down") && command.down(sp))
            {
                System.out.print("success");
            }
            else  if (method.equalsIgnoreCase("zoomIn") && command.zoomIn(sp))
            {
                System.out.print("success");
            }
            else if (method.equalsIgnoreCase("zoomOut") && command.zoomOut(sp))
            {
                System.out.print("success");
            }

        return true;

    }

}
