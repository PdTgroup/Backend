package com.electricity.entity;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Datas {
public Datas() {
		super();
		// TODO Auto-generated constructor stub
	}

@JsonIgnore
private Integer Did;
private Float datas;
@JsonIgnore
private Integer cityid;
@JsonIgnore
private Integer timeid;
@JsonIgnore
private Integer indexid;
@JsonIgnore
private Citys city;
@JsonIgnore
private Times time;
private Indexs index;
private String cityName;
private String Time;
private String indexName;
public String getIndexName() {
	return indexName;
}
public void setIndexName(String indexName) {
	this.indexName = indexName;
}
public void setTime(String time) {
	Time = time;
}
public String getCityName() {
	return cityName;
}
public void setCityName(String cityName) {
	this.cityName = cityName;
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
public Integer getCityid() {
	return cityid;
}
public void setCityid(Integer cityid) {
	this.cityid = cityid;
}
public Integer getTimeid() {
	return timeid;
}
public void setTimeid(Integer timeid) {
	this.timeid = timeid;
}
public Integer getIndexid() {
	return indexid;
}
public void setIndexid(Integer indexid) {
	this.indexid = indexid;
}

@Override
public String toString() {
	return "Datas [Did=" + Did + ", datas=" + datas + ", cityid=" + cityid + ", timeid=" + timeid + ", indexid="
			+ indexid + ", city=" + city + ", time=" + time + ", index=" + index + "]";
}
public Datas(Integer did, Float datas, Integer cityid, Integer timeid, Integer indexid) {
	Did = did;
	this.datas = datas;
	this.cityid = cityid;
	this.timeid = timeid;
	this.indexid = indexid;
	
}


}
