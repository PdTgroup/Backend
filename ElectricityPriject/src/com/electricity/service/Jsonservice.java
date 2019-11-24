package com.electricity.service;

import com.alibaba.fastjson.JSONObject;
import com.electricity.dao.DataDealDao;
import com.electricity.dao.DataDealImpl;

public class Jsonservice {
	
	private DataDealDao dao=new DataDealImpl();
	//��ȡJson��״ͼ(һ������ һ��ָ�� ���г��е�ֵ)
	public JSONObject getBarChart(int timeid,int indexid){
		return dao.JsongetAllCityIndexTime(timeid, indexid);
	}
	//��ȡJson����ͼ(���г��� һ��ָ�� ���м��� )
	public JSONObject getLineChart(int indexid){
		
		return dao.JsonAllTimeAllCityIndex(indexid);
	}
	//��ȡ�Ĵ�ģ��÷ֵ�Json����
    public JSONObject getFourModual(int timeid){
    	return dao.getJsonAllModuleVAlue(timeid);
    }
    //��ȡÿ��ģ���µĸ���ָ��Json
    public JSONObject getIndexForOneModual(int moduleid,int timeid){
    	return dao.getJsonIndexFromModule(moduleid, timeid);
    }
    //��ȡȫ�����е�JSon����
	public JSONObject getJSonAllCity() {
		// TODO Auto-generated method stub
		return dao.getJSonAllCity();
	}
	//��ȡȫ��ʱ���Json����
	public JSONObject getJsonAllTimes() {
		// TODO Auto-generated method stub
		return dao.getJSonAllTime();
	}
	//��ȡȫ��ָ���Json����
	public JSONObject getJSonAllIndexs() {
		// TODO Auto-generated method stub
		return dao.getJSonAllIndexs();
	}
	//��ȡȫ��ģ���Json������
	public JSONObject getJsonAllModual(){
		return dao.getJsonAllModules();
	}
	
	
     
}
