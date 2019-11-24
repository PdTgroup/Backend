package com.electricity.dao;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
import com.electricity.tool.MysessionFactory;

public class DataDealImpl   implements DataDealDao {
	@Override
	public Citys getCitysById(int cid) {
		// TODO Auto-generated method stub
		Session session = MysessionFactory.creatSessionObject();
		Transaction ts=null;
		Citys citys=null;
	     try {
			 ts = session.beginTransaction();
			 citys = (Citys) session.get(Citys.class,cid);
			 ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ts.rollback();
		}
		return citys ;
	}
	@Override
	public Times getTimesById(int tid) {
		Session session = MysessionFactory.creatSessionObject();
		Transaction ts=null;
		Times times=null;
	     try {
			 ts = session.beginTransaction();
			 times = (Times) session.get(Times.class,tid);
			 ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ts.rollback();
		}
		return times ;
	}

	@Override
	public Indexs getIndexsById(int id) {
		Session session = MysessionFactory.creatSessionObject();
		Transaction ts=null;
		Indexs indexs=null;
	     try {
			 ts = session.beginTransaction();
			 indexs = (Indexs) session.get(Indexs.class,id);
			 ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ts.rollback();
		}
		return indexs ;
	}

	@Override
	public Module getModuleById(int id) {
		Session session = MysessionFactory.creatSessionObject();
		Transaction ts=null;
		Module module=null;
	     try {
			 ts = session.beginTransaction();
			 module = (Module) session.get(Module.class,id);
			 ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ts.rollback();
		}
		return module ;
	}

