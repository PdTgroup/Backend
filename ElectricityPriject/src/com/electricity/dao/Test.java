package com.electricity.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.electricity.entity.Authority;
import com.electricity.entity.Citys;
import com.electricity.entity.Menu;
import com.electricity.entity.Role;
import com.electricity.tool.MysessionFactory;


public class Test {
	public static void main(String[] args) throws SQLException {
	AuthorityDao  dao=new AuthorityDaoImpl();
	  String Jsonrole = dao.getJSonAllUserAndRole();
	  System.out.println(Jsonrole);
	      
	}
}
