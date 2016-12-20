
package kh.com.kshrd.ipcam.entity.camera;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import kh.com.kshrd.ipcam.entity.camera.base.BaseEntity;

public class Command extends BaseEntity{

	@JsonProperty("COMMAND_ID")
	private int command_id ;
	
	@JsonProperty("COMMAND")
	private String command;
	
	@JsonProperty("BODY")
	private String  body;
	
	public Command() {
		
	}
	
	
}
