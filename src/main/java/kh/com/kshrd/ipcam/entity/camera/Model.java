package kh.com.kshrd.ipcam.entity.camera;

import com.fasterxml.jackson.annotation.JsonProperty;

import kh.com.kshrd.ipcam.entity.base.BaseEntity;

public class Model extends BaseEntity{
	@JsonProperty("VENDER")
	private Vender vender;
	
	@JsonProperty("IMAGE")
	private String image;
	
	public Vender getVender() {
		return vender;
	}
	public void setVender(Vender vender) {
		this.vender = vender;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "Model [vender=" + vender + ", image=" + image + "]";
	}
	
}

