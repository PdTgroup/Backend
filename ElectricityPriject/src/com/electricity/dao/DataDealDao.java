package com.electricity.dao;

import java.util.ArrayList;

import com.alibaba.fastjson.JSONObject;
import com.electricity.entity.Citys;
import com.electricity.entity.Datas;
import com.electricity.entity.Indexs;
import com.electricity.entity.Module;
import com.electricity.entity.Times;

public interface DataDealDao {
	    //id获取城市
		public Citys getCitysById(int cid);
		
		//id获取季度
		public Times getTimesById(int tid);
		
		//id获取指标
		public Indexs getIndexsById(int id);

		//id获取四个板块
		public Module getModuleById(int id);   
		
		//id获取每个模块下的指标
		public ArrayList<Indexs> getIndexsInModule(int moduleid);
		
		//查询 18个城市的某季度 某指标值的全部值
		public ArrayList<Datas> getAllCityIndexTime(int timeid,int indexid);
		
		//Json 柱状图 查询 18个城市的某季度 某指标值的全部值
		public JSONObject JsongetAllCityIndexTime(int timeid,int indexid);
		//public JSONObject JsongetAllCityIndexTime(int timeid,int indexid);
		//查询一个城市 某指标值得全部季度值
		public ArrayList<Datas> getAllTimeCityIndex(int indexid,int cityid);
		
		//查询分别18 个城市 某指标值得全部季度值
		public ArrayList<ArrayList<Datas>> getAllTimeAllCityIndex(int indexid);
		
		//Json 折线图 查询分别18 个城市 某指标值得全部季度值
		public JSONObject  JsonAllTimeAllCityIndex(int indexid);

		//某季度 某模块下指标的值
		public ArrayList<Datas> getIndexInModuleOneTime(int timeid,int moduleid);
	    
		//计算各个指标在模块中的值和模块占总模块的值
		public float getValue(float datas,float Allscore,float weight);
		
//****		//Json 模块中的指标       设指标的满分值为100
		public JSONObject getJsonIndexFromModule(int moduleid,int timeid);
		 
//*****		//算出每个模块下小指标的总和    此时每个指标值自己定义 
		public float getIndexSumForOneModel(int moduleid,int timeid);
		
		//四大模块基本数据
		public ArrayList<Module> getAllModules();
		
//*****  //JSon四个模块的数据  此时模块中的满分值先自己定义
	   public JSONObject getJsonAllModuleVAlue(int timeid);
        //JSon获取全部城市的值
	   public JSONObject getJSonAllCity();
	    //getAllCity
	   public  ArrayList<Citys> getAllCity();
	   //getAllTimes
	   public ArrayList<Times> getAllTimes();
	   //JSon获取全部季度的值
	   public JSONObject getJSonAllTime();
	   //getAllIndexs()
	   public ArrayList<Indexs> getAllIndexs();
	   //Json获取全部指标的值
	   public JSONObject getJSonAllIndexs();
	   //Json获取全部指标
	   public JSONObject getJsonAllModules();
	    //获取一个折线图一个指标下的所有季度
	   public ArrayList<Times> getOneIndTimes(int indexid);
	    //个数全部城市
	   public int getCountCity();
}
