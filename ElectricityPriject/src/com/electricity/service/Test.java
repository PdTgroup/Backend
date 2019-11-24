package com.electricity.service;

import java.sql.SQLException;

import com.electricity.entity.Authority;

public class Test {
	public static void main(String[] args) throws SQLException {
		AuthorityService service=new AuthorityService();
		Authority findAuthority = service.findAuthority(1);
		System.out.println(findAuthority.toString());
	}

}
