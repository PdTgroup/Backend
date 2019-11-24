package com.electricity.tool;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MysessionFactory {
	
	/**
	 * 创建sessionFactory提取工具类
	 * 创建sessionFactory过程中，这个过程特别耗资源的
     *在hibernate操作中，建议一个项目一般创建一个sessionFactory对象 
	 * ***/
	static Configuration cfg=null;
	static SessionFactory sessionFactory=null;
	static Session session =null;
	
	static{
		//加载核心配置文件
		 cfg=new Configuration();
		 cfg.configure();
		 //创建SessionFactory,创建数据库
		 sessionFactory = cfg.buildSessionFactory();
		
	}
	
	public static SessionFactory creatSessionFactory(){
		
		return sessionFactory;
	}
	//获取当前线程的session
	public static Session creatSessionObject(){
		
		return sessionFactory.getCurrentSession();
		
		
	}
	public static void main(String[] args) {
		System.out.println(sessionFactory.getCurrentSession());
	}
	
}
