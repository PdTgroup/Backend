package com.electricity.entity;

public class Zhuzhuang {
	private String cityName;
	private float datas;
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public float getDatas() {
		return datas;
	}
	public void setDatas(float datas) {
		this.datas = datas;
	}
	@Override
	public String toString() {
		return "Zhuzhuang [cityName=" + cityName + ", datas=" + datas + "]";
	}
	
	

}
