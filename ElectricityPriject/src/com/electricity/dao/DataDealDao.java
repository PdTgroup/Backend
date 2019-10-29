package com.electricity.dao;

import java.util.ArrayList;

import com.alibaba.fastjson.JSONObject;
import com.electricity.entity.Citys;
import com.electricity.entity.Datas;
import com.electricity.entity.Indexs;
import com.electricity.entity.Module;
import com.electricity.entity.Times;

public interface DataDealDao {
	//id��ȡ����
		public Citys getCitysById(int cid);
		
		//id��ȡ����
		public Times getTimesById(int tid);
		
		//id��ȡָ��
		public Indexs getIndexsById(int id);

		//id��ȡ�ĸ����
		public Module getModuleById(int id);   
		
		//id��ȡÿ��ģ���µ�ָ��
		public ArrayList<Indexs> getIndexsInModule(int moduleid);
		
		//��ѯ 18�����е�ĳ���� ĳָ��ֵ��ȫ��ֵ
		public ArrayList<Datas> getAllCityIndexTime(int timeid,int indexid);
		
		//Json ��״ͼ ��ѯ 18�����е�ĳ���� ĳָ��ֵ��ȫ��ֵ
		public String JsongetAllCityIndexTime(int timeid,int indexid);
		//public JSONObject JsongetAllCityIndexTime(int timeid,int indexid);
		//��ѯһ������ ĳָ��ֵ��ȫ������ֵ
		public ArrayList<Datas> getAllTimeCityIndex(int indexid,int cityid);
		
		//��ѯ�ֱ�18 ������ ĳָ��ֵ��ȫ������ֵ
		public ArrayList<ArrayList<Datas>> getAllTimeAllCityIndex(int indexid);
		
		//Json ����ͼ ��ѯ�ֱ�18 ������ ĳָ��ֵ��ȫ������ֵ
		public String  JsonAllTimeAllCityIndex(int indexid);

		//ĳ���� ĳģ����ָ���ֵ
		public ArrayList<Datas> getIndexInModuleOneTime(int timeid,int moduleid);
	    
		//�������ָ����ģ���е�ֵ��ģ��ռ��ģ���ֵ
		public float getValue(float datas,float Allscore,float weight);
		
		//Json ģ���е�ָ��
		public String getJsonIndexFromModule(int moduleid,int timeid);
		 
		//���ÿ��ģ����Сָ����ܺ�
		public float getIndexSumForOneModel(int moduleid,int timeid);
		
		//�Ĵ�ģ���������
		public ArrayList<Module> getAllModules();
		
		//JSon�ĸ�ģ�������
	   public String getJsonAllModuleVAlue(int timeid);
        //JSon��ȡȫ�����е�ֵ
	   public String getJSonAllCity();
	    //getAllCity
	   public  ArrayList<Citys> getAllCity();
	   //getAllTimes
	   public ArrayList<Times> getAllTimes();
	   //JSon��ȡȫ�����ȵ�ֵ
	   public String getJSonAllTime();
	   //getAllIndexs()
	   public ArrayList<Indexs> getAllIndexs();
	   //Json��ȡȫ��ָ���ֵ
	   public String getJSonAllIndexs();
	   //Json��ȡȫ��ָ��
	    public String getJsonAllModules();
	    //��ȡһ������ͼһ��ָ���µ����м���
	    public ArrayList<Times> getOneIndTimes(int indexid);
	    //ȫ�����еĸ���
	    public int getCountCity();
	    
	    
		
}
