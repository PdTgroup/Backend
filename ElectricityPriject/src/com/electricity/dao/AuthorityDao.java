package com.electricity.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.electricity.entity.Authority;
import com.electricity.entity.Menu;
import com.electricity.entity.Paging;
import com.electricity.entity.Role;
import com.electricity.entity.SuperAdmin;
import com.electricity.entity.User;

public interface AuthorityDao {
	// 添加管理员
	public void addCommonAdmin(Role role) throws SQLException;
   /***********角色************/
	// 查找某个角色
	Role findRole(int id) throws SQLException;

	// 查看所有角色
	public List<Role> getAllRole() throws SQLException;
	
	//Json 查询所有角色
	public String getJSonAllRole();
   /********权限************/
	// 添加权限
	public void addPrivilege(Authority authority) throws SQLException;

	// 查找单个权限
	public Authority findAuthority(int id) throws SQLException;

	// 获取所有的权限
	public List<Authority> getAllAuthoritys() throws SQLException;
	/********用户************/
	// 添加用户
	public void addUser(User user) throws SQLException;

	// 根据名称查找单个用户
	public User findUser(String name) throws SQLException;

	// 根据id查询单个用户
	public User findUser(int id) throws SQLException;

	// 查找所有用户
	public List<User> getAllUser() throws SQLException;

	//Json 查找所有用户及对应角色
	public String getJSonAllUserAndRole();
	// 得到当前用户所拥有的角色
	public List<Role> getAllUserRoles(int user_id) throws SQLException;

	// 得到当前角色所拥有的权限
	public List<Authority> getAllRoleAuthoritys(int role_id) throws SQLException;

	// 更新用户的角色
	public void addRoleUser(User user, List<Role> roles) throws SQLException;

	// 更新角色的权限
	public void addAuthoriesRole(Role role, List<Authority> authorites) throws SQLException;

	// 超级管理员登录
	public SuperAdmin superAdminLogin(String username, String password) throws SQLException;

	// 查询用户的总记录数
	public int totalCount() throws SQLException;

	// 当前页的角色集合
	List<Role> roleList(Integer begin, Integer pageSize) throws SQLException;

	// 分页查询,begin和pageSize分别代表从第几条开始以及每页显示几条数据
	public List<User> userList(Integer begin, Integer pageSize) throws SQLException;

	// 普通用户解密登录
	//public User userDecodeLogin(String username, String password) throws SQLException, ClassNotFoundException;

	// 普通用户解密登录
	//public User userPassword(String username) throws SQLException, ClassNotFoundException;

	// 根据姓名查询角色
	Role findRole(String roleName) throws SQLException;

	// 查询role总条数
	int roleTotalCount() throws SQLException;
	//Json 某个角色及对用的权限
	public String getJsonOneRoleAllAuty(int roleid);
     /*******菜单********/
	//Id 查询一个Menu
	public Menu getMenubyId(int menuid);
	//查询所有一级菜单
	public List<Menu> getAllFirMenu();
	//JSon 获取所有一级菜单的JSOn数据
	public String getJSonAllFirMenu();
    //根据父级菜单查询相应的次级子菜单
	public List<Menu> getAllMenuUndOnePar(int parid);
	//JSon 获取父级菜单下对应的所有次级菜单的Json数据
	public String getJsonAllMenuUndPar(int parid);
	

	

}
