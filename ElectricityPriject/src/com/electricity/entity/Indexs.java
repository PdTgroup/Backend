package com.electricity.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Indexs implements Serializable {
	private  Integer Iid;
	private String  indexName;
	private String 	department;
	private String 	circle;
	private String	unit;
	private Float	Qweight;
	private Float allscore;
	public Indexs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getIid() {
		return Iid;
	}
	public void setIid(Integer iid) {
		Iid = iid;
	}
	public String getIndexName() {
		return indexName;
	}
	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCircle() {
		return circle;
	}
	public void setCircle(String circle) {
		this.circle = circle;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Float getQweight() {
		return Qweight;
	}
	public void setQweight(Float qweight) {
		Qweight = qweight;
	}
	public Float getAllscore() {
		return allscore;
	}
	public void setAllscore(Float allscore) {
		this.allscore = allscore;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	public Set<Datas> getSetdaDatas() {
		return setdaDatas;
	}
	public void setSetdaDatas(Set<Datas> setdaDatas) {
		this.setdaDatas = setdaDatas;
	}
	private transient Module module;
	private transient Set<Datas> setdaDatas=new HashSet<Datas>();
	
}
