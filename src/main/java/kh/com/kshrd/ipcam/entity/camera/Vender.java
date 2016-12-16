package kh.com.kshrd.ipcam.entity.camera;

import com.fasterxml.jackson.annotation.JsonProperty;

import kh.com.kshrd.ipcam.entity.base.BaseEntity;

public class Vender extends BaseEntity{
	@JsonProperty("LOGO")
	private String logo;

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Override
	public String toString() {
		return "Vender [logo=" + logo + "]";
	}
	
}
