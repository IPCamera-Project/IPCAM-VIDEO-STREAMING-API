package kh.com.kshrd.ipcam.entity.camera;

import com.fasterxml.jackson.annotation.JsonProperty;
import kh.com.kshrd.ipcam.entity.camera.base.BaseEntity;

public class Model extends BaseEntity{

	@JsonProperty("MODEL_ID")
	private int model_id;
	@JsonProperty("VENDER")
	private Vender vender;
	@JsonProperty("NAME")
	private String name;
	@JsonProperty("VENDOR_ID")
	private int vender_id;
	@JsonProperty("IMAGE")
	private String image;

	public int getModel_id() {
		return model_id;
	}

	public void setModel_id(int model_id) {
		this.model_id = model_id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

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

	public int getVender_id() {
		return vender_id;
	}

	public void setVender_id(int vender_id) {
		this.vender_id = vender_id;
	}

	@Override
	public String toString() {
		return "Model [vender=" + vender + ", image=" + image + "]";
	}
	
}

