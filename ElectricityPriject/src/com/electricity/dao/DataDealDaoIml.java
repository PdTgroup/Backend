package com.electricity.dao;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.electricity.entity.Citys;
import com.electricity.entity.Datas;
import com.electricity.entity.Indexs;
import com.electricity.entity.IndexsOfModule;
import com.electricity.entity.Module;
import com.electricity.entity.Times;
import com.electricity.entity.Zhexian;
import com.electricity.entity.Zhuzhuang;
import com.electricity.tool.JDBCUtils;
import com.mysql.jdbc.log.Log;

import sun.launcher.resources.launcher;

public class DataDealDaoIml implements DataDealDao {
	@Override
	public ArrayList<Times> getAllTimes() {
		ArrayList<Times> list=new ArrayList<Times>();
		String sql ="select * from time_table";
		QueryRunner queryRunner = JDBCUtils.getQueryRunner();
		try {
			 list = (ArrayList<Times>) queryRunner.query(sql,new BeanListHandler<Times>(Times.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Citys> getAllCity(){
		ArrayList<Citys> list=new ArrayList<Citys>();
		String sql ="select * from city_table";
		QueryRunner queryRunner = JDBCUtils.getQueryRunner();
		try {
			 list = (ArrayList<Citys>) queryRunner.query(sql,new BeanListHandler<Citys>(Citys.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public Citys getCitysById(int cid) {
		Citys citys=null;
		QueryRunner queryRunner = JDBCUtils.getQueryRunner();
		String sql ="select * from city_table where cid=?";
		try {
			citys = queryRunner.query(sql,new BeanHandler<Citys>(Citys.class),cid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return citys;
	}
	@Override
	public Times getTimesById(int tid) {
	  Times time=null;
	  QueryRunner queryRunner = JDBCUtils.getQueryRunner();
	  String sql="select * from time_table where Tid=?";
	  try {
	  time = queryRunner.query(sql,new BeanHandler<Times>(Times.class),tid);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		return time;
	}
	@Override
	public Indexs getIndexsById(int id) {
		Indexs index=null;
		QueryRunner queryRunner = JDBCUtils.getQueryRunner();
		String sql="select * from zb_table where Iid=?";
		try {
			index= queryRunner.query(sql,new BeanHandler<Indexs>(Indexs.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return index;
	}
	@Override
	public ArrayList<Datas> getAllCityIndexTime(int timeid, int indexid) {
		List<Datas> list=new ArrayList<Datas>();
		QueryRunner queryRunner = JDBCUtils.getQueryRunner();
		String sql="SELECT * FROM data_table  WHERE  timeid=? and indexid=?";
		Object[] params={timeid,indexid};
		try {
			 list = queryRunner.query(sql,new BeanListHandler<Datas>(Datas.class),params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return (ArrayList<Datas>) list;
	}
	@Test
	public String JsongetAllCityIndexTime(int timeid, int indexid) {
		String result=null;
		JSONObject jsonObject=new JSONObject();
		DataDealDao dao=new DataDealDaoIml();
		Indexs index = dao.getIndexsById(indexid);
		Times time = dao.getTimesById(timeid);
		HashMap<String,Object> map=new HashMap<>();
		map.put("indexInfo", index);
		map.put("indexCycle",time);
		ArrayList<Datas> list = dao.getAllCityIndexTime(timeid, indexid);
		ArrayList< Zhuzhuang> Zhulist=new  ArrayList<Zhuzhuang>();
		for (Datas datas : list) {
		    int cid =datas.getCityid();
			String cityName = dao.getCitysById(cid).getcName();
			float data = datas.getDatas();
			Zhuzhuang z=new Zhuzhuang();
			z.setCityName(cityName);
			z.setDatas(data);
			Zhulist.add(z);
		}
		map.put("cityScore",Zhulist);
		jsonObject.put("barData", map);
		result=JSON.toJSONString(jsonObject);
		return result;
	}
	/*public JSONObject JsongetAllCityIndexTime(int timeid, int indexid) {
		String result=null;
		JSONObject jsonObject=new JSONObject();
		DataDealDao dao=new DataDealDaoIml();
		Indexs index = dao.getIndexsById(indexid);
		Times time = dao.getTimesById(timeid);
		HashMap<String,Object> map=new HashMap<>();
		map.put("indexInfo", index);
		map.put("indexCycle",time);
		ArrayList<Datas> list = dao.getAllCityIndexTime(timeid, indexid);
		ArrayList< Zhuzhuang> Zhulist=new  ArrayList<Zhuzhuang>();
		for (Datas datas : list) {
		    int cid =datas.getCityid();
			String cityName = dao.getCitysById(cid).getcName();
			float data = datas.getDatas();
			Zhuzhuang z=new Zhuzhuang();
			z.setCityName(cityName);
			z.setDatas(data);
			Zhulist.add(z);
		}
		map.put("cityScore",Zhulist);
		jsonObject.put("barData", map);
		//result=JSON.toJSONString(jsonObject);
		return jsonObject;
	}*/
	public ArrayList<Datas>  getAllTimeCityIndex(int indexid, int cityid) {
		List<Datas>  list =new ArrayList<Datas>();
		QueryRunner queryRunner = JDBCUtils.getQueryRunner();
		String sql="SELECT * FROM data_table WHERE indexid=? AND cityid=?";
		Object[] params={indexid,cityid};
		try {
			list=  queryRunner.query(sql,new BeanListHandler<Datas>(Datas.class),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (ArrayList<Datas>) list;
	}
	public ArrayList<ArrayList<Datas>> getAllTimeAllCityIndex(int indexid) {
		
		List<ArrayList<Datas>>  list=new ArrayList<ArrayList<Datas>>();
		List<Datas> list2=new ArrayList<Datas>();
		DataDealDao dao=new DataDealDaoIml();
		for (int i = 1; i <= 18; i++) {
			list2=dao.getAllTimeCityIndex(indexid,i);
			list.add((ArrayList<Datas>) list2);
		}
		return (ArrayList<ArrayList<Datas>>) list;
	}
	/*public String JsonAllTimeAllCityIndex1(int indexid) {
		List<Object>  list=new ArrayList<Object>();
		List<Datas> list2=new ArrayList<Datas>();
		HashMap<String,Object> map=new HashMap<String, Object>();
		JSONObject jsonObject=new JSONObject();
		String result=null;
		DataDealDao dao=new DataDealDaoIml();
		Indexs index = dao.getIndexsById(indexid);
		map.put("indexInfo",index);
		//对18个城市进行遍历
		for (int i = 1; i <=22; i++) {
		//获取每个城市所有季度的值
			list2=dao.getAllTimeCityIndex(indexid,i);
		//对获取的值进行加工组合
			String	Cityname=null;
			ArrayList<Float> dataslist=new ArrayList<Float>();
			ArrayList<String> timeslist=new ArrayList<String>(); 
			for (Datas datas : list2) {
				Citys city = dao.getCitysById(datas.getCityid()); 
			    Cityname=city.getcName();
				datas.setCityName(Cityname);
				Float d = datas.getDatas();
				dataslist.add(d);
				String Time=dao.getTimesById(datas.getTimeid()).getTime();
				timeslist.add(Time);
			}
			Zhexian zhexian=new Zhexian();
			zhexian.setCityName(Cityname);
			zhexian.setDataList(dataslist);
			zhexian.setTimesList(timeslist);
		    list.add(zhexian);
		    String cid=String.valueOf(i);
		}
		map.put("cityScore", list);
		jsonObject.put("lineData",map);
		result=JSON.toJSONString(jsonObject);
		return result;
	}*/
	public ArrayList<Times> getOneIndTimes(int indexid){
		DataDealDao dao=new DataDealDaoIml();
		ArrayList<Datas> list=new ArrayList<Datas>();
		ArrayList<Times> listtimes=new ArrayList<Times>();
		String sql="select timeid from data_table where indexid=? and cityid=1";
		QueryRunner queryRunner = JDBCUtils.getQueryRunner();
		Object[] params={indexid};
		try {
			list=  (ArrayList<Datas>) queryRunner.query(sql,new BeanListHandler<Datas>(Datas.class),params);
			for (Datas data : list) {
			int timeid=data.getTimeid();
			Times times = dao.getTimesById(timeid);
			listtimes.add(times);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listtimes;
	}
	  public int  getCountCity(){
		  QueryRunner queryRunner = JDBCUtils.getQueryRunner();
		  String sql = "select count(*) from city_table";
		  Map<String, Object> map = null;
		  int count=0;
		 
		try {
			//map = queryRunner.query(sql, new MapHandler());
			int count1= ((Long)queryRunner.query(sql, new ScalarHandler())).intValue();
			count=count1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return count;
	  }
	
	public String JsonAllTimeAllCityIndex(int indexid) {
		List<Object>  list=new ArrayList<Object>();
		ArrayList<String> timeslist=new ArrayList<String>();
		List<Datas> list2=new ArrayList<Datas>();
		HashMap<String,Object> map=new HashMap<String, Object>();
		JSONObject jsonObject=new JSONObject();
		String result=null;
		DataDealDao dao=new DataDealDaoIml();
		Indexs index = dao.getIndexsById(indexid);
		map.put("indexInfo",index);
		//获取一个指标下的所有季度值
		ArrayList<Times> times = dao.getOneIndTimes(indexid);
		for (Times times2 : times) {
			String timeString = times2.getTime();
			timeslist.add(timeString);
		}
		map.put("allTimes",timeslist);
		//对全部城市进行遍历
		int citycount = dao.getCountCity();
		for (int i = 1; i <=citycount; i++) {
		ArrayList<Float> dataslist=new ArrayList<Float>();
		//获取该城市名
			String	Cityname=null;
			Citys city = dao.getCitysById(i); 
		    Cityname=city.getcName();
		//获取每个城市所有季度的值
			list2=dao.getAllTimeCityIndex(indexid,i);
		//对获取的值进行加工组合
			
			for (Datas datas : list2) {
				
				Float d = datas.getDatas();
				dataslist.add(d);
			}
			Zhexian zhexian=new Zhexian();
			zhexian.setCityName(Cityname);
			zhexian.setDataList(dataslist);
		    list.add(zhexian);
		}
		 map.put("cityScore", list);
		jsonObject.put("lineData",map);
		result=JSON.toJSONString(jsonObject);
		return result;
	}
	public Module getModuleById(int id) {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = JDBCUtils.getQueryRunner();
		Module module=null;
		String sql="SELECT * FROM module_table where id=?";
		try {
			 module = queryRunner.query(sql,new BeanHandler<Module>(Module.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return module;
	}
	@Override
	public ArrayList<Indexs> getIndexsInModule(int moduleid) {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = JDBCUtils.getQueryRunner();
		String sql="SELECT * FROM zb_table WHERE moduleid=?";
		Object[] params={moduleid};
		List<Indexs> list=new ArrayList<Indexs>();
	    try {
			list = queryRunner.query(sql,new BeanListHandler<Indexs>(Indexs.class),params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return (ArrayList<Indexs>) list;
	}
	@Override
	public ArrayList<Datas> getIndexInModuleOneTime(int timeid, int moduleid) {
		// TODO Auto-generated method stub
		DataDealDao dao=new DataDealDaoIml();
		QueryRunner queryRunner = JDBCUtils.getQueryRunner();
		ArrayList<Datas> list =new ArrayList<Datas>();
		ArrayList<Indexs> indexslist = dao.getIndexsInModule(moduleid);
		for (Indexs indexs2 : indexslist) {
			int indexid=indexs2.getIid();
			String sql="SELECT * FROM data_table WHERE indexid=? and timeid=? and cityid=9";
			Object[] params={indexid,timeid};
			try {
				Datas data = queryRunner.query(sql,new BeanHandler<Datas>(Datas.class),params);
			    list.add(data);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	@Override
	public float getValue(float datas, float Allscore, float weight) {
	  float value=0;
	  value=(datas/Allscore)*weight;
	  int   scale  = 3;//设置位数  
	  int   roundingMode  =  4;//表示四舍五入，可以选择其他舍值方式，例如去尾，等等.  
	  BigDecimal   bd  =   new  BigDecimal((double)value);  
	  bd   =  bd.setScale(scale,roundingMode);  
	  value   =  bd.floatValue(); 
	  return value;
	}
	@Override
	public String getJsonIndexFromModule(int moduleid, int timeid) {
		DataDealDao dao=new DataDealDaoIml();
		HashMap<String,Object> map=new HashMap<String, Object>();
		String result=null;
		ArrayList<Datas> listdata=dao.getIndexInModuleOneTime(timeid, moduleid);
		Times times = dao.getTimesById(timeid);
		map.put("indexCycle",times);
		Module module = dao.getModuleById(moduleid);
		map.put("Module",module);
		ArrayList<IndexsOfModule> list=new ArrayList<IndexsOfModule>();
		for (Datas datas : listdata) {
			if(datas!=null){
				float d1 = datas.getDatas();
				int indexid=datas.getIndexid();
				Indexs index = dao.getIndexsById(indexid);
				String indexname=index.getIndexName();
				datas.setIndexName(indexname);
				float weight=index.getQweight();
				float allscore=100;
			    float value=dao.getValue(d1, allscore, weight);
			    datas.setDatas(value);
			    IndexsOfModule indexsOfModule=new IndexsOfModule(allscore, value, indexname, weight);
			    list.add(indexsOfModule);
			}
		}
		map.put("IndexValue",list);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("IndexsOfModule", map);
	    result=	JSON.toJSONString(jsonObject);
		return result;
	}
	@Override
	public ArrayList<Module> getAllModules() {
		QueryRunner queryRunner = JDBCUtils.getQueryRunner();
		String sql="SELECT * FROM module_table";
		List<Module> list=new ArrayList<Module>();
		try {
			 list = queryRunner.query(sql,new BeanListHandler<Module>(Module.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (ArrayList<Module>) list;
	}
	public String getJsonAllModuleVAlue(int timeid) {
		HashMap<String,Object> map=new HashMap<String, Object>();
		String result=null;
		DataDealDao dao=new DataDealDaoIml();
		Times times = dao.getTimesById(timeid);
		map.put("times",times);
		ArrayList<Module> listModules = dao.getAllModules();
		for (Module module : listModules) {
			int moduleid=module.getId();
			//算出每个模块下小指标的中和
			float sum = dao.getIndexSumForOneModel(moduleid, timeid);
			module.setSum(sum);
			float weight=module.getWeight();
			//模拟每个模块的满分
			float Allscore=200;
			module.setAllscore(Allscore);
			float value = dao.getValue(sum, Allscore, weight);
			module.setValue(value);
		}
		map.put("listModules", listModules);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("AllModul",map);
		result=JSON.toJSONString(jsonObject);
		return result;
	}
	
	@Override
	public float getIndexSumForOneModel(int moduleid, int timeid) {
		float sum=0;
		DataDealDao dao=new DataDealDaoIml();
		ArrayList<Datas> listdata=dao.getIndexInModuleOneTime(timeid, moduleid);
		System.out.println(listdata.toString());
		for (Datas datas : listdata) {
			if(datas!=null){
				if(datas.getDatas()!=null){
					float d1 = datas.getDatas();
					System.out.println(d1);
					sum=sum+d1;
				}
			}
			
		}
		System.out.println("listsize:"+listdata.size());
		System.out.println("sum:"+sum);
		return sum;
	}
	@Override
	public String getJSonAllCity() {
		DataDealDao dao=new DataDealDaoIml();
		ArrayList<Citys> allCity = dao.getAllCity();
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("Allcity", allCity);
		String result = JSON.toJSONString(jsonObject);
		return result;
	}

	@Override
	public String getJSonAllTime() {
		DataDealDao dao=new DataDealDaoIml();
		ArrayList<Times> allTimes = dao.getAllTimes();
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("Alltime", allTimes);
		String result = JSON.toJSONString(jsonObject);
		return result;
	}
	public ArrayList<Indexs> getAllIndexs(){
		ArrayList<Indexs> list=null;
		String sql ="select * from zb_table";
		QueryRunner queryRunner = JDBCUtils.getQueryRunner();
		try {
			 list = (ArrayList<Indexs>) queryRunner.query(sql,new BeanListHandler<Indexs>(Indexs.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public String getJSonAllIndexs() {
		DataDealDao dao=new DataDealDaoIml();
		ArrayList<Indexs> indexs = dao.getAllIndexs();
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("AllIndexs", indexs);
		String result = JSON.toJSONString(jsonObject);
		return result;
	}

	@Override
	public String getJsonAllModules() {
		DataDealDao dao=new DataDealDaoIml();
		ArrayList<Module> module= dao.getAllModules();
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("AllModule", module);
		String result = JSON.toJSONString(jsonObject);
		return result;
	}

	
	
}
