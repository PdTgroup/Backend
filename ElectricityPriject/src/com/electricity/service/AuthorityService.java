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

	// ����ĳ����ɫ
	public Role findRole(int roleId) throws SQLException {
		return dao.findRole(roleId);
	}
	//Json ĳ����ɫ�����õ�Ȩ��
	public String getJsonOneRoleAllAuty(int roleid){
	 
		return dao.getJsonOneRoleAllAuty(roleid);
	}

	// �鿴���н�ɫ
	public List<Role> getAllRole() throws SQLException {
		return dao.getAllRole();
	}

	// ���ҵ���Ȩ��
	public Authority findAuthority(int id) throws SQLException {
		return dao.findAuthority(id);
	}

	// ��ȡ���е�Ȩ��
	public List<Authority> getAllAuthoritys() throws SQLException {
		return dao.getAllAuthoritys();
	}
	/*//Json����    ����Ȩ��
	public String getJsonAllAuthoritys() throws SQLException {
		return dao.getJsonAllAuthoritys();
	}*/

	// �������Ʋ��ҵ����û�
	public User findUser(String userName) throws SQLException {
		return dao.findUser(userName);
	}

	// ����id��ѯ�����û�
	public User findUser(int id) throws SQLException {
		return dao.findUser(id);
	}

	// ���������û�
	public List<User> getAllUser() throws SQLException {
		return dao.getAllUser();
	}

	// �õ���ǰ�û���ӵ�еĽ�ɫ
	public List<Role> getAllUserRoles(int user_id) throws SQLException {
		return dao.getAllUserRoles(user_id);
	}

	// �õ���ǰ��ɫ��ӵ�е�Ȩ��
	public List<Authority> getAllRoleAuthoritys(int role_id) throws SQLException {
		return dao.getAllRoleAuthoritys(role_id);

	}

	// �����û��Ľ�ɫ
	public void addRoleUser(User user, List<Role> roles) throws SQLException {
		dao.addRoleUser(user, roles);
	}

	// ���½�ɫ��Ȩ��
	public void addAuthoriesRole(Role role, List<Authority> authorites) throws SQLException {
		dao.addAuthoriesRole(role, authorites);
	}

	// ����������ѯ��ɫ
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
