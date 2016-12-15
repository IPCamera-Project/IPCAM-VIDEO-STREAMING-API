package kh.com.kshrd.ipcam.controller.camera;
import java.util.ArrayList;

import kh.com.kshrd.ipcam.service.extend.IPCamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	/*@RequestMapping(value="/ipcam",method=RequestMethod.GET)
	public ResponseList<Document> findAll(Paging pagination)
	{
		ArrayList<Object> doc=documentService.findAll(pagination);
		ResponseList<Document> res=new ResponseList<Document>();
		
		if(doc.size()>0){
			res.setCode(ResponseCode.RECORD_FOUND);
			res.setMessage();
			res.setData(doc);
			res.setPaging(pagination);
		}
		else{
			res.setCode(ResponseCode.RECORD_NOT_FOUND);
			res.setMessage();
		}
		return res;
	}*/
	
}
