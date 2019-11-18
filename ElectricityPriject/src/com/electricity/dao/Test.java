package com.electricity.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.electricity.entity.Citys;
import com.electricity.tool.MysessionFactory;


public class Test {
	public static void main(String[] args) {
	 Session session = MysessionFactory.creatSessionFactory().openSession();
	 Transaction transaction = session.beginTransaction();
	 Citys citys = (Citys) session.load(Citys.class,1);
	 System.out.println(citys);
	 
	}
}
