package com.electricity.entity;

public class Authority {
	private int authorityId;// 权限编号
	private String authorityName;// 权限名称
	private Integer menuid;
	
	

	public Authority(int authorityId, String authorityName, Integer menuid) {
		super();
		this.authorityId = authorityId;
		this.authorityName = authorityName;
		this.menuid = menuid;
	}

	public int getMenuid() {
		return menuid;
	}

	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}

	public Integer getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}

	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}


	public Authority() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Authority [authorityId=" + authorityId + ", authorityName=" + authorityName + ", menuid=" + menuid
				+ "]";
	}



}
