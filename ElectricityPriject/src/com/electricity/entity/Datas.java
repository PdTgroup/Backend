package com.electricity.entity;

import java.io.Serializable;

public class Datas implements Serializable{


private transient Integer Did;
private Float datas;
private Citys city;
private Times time;
private Indexs index;
@Override
public String toString() {
	return "Datas [Did=" + Did + ", datas=" + datas + ", city=" + city + ", time=" + time + ", index=" + index + "]";
}
public Datas() {
	super();
	// TODO Auto-generated constructor stub
}
public Integer getDid() {
	return Did;
}
public void setDid(Integer did) {
	Did = did;
}
public Float getDatas() {
	return datas;
}
public void setDatas(Float datas) {
	this.datas = datas;
}
public Citys getCity() {
	return city;
}
public void setCity(Citys city) {
	this.city = city;
}
public Times getTime() {
	return time;
}
public void setTime(Times time) {
	this.time = time;
}
public Indexs getIndex() {
	return index;
}
public void setIndex(Indexs index) {
	this.index = index;
}






}
