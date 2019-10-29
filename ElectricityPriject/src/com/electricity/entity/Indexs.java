package com.electricity.entity;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Indexs {
	@JsonIgnore
	private Integer Iid;
	private String  indexName;
	@JsonIgnore
	private String 	department;
	@JsonIgnore
	private String 	circle;
	private String	unit;
	@JsonIgnore
	private Float	Qweight;
	@JsonIgnore
	private Module module;
	@JsonIgnore
	private float aLlscore;

	
	
	
	public float getaLlscore() {
		return aLlscore;
	}
	public void setaLlscore(float aLlscore) {
		this.aLlscore = aLlscore;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	public Indexs() {
		super();
	}
	
	@Override
	public String toString() {
		return "Indexs [Iid=" + Iid + ", indexName=" + indexName + ", department=" + department + ", circle=" + circle
				+ ", unit=" + unit + ", Qweight=" + Qweight + ", module=" + module + "]";
	}
	public Indexs(Integer iid, String indexName, String department, String circle, String unit, Float qweight,
			Module module) {
		super();
		Iid = iid;
		this.indexName = indexName;
		this.department = department;
		this.circle = circle;
		this.unit = unit;
		Qweight = qweight;
		this.module = module;
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
}
