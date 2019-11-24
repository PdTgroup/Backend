package com.electricity.tool;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MysessionFactory {
	
	/**
	 * ����sessionFactory��ȡ������
	 * ����sessionFactory�����У���������ر����Դ��
     *��hibernate�����У�����һ����Ŀһ�㴴��һ��sessionFactory���� 
	 * ***/
	static Configuration cfg=null;
	static SessionFactory sessionFactory=null;
	static Session session =null;
	
	static{
		//���غ��������ļ�
		 cfg=new Configuration();
		 cfg.configure();
		 //����SessionFactory,�������ݿ�
		 sessionFactory = cfg.buildSessionFactory();
		
	}
	
	public static SessionFactory creatSessionFactory(){
		
		return sessionFactory;
	}
	//��ȡ��ǰ�̵߳�session
	public static Session creatSessionObject(){
		
		return sessionFactory.getCurrentSession();
		
		
	}
	public static void main(String[] args) {
		System.out.println(sessionFactory.getCurrentSession());
	}
	
}
