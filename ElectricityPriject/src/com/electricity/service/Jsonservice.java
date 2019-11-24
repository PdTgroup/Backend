package com.electricity.service;

import com.alibaba.fastjson.JSONObject;
import com.electricity.dao.DataDealDao;
import com.electricity.dao.DataDealImpl;

public class Jsonservice {
	
	private DataDealDao dao=new DataDealImpl();
	//获取Json柱状图(一个季度 一个指标 所有城市的值)
	public JSONObject getBarChart(int timeid,int indexid){
		return dao.JsongetAllCityIndexTime(timeid, indexid);
	}
	//获取Json折线图(所有城市 一个指标 所有季度 )
	public JSONObject getLineChart(int indexid){
		
		return dao.JsonAllTimeAllCityIndex(indexid);
	}
	//获取四大模块得分的Json数据
    public JSONObject getFourModual(int timeid){
    	return dao.getJsonAllModuleVAlue(timeid);
    }
    //获取每个模块下的各个指标Json
    public JSONObject getIndexForOneModual(int moduleid,int timeid){
    	return dao.getJsonIndexFromModule(moduleid, timeid);
    }
    //获取全部城市的JSon数据
	public JSONObject getJSonAllCity() {
		// TODO Auto-generated method stub
		return dao.getJSonAllCity();
	}
	//获取全部时间的Json数据
	public JSONObject getJsonAllTimes() {
		// TODO Auto-generated method stub
		return dao.getJSonAllTime();
	}
	//获取全部指标的Json数据
	public JSONObject getJSonAllIndexs() {
		// TODO Auto-generated method stub
		return dao.getJSonAllIndexs();
	}
	//获取全部模块的Json的数据
	public JSONObject getJsonAllModual(){
		return dao.getJsonAllModules();
	}
	
	
     
}
