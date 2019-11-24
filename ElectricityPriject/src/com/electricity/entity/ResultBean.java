package com.electricity.entity;

import java.util.Collection;

import com.alibaba.fastjson.JSONObject;

public class ResultBean<T>{
	
    private int code; 
    private String message; 
    private JSONObject data;
    
	
	public JSONObject getData() {
		return data;
	}
	public void setData(JSONObject data) {
		this.data = data;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public ResultBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	
	public static ResultBean error(int code, String message) { 
        ResultBean resultBean = new ResultBean(); 
        resultBean.setCode(code); 
        resultBean.setMessage(message); 
        return resultBean; 
    } 
    public static ResultBean success() { 
        ResultBean resultBean = new ResultBean(); 
        resultBean.setCode(0); 
        resultBean.setMessage("success"); 
        return resultBean; 
    } 

   /* public static <V> ResultBean<V> success(Collection<V> data) { 
        ResultBean resultBean = new ResultBean(); 
        resultBean.setCode(0); 
        resultBean.setMessage("success"); 
        resultBean.setData(data); 
        return resultBean; 
    } */
    
    public static ResultBean success(JSONObject data) { 
        ResultBean resultBean = new ResultBean(); 
        resultBean.setCode(0); 
        resultBean.setMessage("success"); 
        resultBean.setData(data); 
        return resultBean; 
    }

}
