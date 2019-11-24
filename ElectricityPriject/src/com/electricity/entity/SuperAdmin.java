package com.electricity.entity;

import java.util.HashSet;
import java.util.Set;

public class SuperAdmin {
	private int superId;// 编号
	private String superAdminname;// 超级管理员姓名
	private String superAdminpassword;// 超级管理员密码
	private Set<Role> commonAdmins = new HashSet<Role>();// 超级管理员所管理的角色

	public int getSuperId() {
		return superId;
	}

	public void setSuperId(int superId) {
		this.superId = superId;
	}

	public String getSuperAdminname() {
		return superAdminname;
	}

	public void setSuperAdminname(String superAdminname) {
		this.superAdminname = superAdminname;
	}

	public String getSuperAdminpassword() {
		return superAdminpassword;
	}

	public void setSuperAdminpassword(String superAdminpassword) {
		this.superAdminpassword = superAdminpassword;
	}

	public Set<Role> getCommonAdmins() {
		return commonAdmins;
	}

	public void setCommonAdmins(Set<Role> commonAdmins) {
		this.commonAdmins = commonAdmins;
	}

	public SuperAdmin(int superId, String superAdminname, String superAdminpassword, Set<Role> commonAdmins) {
		super();
		this.superId = superId;
		this.superAdminname = superAdminname;
		this.superAdminpassword = superAdminpassword;
		this.commonAdmins = commonAdmins;
	}

	public SuperAdmin() {
		super();
	}

}
