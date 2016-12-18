package kh.com.kshrd.ipcam.entity.camera;

import java.util.Map;

import kh.com.kshrd.ipcam.entity.base.BaseEntity;

public class Command{
	private int command_id ;
	private String command;
	private Map<String,Object>  body;
    private int model_id;
	public Command() {
		
	}

	public int getModel_id() {
		return model_id;
	}

	public void setModel_id(int model_id) {
		this.model_id = model_id;
	}

	public int getCommand_id() {
		return command_id;
	}

	public void setCommand_id(int command_id) {
		this.command_id = command_id;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public Map<String,Object> getBody() {
		return body;
	}

	public void setBody(Map<String,Object> body) {
		this.body = body;
	}
}
