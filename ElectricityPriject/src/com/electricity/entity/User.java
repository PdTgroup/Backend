package com.electricity.entity;

public class User {
	private int id;// 用户id
	private int deptid;// 所属部门id
	private String username;// 用户名
	private String password;// 密码
	private String phone;// 手机号码
	private String email;// 邮箱地址
	private String name;// 姓名
	private boolean islocked;// 是否锁定
	private String rolesString;
	public int getId() {
		return id;
	}

	public String getRolesString() {
		return rolesString;
	}

	public void setRolesString(String rolesString) {
		this.rolesString = rolesString;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public boolean isIslocked() {
		return islocked;
	}

	public void setIslocked(boolean islocked) {
		this.islocked = islocked;
	}

	public User(int id, int deptid, String username, String password, String phone, String email, String name,
			boolean islocked) {
		super();
		this.id = id;
		this.deptid = deptid;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.name = name;
		this.islocked = islocked;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", deptid=" + deptid + ", username=" + username + ", password=" + password
				+ ", phone=" + phone + ", email=" + email + ", name=" + name + ", islocked=" + islocked + "]";
	}

}
