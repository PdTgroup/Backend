package com.electricity.entity;

public class Citys {
	private Integer  cid;
	private String cName;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getcName() {
		return cName;
	}
	@Override
	public String toString() {
		return "Citys [cid=" + cid + ", cName=" + cName + "]";
	}
	public Citys() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Citys(Integer cid, String cName) {
		super();
		this.cid = cid;
		this.cName = cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	

}
