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
	// ��ӹ���Ա
	public void addCommonAdmin(Role role) throws SQLException;
   /***********��ɫ************/
	// ����ĳ����ɫ
	Role findRole(int id) throws SQLException;

	// �鿴���н�ɫ
	public List<Role> getAllRole() throws SQLException;
	
	//Json ��ѯ���н�ɫ
	public String getJSonAllRole();
   /********Ȩ��************/
	// ���Ȩ��
	public void addPrivilege(Authority authority) throws SQLException;

	// ���ҵ���Ȩ��
	public Authority findAuthority(int id) throws SQLException;

	// ��ȡ���е�Ȩ��
	public List<Authority> getAllAuthoritys() throws SQLException;
	/********�û�************/
	// ����û�
	public void addUser(User user) throws SQLException;

	// �������Ʋ��ҵ����û�
	public User findUser(String name) throws SQLException;

	// ����id��ѯ�����û�
	public User findUser(int id) throws SQLException;

	// ���������û�
	public List<User> getAllUser() throws SQLException;

	//Json ���������û�����Ӧ��ɫ
	public String getJSonAllUserAndRole();
	// �õ���ǰ�û���ӵ�еĽ�ɫ
	public List<Role> getAllUserRoles(int user_id) throws SQLException;

	// �õ���ǰ��ɫ��ӵ�е�Ȩ��
	public List<Authority> getAllRoleAuthoritys(int role_id) throws SQLException;

	// �����û��Ľ�ɫ
	public void addRoleUser(User user, List<Role> roles) throws SQLException;

	// ���½�ɫ��Ȩ��
	public void addAuthoriesRole(Role role, List<Authority> authorites) throws SQLException;

	// ��������Ա��¼
	public SuperAdmin superAdminLogin(String username, String password) throws SQLException;

	// ��ѯ�û����ܼ�¼��
	public int totalCount() throws SQLException;

	// ��ǰҳ�Ľ�ɫ����
	List<Role> roleList(Integer begin, Integer pageSize) throws SQLException;

	// ��ҳ��ѯ,begin��pageSize�ֱ����ӵڼ�����ʼ�Լ�ÿҳ��ʾ��������
	public List<User> userList(Integer begin, Integer pageSize) throws SQLException;

	// ��ͨ�û����ܵ�¼
	//public User userDecodeLogin(String username, String password) throws SQLException, ClassNotFoundException;

	// ��ͨ�û����ܵ�¼
	//public User userPassword(String username) throws SQLException, ClassNotFoundException;

	// ����������ѯ��ɫ
	Role findRole(String roleName) throws SQLException;

	// ��ѯrole������
	int roleTotalCount() throws SQLException;
	//Json ĳ����ɫ�����õ�Ȩ��
	public String getJsonOneRoleAllAuty(int roleid);
     /*******�˵�********/
	//Id ��ѯһ��Menu
	public Menu getMenubyId(int menuid);
	//��ѯ����һ���˵�
	public List<Menu> getAllFirMenu();
	//JSon ��ȡ����һ���˵���JSOn����
	public String getJSonAllFirMenu();
    //���ݸ����˵���ѯ��Ӧ�Ĵμ��Ӳ˵�
	public List<Menu> getAllMenuUndOnePar(int parid);
	//JSon ��ȡ�����˵��¶�Ӧ�����дμ��˵���Json����
	public String getJsonAllMenuUndPar(int parid);
	

	

}