	@Override
	public ArrayList<Indexs> getIndexsInModule(int moduleid) {
		// TODO Auto-generated method stub
		Session session = MysessionFactory.creatSessionObject();
		Transaction ts=null;
		ArrayList<Indexs> list =null;
	     try {
			 ts = session.beginTransaction();
			Query query = session.createQuery("from Indexs where module.id=?");
			query.setParameter(0,moduleid);
			 list = (ArrayList<Indexs>) query.list();
			 ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ts.rollback();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Datas> getAllCityIndexTime(int timeid, int indexid) {
		Session session = MysessionFactory.creatSessionObject();
		Transaction ts=null;
		ArrayList<Datas> list =null;
	     try {
			 ts = session.beginTransaction();
			Query query = session.createQuery("FROM Datas WHERE time.Tid=? and index.Iid=?");
			query.setParameter(0,timeid);
			query.setParameter(1,indexid);
			list = (ArrayList<Datas>) query.list();
			ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ts.rollback();
		}
		return list;
	}

	@Override
	public JSONObject JsongetAllCityIndexTime(int timeid, int indexid) {
		JSONObject jsonObject=new JSONObject();
		DataDealDao dao=new DataDealImpl();
		Indexs index = dao.getIndexsById(indexid);
		Times time = dao.getTimesById(timeid);
		jsonObject.put("indexInfo", index);
		jsonObject.put("indexCycle", time);
		ArrayList<Datas> list = dao.getAllCityIndexTime(timeid, indexid);
		ArrayList<Zhuzhuang> Zhulist=new  ArrayList<Zhuzhuang>();
		for (Datas datas : list) {
		    int cid =datas.getCity().getCid();
			String cityName = dao.getCitysById(cid).getcName();
			float data = datas.getDatas();
			Zhuzhuang z=new Zhuzhuang();
			z.setCityName(cityName);
			z.setDatas(data);
			Zhulist.add(z);
		}
		jsonObject.put("cityScore", Zhulist);
		return jsonObject;
	}

	@Override
	public ArrayList<Datas> getAllTimeCityIndex(int indexid, int cityid) {
		Session session = MysessionFactory.creatSessionObject();
		Transaction ts=null;
		ArrayList<Datas> list =null;
	     try {
			 ts = session.beginTransaction();
			Query query = session.createQuery("FROM Datas WHERE index.Iid=? and city.cid=?");
			query.setParameter(0,indexid);
			query.setParameter(1,cityid);
			list = (ArrayList<Datas>) query.list();
			ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ts.rollback();
		}
		return list;				
		
	}

	@Override
	public ArrayList<ArrayList<Datas>> getAllTimeAllCityIndex(int indexid) {
		List<ArrayList<Datas>>  list=new ArrayList<ArrayList<Datas>>();
		DataDealDao dao=new DataDealImpl();
		List<Datas> list2=null;
		int citycurrent = dao.getCountCity();
		if(citycurrent!=0){
			for (int i = 1; i <= citycurrent; i++) {
				list2=dao.getAllTimeCityIndex(indexid,i);
				list.add((ArrayList<Datas>) list2);
			}
		}
		return (ArrayList<ArrayList<Datas>>) list;
	}

	@Override
	public JSONObject JsonAllTimeAllCityIndex(int indexid) {
		List<Object>  list=new ArrayList<Object>();
		ArrayList<String> timeslist=new ArrayList<String>();
		List<Datas> list2=new ArrayList<Datas>();
		JSONObject jsonObject=new JSONObject();
		DataDealDao dao=new DataDealImpl();
		Indexs index = dao.getIndexsById(indexid);
		jsonObject.put("indexInfo",index);
		//获取一个指标下的所有季度值
		ArrayList<Times> times = dao.getOneIndTimes(indexid);
		for (Times times2 : times) {
			String timeString = times2.getTime();
			timeslist.add(timeString);
		}
		jsonObject.put("allTimes",timeslist);
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
		jsonObject.put("cityScore", list);
		return jsonObject;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Datas> getIndexInModuleOneTime(int timeid, int moduleid) {
		DataDealDao dao=new DataDealImpl();
		ArrayList<Datas> list =new ArrayList<Datas>();
		ArrayList<Indexs> indexslist = dao.getIndexsInModule(moduleid);
		
		for (Indexs indexs2 : indexslist) {
			ArrayList<Datas> listdata =new ArrayList<Datas>();
			Datas datas=null;
			int indexid=indexs2.getIid();
			System.out.println("indexid"+indexid);
			System.out.println();
			Session session = MysessionFactory.creatSessionObject();
			Transaction ts=null;
		     try {
				ts = session.beginTransaction();
				Query query = session.createQuery("FROM Datas WHERE index.Iid=? and time.Tid=? and city.cid=1");
				query.setParameter(0,indexid);
				query.setParameter(1,timeid);
				listdata = (ArrayList<Datas>) query.list();
				if(listdata.size()!=0&&listdata!=null){
					list.add(listdata.get(0));
				}
				ts.commit();
			} catch (Exception e) {
				e.printStackTrace();
				ts.rollback();
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
	public JSONObject getJsonIndexFromModule(int moduleid, int timeid) {
		DataDealDao dao=new DataDealImpl();
		JSONObject jsonObject=new JSONObject();
		ArrayList<Datas> listdata=dao.getIndexInModuleOneTime(timeid, moduleid);
		Times times = dao.getTimesById(timeid);
		jsonObject.put("indexCycle",times);
		Module module = dao.getModuleById(moduleid);
		jsonObject.put("Module",module);
		ArrayList<IndexsOfModule> list=new ArrayList<IndexsOfModule>();
		System.out.println(listdata.size());
		if(listdata!=null){
			for (Datas datas : listdata) {
				if(datas!=null){
					float d1 = datas.getDatas();
					int indexid=datas.getIndex().getIid();
					String indexname=datas.getIndex().getIndexName();
					float qweight = datas.getIndex().getQweight();
					//设指标的满分值为100
					float allscore=100;
					System.out.println("datas:"+d1+"allscore:"+allscore+"qweight:"+qweight);
				    float value=dao.getValue(d1, allscore, qweight);
				    datas.setDatas(value);
				    IndexsOfModule indexsOfModule=new IndexsOfModule(allscore, value, indexname, qweight);
				    list.add(indexsOfModule);
				}
			}
		}
		jsonObject.put("IndexValue",list);
		return jsonObject;
	}

	@Override
	public float getIndexSumForOneModel(int moduleid, int timeid) {
		float sum=0;
		DataDealDao dao=new DataDealImpl();
		ArrayList<Datas> listdata=dao.getIndexInModuleOneTime(timeid, moduleid);
		for (Datas datas : listdata) {
			if(datas!=null){
				if(datas.getDatas()!=null){
					float d1 = datas.getDatas();
					System.out.println(d1);
					sum=sum+d1;
				}
			}
			
		}
		return sum;
	}

	@Override
	public ArrayList<Module> getAllModules() {
		Session session = MysessionFactory.creatSessionObject();
		Transaction ts=null;
		 List<Module> list=null;
	     try {
			 ts = session.beginTransaction();
			 //业务处理
			 Query query = session.createQuery("from Module");
			 list = query.list();
			 ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ts.rollback();
		}
	
		return (ArrayList<Module>) list;
	}

	@Override
	public JSONObject getJsonAllModuleVAlue(int timeid) {
		DataDealDao dao=new DataDealImpl();
		JSONObject jsonObject=new JSONObject();
		Times times = dao.getTimesById(timeid);
		jsonObject.put("indexCycle",times);
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
		jsonObject.put("ModuleValue", listModules);
		return jsonObject;
	}

	@Override
	public JSONObject getJSonAllCity() {
		DataDealDao dao=new DataDealImpl();
		ArrayList<Citys> allcity = dao.getAllCity();
		if(allcity!=null){
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("Allcity", allcity);
			return jsonObject;
		}
		return null;
	}
	

	@Override
	public ArrayList<Citys> getAllCity() {
		Session session = MysessionFactory.creatSessionObject();
		Transaction ts=null;
		List<Citys> list=null;
	     try {
			 ts = session.beginTransaction();
			 //业务处理
			 Query query = session.createQuery("from Citys");
			 list = query.list();
			 ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ts.rollback();
		}
		
		return (ArrayList<Citys>) list;
	}

	@Override
	public ArrayList<Times> getAllTimes() {
		Session session = MysessionFactory.creatSessionObject();
		Transaction ts=null;
		 List<Times> list=null;
	     try {
			 ts = session.beginTransaction();
			 //业务处理
			 Query query = session.createQuery("from Times");
			 list = query.list();
			 ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ts.rollback();
		}
		
		return  (ArrayList<Times>) list;
	}

	@Override
	public JSONObject getJSonAllTime() {
		DataDealDao dao=new DataDealImpl();
		ArrayList<Times> allTimes = dao.getAllTimes();
		if(allTimes!=null){
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("Alltime", allTimes);
			return jsonObject;
		}
		return null;
	}

	@Override
	public ArrayList<Indexs> getAllIndexs() {
		Session session = MysessionFactory.creatSessionObject();
		Transaction ts=null;
		List<Indexs> list=null;
	     try {
			 ts = session.beginTransaction();
			 Query query = session.createQuery("from Indexs");
			 list = query.list();
			 //业务处理
			 ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		}
		return (ArrayList<Indexs>) list;
	}

	@Override
	public JSONObject getJSonAllIndexs() {
		DataDealDao dao=new DataDealImpl();
		ArrayList<Indexs> allindexs = dao.getAllIndexs();
		if(allindexs!=null){
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("Allindexs", allindexs);
			return jsonObject;
		}
		return null;
	}

	@Override
	public JSONObject getJsonAllModules() {
		DataDealDao dao=new DataDealImpl();
		ArrayList<Module> allmodule = dao.getAllModules();
		if(allmodule!=null){
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("Allmodule", allmodule);
			return jsonObject;
		}
		return null;
	}

	@Override
	public ArrayList<Times> getOneIndTimes(int indexid) {
		Session session = MysessionFactory.creatSessionObject();
		DataDealDao dao=new DataDealImpl();
		
		Transaction ts=null;
		 List<Integer> list=null;
		 ArrayList<Times> listtimes=new ArrayList<Times>();
	     try {
			 ts = session.beginTransaction();
			 Query query = session.createQuery("select time.Tid from Datas where index.Iid=? and city.cid=1");
			 query.setParameter(0,indexid);
			  list = query.list();
			 //业务处理
			 ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ts.rollback();
		}
	for (Integer timeid : list) {
		Times times = dao.getTimesById(timeid);
		listtimes.add(times);
	}
		return listtimes;
	}
	@Override
	public int getCountCity() {
		Session session = MysessionFactory.creatSessionObject();
		Transaction ts=null;
		int i=0;
	     try {
			 ts = session.beginTransaction();
			 Query query = session.createQuery("select count(*) from Citys");
			 Long result = (Long) query.uniqueResult();
			 i=result.intValue();
			 //业务处理
			 ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ts.rollback();
		}
		return i;
	}
	}
	
	


