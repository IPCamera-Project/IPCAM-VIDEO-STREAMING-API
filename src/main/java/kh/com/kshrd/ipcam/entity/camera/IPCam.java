package kh.com.kshrd.ipcam.entity.camera;
import com.fasterxml.jackson.annotation.JsonProperty;

import kh.com.kshrd.ipcam.entity.base.BaseEntity;
import kh.com.kshrd.ipcam.entity.user.User;

public class IPCam extends BaseEntity {
	
	@JsonProperty("SERIAL_NUMBER")
	private String serialNumber;
	
	@JsonProperty("IP_ADDRESS")
	private String ipAddress;
	
	@JsonProperty("WEB_PORT")
	private int webPort;
	
	@JsonProperty("RTSP_PORT")
	private int rtspPort;
	
	@JsonProperty("USERNAME")
	private String username;
	
	@JsonProperty("PASSWORD")
	private String password;
	
	@JsonProperty("STREAM_URL")
	private String streamUrl;
	
	
	@JsonProperty("MODEL")
	private Model model;
	
	@JsonProperty("USER")
	private User user;
	

	public String getSerialNumber() {
		return serialNumber;
	}
	
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public String getIpAddress() {
		return ipAddress;
	}
	
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	public int getWebPort() {
		return webPort;
	}
	
	public void setWebPort(int webPort) {
		this.webPort = webPort;
	}
	
	public int getRtspPort() {
		return rtspPort;
	}
	
	public void setRtspPort(int rtspPort) {
		this.rtspPort = rtspPort;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getStreamUrl() {
		return streamUrl;
	}
	
	public void setStreamUrl(String streamUrl) {
		this.streamUrl = streamUrl;
	}
	
	public Model getModel() {
		return model;
	}
	
	public void setModel(Model model) {
		this.model = model;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "IPCam [serialNumber=" + serialNumber + ", ipAddress=" + ipAddress + ", webPort=" + webPort
				+ ", rtspPort=" + rtspPort + ", username=" + username + ", password=" + password + ", streamUrl="
				+ streamUrl + ", model=" + model + ", user=" + user + "]";
	}
}
