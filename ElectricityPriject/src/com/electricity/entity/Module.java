package com.electricity.entity;

public class Module {
	private Integer id;
	private String module;
	private float sum;//一个模块中的指标值的中和
	private float value;
	private float Allscore;//满分
	private float weight;
	
	
	
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
	
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getAllscore() {
		return Allscore;
	}
	public void setAllscore(float allscore) {
		Allscore = allscore;
	}
	@Override
	public String toString() {
		return "Module [id=" + id + ", module=" + module + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
}
