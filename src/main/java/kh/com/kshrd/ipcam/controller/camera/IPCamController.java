package kh.com.kshrd.ipcam.controller.camera;
import java.util.ArrayList;
import kh.com.kshrd.ipcam.entity.camera.IPCam;
import kh.com.kshrd.ipcam.respone.Response;
import kh.com.kshrd.ipcam.respone.ResponseCode;
import kh.com.kshrd.ipcam.respone.ResponseList;
import kh.com.kshrd.ipcam.respone.ResponseMessage;
import kh.com.kshrd.ipcam.respone.ResponseObject;
import kh.com.kshrd.ipcam.service.extend.IPCamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author Hum Chivorn
 *
 */
@RestController
public class IPCamController {
	@Autowired
	private IPCamService service;
	
	@RequestMapping(value="/camera",method=RequestMethod.GET)
	public ResponseList<IPCam> getAllCamera()
	{
		ArrayList<IPCam> data=(ArrayList<IPCam>) service.findAll();
		ResponseList<IPCam> res=new ResponseList<IPCam>();
		
		if(data.size()>0){
			res.setCode(ResponseCode.QUERY_FOUND);
			res.setMessage(ResponseMessage.CAMERA_MESSAGE);
			res.setData(data);
		}
		else{
			res.setCode(ResponseCode.QUERY_NOT_FOUND);
			res.setMessage(ResponseMessage.CAMERA_MESSAGE);
		}
		return res;
	}
	
	
	@RequestMapping(value="/camera/{id}",method=RequestMethod.GET)
	public ResponseObject<IPCam> getCameraByID(@PathVariable("id") int id)
	{
		IPCam data= service.findOne(id);
		ResponseObject<IPCam> res=new ResponseObject<IPCam>();
		
		if(data != null){
			res.setCode(ResponseCode.QUERY_FOUND);
			res.setMessage(ResponseMessage.CAMERA_MESSAGE);
			res.setData(data);
		}
		else{
			res.setCode(ResponseCode.QUERY_NOT_FOUND);
			res.setMessage(ResponseMessage.CAMERA_MESSAGE);
		}
		return res;
	}
	
	@RequestMapping(value="/camera/{id}",method=RequestMethod.DELETE)
	public Response deleteCameraByID(@PathVariable("id") int id)
	{
	
		boolean status=service.remove(id);
		Response res=new Response();
		if(status){
			res.setCode(ResponseCode.DELETE_SUCCESS);
			res.setMessage(ResponseMessage.CAMERA_MESSAGE);
		}
		else{
			res.setCode(ResponseCode.DELETE_FAIL);
			res.setMessage(ResponseMessage.CAMERA_MESSAGE);
		}
		return res;
	}
	
	@RequestMapping(value="/camera",method=RequestMethod.POST)
	public Response insertCamera(
			@RequestParam("NAME") String name,
			@RequestParam("SERIAL_NUMBER") String serial,
			@RequestParam("IP_ADDRESS") String ip,
			@RequestParam("WEB_PORT") String webPort,
			@RequestParam("RTSP_PORT") String rtspPort,
			@RequestParam("USERNAME") String username,
			@RequestParam("PASSWORD") String password,
			@RequestParam("STREAM_URL") String streamURL,
			@RequestParam("MODEL_ID") int modelID,
			@RequestParam("USER_ID") int userID
			
			)
	{
		Response res=new Response();
		if(service.insertCamera(name,serial,ip,webPort,rtspPort,username,password,streamURL,modelID,userID)){
			res.setCode(ResponseCode.INSERT_SUCCESS);
			res.setMessage(ResponseMessage.CAMERA_MESSAGE);
		}
		else{
			res.setCode(ResponseCode.INSERT_FAIL);
			res.setMessage(ResponseMessage.CAMERA_MESSAGE);
		}
		
		return res;
		
	}
	
	@RequestMapping(value="/camera",method=RequestMethod.PUT)
	public Response updateCameraByID(
			@RequestParam("CAMERA_ID") int id,
			@RequestParam("NAME") String name,
			@RequestParam("SERIAL_NUMBER") String serial,
			@RequestParam("IP_ADDRESS") String ip,
			@RequestParam("WEB_PORT") String webPort,
			@RequestParam("RTSP_PORT") String rtspPort,
			@RequestParam("USERNAME") String username,
			@RequestParam("PASSWORD") String password,
			@RequestParam("STREAM_URL") String streamURL,
			@RequestParam("MODEL_ID") int modelID,
			@RequestParam("USER_ID") int userID
			)
	{
		Response res=new Response();
		
		if(service.updateCameraByID(id,name,serial,ip,webPort,rtspPort,username,password,streamURL,modelID,userID))
		{
			res.setCode(ResponseCode.UPDATE_SUCCESS);
			res.setMessage(ResponseMessage.CAMERA_MESSAGE);
		}
		else
		{
			res.setCode(ResponseCode.UPDATE_FAIL);
			res.setMessage(ResponseMessage.CAMERA_MESSAGE);
		}
	
		return res;
	}
	
}
