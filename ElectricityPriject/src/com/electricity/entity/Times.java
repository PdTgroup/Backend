package com.electricity.entity;

public class Times {
private Integer Tid;
private String time;
@Override
public String toString() {
	return "Times [Tid=" + Tid + ", time=" + time + "]";
}
public Times() {
	super();
	// TODO Auto-generated constructor stub
}
public Times(Integer tid, String time) {
	super();
	Tid = tid;
	this.time = time;
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

}
