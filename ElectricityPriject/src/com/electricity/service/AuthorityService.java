package com.electricity.service;

import java.sql.SQLException;
import java.util.List;

import com.electricity.dao.AuthorityDao;
import com.electricity.dao.AuthorityDaoImpl;
import com.electricity.entity.Authority;
import com.electricity.entity.Role;
import com.electricity.entity.User;

public class AuthorityService {
	private AuthorityDao dao = new AuthorityDaoImpl();

	// 查找某个角色
	public Role findRole(int roleId) throws SQLException {
		return dao.findRole(roleId);
	}
	//Json 某个角色及对用的权限
	public String getJsonOneRoleAllAuty(int roleid){
	 
		return dao.getJsonOneRoleAllAuty(roleid);
	}

	// 查看所有角色
	public List<Role> getAllRole() throws SQLException {
		return dao.getAllRole();
	}

	// 查找单个权限
	public Authority findAuthority(int id) throws SQLException {
		return dao.findAuthority(id);
	}

	// 获取所有的权限
	public List<Authority> getAllAuthoritys() throws SQLException {
		return dao.getAllAuthoritys();
	}
	/*//Json数据    所有权限
	public String getJsonAllAuthoritys() throws SQLException {
		return dao.getJsonAllAuthoritys();
	}*/

	// 根据名称查找单个用户
	public User findUser(String userName) throws SQLException {
		return dao.findUser(userName);
	}

	// 根据id查询单个用户
	public User findUser(int id) throws SQLException {
		return dao.findUser(id);
	}

	// 查找所有用户
	public List<User> getAllUser() throws SQLException {
		return dao.getAllUser();
	}

	// 得到当前用户所拥有的角色
	public List<Role> getAllUserRoles(int user_id) throws SQLException {
		return dao.getAllUserRoles(user_id);
	}

	// 得到当前角色所拥有的权限
	public List<Authority> getAllRoleAuthoritys(int role_id) throws SQLException {
		return dao.getAllRoleAuthoritys(role_id);

	}

	// 更新用户的角色
	public void addRoleUser(User user, List<Role> roles) throws SQLException {
		dao.addRoleUser(user, roles);
	}

	// 更新角色的权限
	public void addAuthoriesRole(Role role, List<Authority> authorites) throws SQLException {
		dao.addAuthoriesRole(role, authorites);
	}

	// 根据姓名查询角色
	public Role findRole(String roleName) throws SQLException {
		return dao.findRole(roleName);
	}

	public Integer totalCount() throws SQLException {
		// TODO Auto-generated method stub
		return dao.totalCount();
	}

	public List<User> userList(Integer begin, Integer pageSize) throws SQLException {
		// TODO Auto-generated method stub
		return dao.userList(begin, pageSize);
	}

	public int roleTotalCount() throws SQLException {
		// TODO Auto-generated method stub
		return dao.roleTotalCount();
	}

	public List<Role> roleList(Integer begin, Integer pageSize) throws SQLException {
		// TODO Auto-generated method stub
		return dao.roleList(begin, pageSize);
	}

	public void addCommonAdmin(Role commonAdmin) throws SQLException {
		// TODO Auto-generated method stub
		dao.addCommonAdmin(commonAdmin);
	}
  
	
	

}
