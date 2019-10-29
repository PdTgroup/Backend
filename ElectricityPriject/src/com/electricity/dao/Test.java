package com.electricity.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.electricity.entity.Datas;
import com.electricity.entity.Indexs;
import com.electricity.entity.Module;
import com.electricity.entity.Times;
import com.electricity.service.Jsonservice;
import com.sun.javafx.collections.MappingChange.Map;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class Test {
	
public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
	
/*
	Jsonservice service=new Jsonservice();
	String chart = service.getJSonAllIndexs();
	System.out.println(chart);*/
	DataDealDao dao=new DataDealDaoIml();
	/*ArrayList<Times> list = dao.getOneIndTimes(2);
	System.out.println(list.toString());*/
	String string = dao.JsonAllTimeAllCityIndex(2);
	System.out.println(string);
	
}		
	
}
