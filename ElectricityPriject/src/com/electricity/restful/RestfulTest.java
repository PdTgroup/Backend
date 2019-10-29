package com.electricity.restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
@Path("UserInfoService")
public class RestfulTest {
	@GET
	// ����@Path��������Ĳ��·����ָ������Դ���ṩ�����URI·����
	@Path("/name/{i}")
	// @Produces��������Դ�෽�������ɵ�ý�����͡�
	@Produces(MediaType.TEXT_XML)
	// @PathParam��@Path����ı��ʽע��URI����ֵ��
	public String userName(@PathParam("i") String i) {
	String name = i;
	return "<User>" + "<Name>" + name + "</Name>" + "</User>";
	}
}
