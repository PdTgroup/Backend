package com.electricity.restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
@Path("UserInfoService")
public class RestfulTest {
	@GET
	// 这里@Path定义了类的层次路径。指定了资源类提供服务的URI路径。
	@Path("/name/{i}")
	// @Produces定义了资源类方法会生成的媒体类型。
	@Produces(MediaType.TEXT_XML)
	// @PathParam向@Path定义的表达式注入URI参数值。
	public String userName(@PathParam("i") String i) {
	String name = i;
	return "<User>" + "<Name>" + name + "</Name>" + "</User>";
	}
}
