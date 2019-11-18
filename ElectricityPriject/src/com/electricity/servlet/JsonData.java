package com.electricity.servlet;
import java.io.BufferedInputStream;


import javax.servlet.http.*;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import com.alibaba.fastjson.JSONObject;
import com.electricity.service.Jsonservice;
@Path("JsonData")
public class JsonData  {
	Jsonservice jsonservice=new Jsonservice();
	
	@GET
	@Path("/allcitys")
	@Produces(MediaType.APPLICATION_JSON)
	public String allCitys(){
		String allcity = jsonservice.getJSonAllCity();
		return allcity;
	}
	
	@GET
	@Path("/allTimes")
	@Produces(MediaType.APPLICATION_JSON)
	public String allTimes(){
		String alltimes = jsonservice.getJsonAllTimes();
		return alltimes;
	}
	
	@GET
	@Path("/allIndexs")
	@Produces(MediaType.APPLICATION_JSON)
	public String Indexs(){
		String allindexs = jsonservice.getJSonAllIndexs();
		return allindexs;
	}
	
	@POST
	@Path("/barChart")
	@Produces(MediaType.APPLICATION_JSON)
	public String barChart(@Context HttpServletRequest request,@Context HttpServletResponse response) throws Exception{
		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setContentType("application/json;charset=utf-8");
		StringBuffer str = new StringBuffer();
        BufferedInputStream in = new BufferedInputStream(request.getInputStream());
        int i;
        char c;
        while ((i = in.read()) != -1) {
            c = (char) i;
            str.append(c);
        }
        String strJson = java.net.URLDecoder.decode(str.toString(),"utf-8");
        JSONObject jsonObject = JSONObject.parseObject(strJson);
        int timeid = jsonObject.getInteger("timeid");
        int indexid=jsonObject.getInteger("indexid");
        String barChart = jsonservice.getBarChart(timeid, indexid);
        return barChart;
	}
	
	@POST
	@Path("/LineChart")
	@Produces(MediaType.APPLICATION_JSON)
	public String LineChart(@Context HttpServletRequest request,@Context HttpServletResponse response) throws Exception{
		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setContentType("application/json;charset=utf-8");
		StringBuffer str = new StringBuffer();
        BufferedInputStream in = new BufferedInputStream(request.getInputStream());
        int i;
        char c;
        while ((i = in.read()) != -1) {
            c = (char) i;
            str.append(c);
        }
        String strJson = java.net.URLDecoder.decode(str.toString(),"utf-8");
        String LineChart =null;
        if(strJson!=null){
        	 JSONObject jsonObject = JSONObject.parseObject(strJson);
             int indexid=jsonObject.getInteger("indexid");
             LineChart = jsonservice.getLineChart(indexid);
        }
        return LineChart;
	}

	@POST
	@Path("/FourModual")
	@Produces(MediaType.APPLICATION_JSON)
	public String FourModual(@Context HttpServletRequest request,@Context HttpServletResponse response) throws Exception{
		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setContentType("application/json;charset=utf-8");
		StringBuffer str = new StringBuffer();
        BufferedInputStream in = new BufferedInputStream(request.getInputStream());
        int i;
        char c;
        while ((i = in.read()) != -1) {
            c = (char) i;
            str.append(c);
        }
        String strJson = java.net.URLDecoder.decode(str.toString(),"utf-8");
        String FourModual=null;
        if(strJson!=null){
        	JSONObject jsonObject = JSONObject.parseObject(strJson);
            int timeid=jsonObject.getInteger("timeid");
            FourModual= jsonservice.getFourModual(timeid);
        }
        return FourModual;
	}
	
	@POST
	@Path("/OneModual")
	@Produces(MediaType.APPLICATION_JSON)
	public String OneModual(@Context HttpServletRequest request,@Context HttpServletResponse response) throws Exception{
		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setContentType("application/json;charset=utf-8");
		StringBuffer str = new StringBuffer();
        BufferedInputStream in = new BufferedInputStream(request.getInputStream());
        int i;
        char c;
        while ((i = in.read()) != -1) {
            c = (char) i;
            str.append(c);
        }
        String strJson = java.net.URLDecoder.decode(str.toString(),"utf-8");
        String OneModual=null;
        if(strJson!=null){
        	 JSONObject jsonObject = JSONObject.parseObject(strJson);
             int timeid=jsonObject.getInteger("timeid");
             int moduleid=jsonObject.getInteger("moduleid");
             OneModual = jsonservice.getIndexForOneModual(moduleid, timeid);
        }
        return OneModual;
	}
	
}
