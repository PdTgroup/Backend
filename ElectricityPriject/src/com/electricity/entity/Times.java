package com.electricity.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
public class Times implements Serializable{
private  Integer Tid;
private String time;
private transient Set<Datas> setdaDatas=new HashSet<Datas>();
public Times() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Times [Tid=" + Tid + ", time=" + time + ", setdaDatas=" + setdaDatas + "]";
}
public Integer getTid() {
	return Tid;
}
public void setTid(Integer tid) {
	Tid = tid;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public Set<Datas> getSetdaDatas() {
	return setdaDatas;
}
public void setSetdaDatas(Set<Datas> setdaDatas) {
	this.setdaDatas = setdaDatas;
}


}
