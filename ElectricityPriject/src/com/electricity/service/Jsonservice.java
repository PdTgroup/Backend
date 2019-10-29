package com.electricity.service;

import com.alibaba.fastjson.JSONObject;
import com.electricity.dao.DataDealDao;
import com.electricity.dao.DataDealDaoIml;

public class Jsonservice {
	
	private DataDealDao dao=new DataDealDaoIml();
	//��ȡJson��״ͼ(һ������ һ��ָ�� ���г��е�ֵ)
	public String getBarChart(int timeid,int indexid){
		return dao.JsongetAllCityIndexTime(timeid, indexid);
	}
	//��ȡJson����ͼ(���г��� һ��ָ�� ���м��� )
	public String getLineChart(int indexid){
		
		return dao.JsonAllTimeAllCityIndex(indexid);
	}
	//��ȡ�Ĵ�ģ��÷ֵ�Json����
    public String getFourModual(int timeid){
    	return dao.getJsonAllModuleVAlue(timeid);
    }
    //��ȡÿ��ģ���µĸ���ָ��Json
    public String getIndexForOneModual(int moduleid,int timeid){
    	return dao.getJsonIndexFromModule(moduleid, timeid);
    }
    //��ȡȫ�����е�JSon����
	public String getJSonAllCity() {
		// TODO Auto-generated method stub
		return dao.getJSonAllCity();
	}
	//��ȡȫ��ʱ���Json����
	public String getJsonAllTimes() {
		// TODO Auto-generated method stub
		return dao.getJSonAllTime();
	}
	//��ȡȫ��ָ���Json����
	public String getJSonAllIndexs() {
		// TODO Auto-generated method stub
		return dao.getJSonAllIndexs();
	}
	//��ȡȫ��ģ���Json������
	public String getJsonAllModual(){
		return dao.getJsonAllModules();
	}
    
}
