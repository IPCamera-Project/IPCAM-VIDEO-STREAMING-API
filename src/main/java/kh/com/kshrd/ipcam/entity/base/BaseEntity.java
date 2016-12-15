package kh.com.kshrd.ipcam.entity.base;

import java.sql.Timestamp;

public class BaseEntity {
	protected int id;
	protected String name;
	protected Timestamp createDate;
	
	public BaseEntity() {}
	
	BaseEntity(int id, String name, Timestamp createDate){
		this.id = id;
		this.name = name;
		this.createDate = createDate;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "BaseEntity [id=" + id + ", name=" + name + ", createDate=" + createDate + "]";
	}
	
}
