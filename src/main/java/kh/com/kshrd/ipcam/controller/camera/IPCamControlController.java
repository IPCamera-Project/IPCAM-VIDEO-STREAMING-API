package kh.com.kshrd.ipcam.controller.camera;

import com.fasterxml.jackson.databind.util.JSONPObject;
import kh.com.kshrd.ipcam.entity.camera.Command;
import kh.com.kshrd.ipcam.respone.Response;
import kh.com.kshrd.ipcam.service.impl.CommandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Chen Rina
 *
 */

@RestController
@RequestMapping("api/camControl")
public class IPCamControlController {
    @Autowired CommandServiceImpl commandService;

    @RequestMapping(value = "/findOne",
                    method = RequestMethod.GET,
                    produces = "application/json")
    @ResponseBody
    public Command get(){
        System.out.print(commandService.findOne(2));
        return commandService.findOne(2);

    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String,Object>> create(){
        Command command = new Command();
        Map<String,Object> map = new HashMap<String,Object>();
        Map<String,Object> mapControll = new HashMap<>();
            mapControll.put("HTTP","http://%s%s/ISAPI/PTZCtrl/channels/1/continuous");
            mapControll.put("CONTROL","<PTZData version=\\\"2.0\\\" xmlns=\\\"http://www.isapi.org/ver20/XMLSchema\\\"><pan>%d</pan><tilt>%d</tilt><zoom>%d</zoom></PTZData>");

      //  command.setBody(mapControll);
        command.setCommand("left");
        command.setModel_id(2);

        try {



            if( commandService.save(command)){
              map.put("body",command);
              map.put("MESSAGE","OK");
            }else{
                map.put("body",command);
                map.put("MESSAGE","NOT SAVE");
            }
        }
        catch (Exception e){
            map.put("body",command);
            map.put("MESSAGE",e.getMessage());
        }

        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

}
