package kh.com.kshrd.ipcam.controller.user;

import kh.com.kshrd.ipcam.entity.user.User;
import kh.com.kshrd.ipcam.respone.ResponseCode;
import kh.com.kshrd.ipcam.respone.ResponseMessage;
import kh.com.kshrd.ipcam.respone.ResponseObject;
import kh.com.kshrd.ipcam.service.extend.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author Phearun, Lun Sovathana
 *
 */
@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	public ResponseObject<User> getUserByID(@PathVariable("id") int id)
	{
		User data= service.findOne(id);
		ResponseObject<User> res=new ResponseObject<User>();
		
		if(data != null){
			res.setCode(ResponseCode.QUERY_FOUND);
			res.setMessage(ResponseMessage.USER_MESSAGE);
			res.setData(data);
		}
		else{
			res.setCode(ResponseCode.QUERY_NOT_FOUND);
			res.setMessage(ResponseMessage.USER_MESSAGE);
		}
		return res;
	}

}
