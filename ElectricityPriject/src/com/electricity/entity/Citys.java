package com.electricity.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Citys implements Serializable{
	private  Integer  cid;
	private String cName;
	private transient Set<Datas> setdaDatas=new HashSet<Datas>();
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public Set<Datas> getSetdaDatas() {
		return setdaDatas;
	}
	public void setSetdaDatas(Set<Datas> setdaDatas) {
		this.setdaDatas = setdaDatas;
	}
	@Override
	public String toString() {
		return "Citys [cid=" + cid + ", cName=" + cName + ", setdaDatas=" + setdaDatas + "]";
	}
	public Citys() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
