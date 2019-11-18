package com.electricity.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Module implements Serializable{
	private  Integer id;
	private String moduleName;
	private transient float sum;//一个模块中的指标值的中和
	private transient float value;
	private Float allscore;//满分
	private Float weight;
	private transient Set<Indexs> setIndexs=new HashSet<Indexs>();

    public Module() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public float getSum() {
		return sum;
	}
	public void setSum(float sum) {
		this.sum = sum;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public float getAllscore() {
		return allscore;
	}
	public void setAllscore(float allscore) {
		this.allscore = allscore;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public Set<Indexs> getSetIndexs() {
		return setIndexs;
	}
	public void setSetIndexs(Set<Indexs> setIndexs) {
		this.setIndexs = setIndexs;
	}
	
	
}
