package kh.com.kshrd.ipcam.controller.camera;
import java.util.ArrayList;

import kh.com.kshrd.ipcam.entity.camera.Model;
import kh.com.kshrd.ipcam.respone.Response;
import kh.com.kshrd.ipcam.respone.ResponseCode;
import kh.com.kshrd.ipcam.respone.ResponseList;
import kh.com.kshrd.ipcam.respone.ResponseMessage;
import kh.com.kshrd.ipcam.respone.ResponseObject;
import kh.com.kshrd.ipcam.service.extend.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author Rath Phearun, Hum Chivorn
 *
 */
@RestController
public class ModelController {
	@Autowired
	private ModelService service;
	
	@RequestMapping(value="/model",method=RequestMethod.GET)
	public ResponseList<Model> getAllModel()
	{
		ArrayList<Model> data=(ArrayList<Model>) service.findAll();
		ResponseList<Model> res=new ResponseList<Model>();
		
		if(data.size()>0){
			res.setCode(ResponseCode.QUERY_FOUND);
			res.setMessage(ResponseMessage.MODEL_MESSAGE);
			res.setData(data);
		}
		else{
			res.setCode(ResponseCode.QUERY_NOT_FOUND);
			res.setMessage(ResponseMessage.MODEL_MESSAGE);
		}
		return res;
	}
	
	
	@RequestMapping(value="/model/{id}",method=RequestMethod.GET)
	public ResponseObject<Model> getModelByID(@PathVariable("id") int id)
	{
		Model data= service.findOne(id);
		ResponseObject<Model> res=new ResponseObject<Model>();
		
		if(data != null){
			res.setCode(ResponseCode.QUERY_FOUND);
			res.setMessage(ResponseMessage.MODEL_MESSAGE);
			res.setData(data);
		}
		else{
			res.setCode(ResponseCode.QUERY_NOT_FOUND);
			res.setMessage(ResponseMessage.MODEL_MESSAGE);
		}
		return res;
	}
	
	@RequestMapping(value="/model/{id}",method=RequestMethod.DELETE)
	public Response deleteModelByID(@PathVariable("id") int id)
	{
	
		boolean status=service.remove(id);
		Response res=new Response();
		if(status){
			res.setCode(ResponseCode.DELETE_SUCCESS);
			res.setMessage(ResponseMessage.MODEL_MESSAGE);
		}
		else{
			res.setCode(ResponseCode.DELETE_FAIL);
			res.setMessage(ResponseMessage.MODEL_MESSAGE);
		}
		return res;
	}
	
	@RequestMapping(value="/model",method=RequestMethod.POST)
	public Response insertModel(@RequestBody Model data)
	{
		Response res=new Response();
		if(service.save(data)){
			res.setCode(ResponseCode.INSERT_SUCCESS);
			res.setMessage(ResponseMessage.MODEL_MESSAGE);
		}
		else{
			res.setCode(ResponseCode.INSERT_FAIL);
			res.setMessage(ResponseMessage.MODEL_MESSAGE);
		}
		
		return res;
		
	}
	
	@RequestMapping(value="/model",method=RequestMethod.PUT)
	public Response updateModelByID(@RequestBody Model data)
	{
		Response res=new Response();
		
		if(service.update(data))
		{
			res.setCode(ResponseCode.UPDATE_SUCCESS);
			res.setMessage(ResponseMessage.MODEL_MESSAGE);
		}
		else
		{
			res.setCode(ResponseCode.UPDATE_FAIL);
			res.setMessage(ResponseMessage.MODEL_MESSAGE);
		}
	
		return res;
	}

}
