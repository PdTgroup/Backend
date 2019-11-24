package com.electricity.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.electricity.entity.Authority;
import com.electricity.entity.Menu;
import com.electricity.entity.Role;
import com.electricity.entity.SuperAdmin;
import com.electricity.entity.User;
import com.electricity.tool.MysessionFactory;

public class AuthorityDaoImpl implements AuthorityDao {
	/*******角色********/
	// 添加角色
	public void addCommonAdmin(Role role) {
		Session session = MysessionFactory.creatSessionObject();
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			session.save(role);
			ts.commit();
		} catch (HibernateException e) {
			ts.rollback();
			throw new RuntimeException(e.getMessage());
		} 
	}

	
	// 查找单个角色
	public Role findRole(int roleId){
		Session session = MysessionFactory.creatSessionObject();
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			Criteria createCriteria = session.createCriteria(Role.class);
			createCriteria.add(Restrictions.eq("roleId", roleId));
			Role role = (Role) createCriteria.uniqueResult();
			return role;
		} catch (HibernateException e) {
			ts.rollback();
			throw new RuntimeException(e.getMessage());
		} 
	}
	

	
	// 查看所有角色
	public List<Role> getAllRole() throws SQLException {
		// TODO Auto-generated method stub
		Session session = MysessionFactory.creatSessionObject();
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			Query query = session.createQuery("from Role");
			List<Role> list = query.list();
			// 使用forEach遍历集合
			return list;
		} catch (HibernateException e) {
			ts.rollback();
			throw new RuntimeException(e.getMessage());
		} 
	}
	
    //Json 查询所有角色
	public String getJSonAllRole(){
		AuthorityDao dao=new AuthorityDaoImpl();
		JSONObject jsonObject=new JSONObject();
		String result=null;
		List<Role> list;
		try {
			list = dao.getAllRole();
			if(list!=null&&list.size()>0){
				jsonObject.put("ALLRole",list);
				result=JSON.toJSONString(jsonObject);
			}
	        return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	
	// 添加权限
	public void addPrivilege(Authority authority){
		// TODO Auto-generated method stub
		Session session = MysessionFactory.creatSessionObject();
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			session.save(authority);
			ts.commit();
		} catch (HibernateException e) {
			ts.rollback();
			throw new RuntimeException(e.getMessage());
		} 
	}

	
	// 查找单个权限
	public Authority findAuthority(int id) {
		Session session = MysessionFactory.creatSessionObject();
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			Criteria createCriteria = session.createCriteria(Authority.class);
			// 使用createCriteria的eq方法设定查询条件为name="自定义"
			// 向Criteria对象中添加name="自定义"的查询条件
			createCriteria.add(Restrictions.eq("authorityId", id));
			Authority stu = (Authority) createCriteria.uniqueResult();
			return stu;
		} catch (HibernateException e) {
			ts.rollback();
			throw new RuntimeException(e.getMessage());
		} 
	}

	
	// 查看所有权限
	public List<Authority> getAllAuthoritys() {
		// TODO Auto-generated method stub
		Session session = MysessionFactory.creatSessionObject();
		Transaction ts = null;
		List<Authority> list=null;
		try {
			ts = session.beginTransaction();
			Query query = session.createQuery("from Authority");
			 list = query.list();
			return list;
		} catch (HibernateException e) {
			ts.rollback();
			throw new RuntimeException(e.getMessage());
		}
	}

	
	// 添加用户
	public void addUser(User user) {
		// TODO Auto-generated method stub
		Session session = MysessionFactory.creatSessionObject();
		String sql = "INSERT INTO user (deptid,username,password,phone,email,name) VALUES(?,?,HEX(AES_ENCRYPT(?,'password')),?,?,?)";
		Query sqlQuery = session.createSQLQuery(sql).addEntity(User.class);
		Transaction tx = session.beginTransaction();
		sqlQuery.setParameter(0, user.getDeptid());
		sqlQuery.setParameter(1, user.getUsername());
		sqlQuery.setParameter(2, user.getPassword());
		sqlQuery.setParameter(3, user.getPhone());
		sqlQuery.setParameter(4, user.getEmail());
		sqlQuery.setParameter(5, user.getName());
		sqlQuery.executeUpdate();
		tx.commit();
		session.close();
	}

	
	// 根据用户名查找单个用户
	public User findUser(String userName){
		// TODO Auto-generated method stub
		Session session = MysessionFactory.creatSessionObject();
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			Criteria createCriteria = session.createCriteria(User.class);
			// 使用createCriteria的eq方法设定查询条件为name="自定义"
			// 向Criteria对象中添加name="自定义"的查询条件
			createCriteria.add(Restrictions.eq("username", userName));
			User u = (User) createCriteria.uniqueResult();
			return u;
		} catch (HibernateException e) {
			ts.rollback();
			throw new RuntimeException(e.getMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}

	
	// 根据用户名查找单个用户
	public Role findRole(String roleName){
		// TODO Auto-generated method stub
		Session session = MysessionFactory.creatSessionObject();
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			Criteria createCriteria = session.createCriteria(Role.class);
			// 使用createCriteria的eq方法设定查询条件为name="自定义"
			// 向Criteria对象中添加name="自定义"的查询条件
			createCriteria.add(Restrictions.eq("roleName", roleName));
			Role role = (Role) createCriteria.uniqueResult();
			return role;
		} catch (HibernateException e) {
			ts.rollback();
			throw new RuntimeException(e.getMessage());
		} 
	}

	
	// 根据id查询单个用户
	public User findUser(int id){
		// TODO Auto-generated method stub
		Session session = MysessionFactory.creatSessionObject();
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			Criteria createCriteria = session.createCriteria(User.class);
			// 使用createCriteria的eq方法设定查询条件为name="自定义"
			// 向Criteria对象中添加name="自定义"的查询条件
			createCriteria.add(Restrictions.eq("id", id));
			User u = (User) createCriteria.uniqueResult();
			return u;
		} catch (HibernateException e) {
			ts.rollback();
			throw new RuntimeException(e.getMessage());
		} 
	}

	
	// 查找所有用户
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		Session session = MysessionFactory.creatSessionObject();
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			Query query = session.createQuery("from User");
			List<User> list = query.list();
			// 使用forEach遍历集合
			return list;
		} catch (HibernateException e) {
			ts.rollback();
			throw new RuntimeException(e.getMessage());
		} 
	}
	
	//Json 查找所有用户及对应角色
	public String getJSonAllUserAndRole(){
		String result=null;
		AuthorityDao dao=new AuthorityDaoImpl();
	    JSONObject jsonObject=new JSONObject();
	    try {
			List<User> allUser = dao.getAllUser();
			if(allUser!=null&&allUser.size()>0){
				for (User user : allUser) {
					int id = user.getId();
					List<Role> roles = dao.getAllUserRoles(id);
					if(roles!=null&&roles.size()>0){
						String rolesString="";
						for (Role role : roles) {
							String r=role.getRoleName();
							rolesString=rolesString+r+",";
						}
						user.setRolesString(rolesString);
					}
				}
				jsonObject.put("AllUser",allUser);
				result=JSON.toJSONString(jsonObject);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// 得到某个用户的所有角色
	
	public List<Role> getAllUserRoles(int user_id){
		// TODO Auto-generated method stub
		Session session = MysessionFactory.creatSessionObject();
		Transaction ts = null;
		try {
			ts = session.beginTransaction();

			SQLQuery sqlQuery = session
					.createSQLQuery("select * from role r,user_role ur WHERE ur.user_Id =? AND r.roleId=ur.role_Id")
					.addEntity(Role.class);
			sqlQuery.setParameter(0, user_id);
			List<Role> list = sqlQuery.list();
			return list;
		} catch (HibernateException e) {
			ts.rollback();
			throw new RuntimeException(e.getMessage());
		} 
	}

	@SuppressWarnings("unchecked")
	
	// 得到某个角色的所有权限
	public List<Authority> getAllRoleAuthoritys(int role_id)  {
		// TODO Auto-generated method stub
		Session session = MysessionFactory.creatSessionObject();
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			SQLQuery sqlQuery = session.createSQLQuery(
					"select * from authority a,role_authority ra WHERE ra.role_id =? AND a.authorityId=ra.authority_id")
					.addEntity(Authority.class);
			sqlQuery.setParameter(0, role_id);
			List<Authority> list = sqlQuery.list();
			return list;
		} catch (HibernateException e) {
			ts.rollback();
			throw new RuntimeException(e.getMessage());
		} 
	}

	
	// 为用户授角色
	public void addRoleUser(User user, List<Role> roles) throws SQLException {
		// TODO Auto-generated method stub
		Session session = MysessionFactory.creatSessionObject();
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			SQLQuery sqlQuery = session.createSQLQuery("delete from user_role where user_Id=?");
			sqlQuery.setParameter(0, user.getId());
			sqlQuery.executeUpdate();
			SQLQuery sqlQuery1 = session.createSQLQuery("INSERT INTO user_role (user_id, role_id) VALUES (?, ?)");
			for (Role role : roles) {
				sqlQuery1.setParameter(0, user.getId());
				sqlQuery1.setParameter(1, role.getRoleId());
				sqlQuery1.executeUpdate();
			}
			ts.commit();
		} catch (HibernateException e) {
			ts.rollback();
			throw new RuntimeException(e.getMessage());
		} 
	}

	
	// 为角色授权

	public void addAuthoriesRole(Role role, List<Authority> authorites)  {
		// TODO Auto-generated
		Session session = MysessionFactory.creatSessionObject();
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			SQLQuery sqlQuery = session.createSQLQuery("delete from role_authority where role_id=?");
			sqlQuery.setParameter(0, role.getRoleId());
			sqlQuery.executeUpdate();
			SQLQuery sqlQuery1 = session
					.createSQLQuery("INSERT INTO role_authority (role_id, authority_id) VALUES (?, ?)");
			for (Authority authorite : authorites) {
				sqlQuery1.setParameter(0, role.getRoleId());
				sqlQuery1.setParameter(1, authorite.getAuthorityId());
				sqlQuery1.executeUpdate();
			}
			ts.commit();
		} catch (HibernateException e) {
			ts.rollback();
			throw new RuntimeException(e.getMessage());
		} 
	}

	
	// 普通用户登录
	/*public User userDecodeLogin(String username, String password) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		User user = userPassword(username);
		if (password.equals(user.getPassword())) {
			return user;
		} else {
			return null;
		}

	}*/

	
	// 超级管理员登录
	public SuperAdmin superAdminLogin(String username, String password)  {
		// TODO Auto-generated method stub
		Session session = MysessionFactory.creatSessionObject();
		// 编写hql查询
		String hql = "from SuperAdmin sa where sa.superAdminname=? and sa.superAdminpassword=?";
		// 创建query对象
		Query query = session.createQuery(hql);
		query.setString(0, username);
		query.setString(1, password);
		SuperAdmin superAdmin = (SuperAdmin) query.uniqueResult();
		return superAdmin;
	}

	
	// 查询数据库中user表总条数
	public int totalCount(){
		// TODO Auto-generated method stub
		Session session = MysessionFactory.creatSessionObject();
		String hql = "select count(*) from User";
		Long count = (Long) session.createQuery(hql).uniqueResult();
		int count1 = count.intValue();
		{
			return count1;
		}
	}

	
	// 查询数据库中user表总条数
	public int roleTotalCount() throws SQLException {
		// TODO Auto-generated method stub
		Session session = MysessionFactory.creatSessionObject();
		String hql = "select count(*) from Role";
		Long count = (Long) session.createQuery(hql).uniqueResult();
		int count1 = count.intValue();
		{
			return count1;
		}
	}

	
	// 当前页的集合对象
	public List<User> userList(Integer begin, Integer pageSize){
		// TODO Auto-generated method stub
		Session session = MysessionFactory.creatSessionObject();
		// 编写hql查询
		String hql = "from User";
		// 创建query对象
		Query query = session.createQuery(hql);
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		List<User> list = query.list();
		return list;
	}

	
	// 当前页角色的集合对象
	public List<Role> roleList(Integer begin, Integer pageSize){
		// TODO Auto-generated method stub
		Session session = MysessionFactory.creatSessionObject();
		// 编写hql查询
		String hql = "from Role";
		// 创建query对象
		Query query = session.createQuery(hql);
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		List<Role> list = query.list();
		return list;
	}

	@Override
	public String getJsonOneRoleAllAuty(int roleid) {
		// TODO Auto-generated method stub
		AuthorityDao dao=new AuthorityDaoImpl();
		JSONObject jsonObject=new JSONObject();
		String result=null;
		try {
			dao.getAllRoleAuthoritys(roleid);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


	
	@Override
	public Menu getMenubyId(int menuid) {
		Session session = MysessionFactory.creatSessionObject();
		Transaction ts=null;
		Menu menu=null;
	     try {
			 ts = session.beginTransaction();
			 menu = (Menu) session.get(Menu.class,menuid);
			 ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ts.rollback();
		}
		return menu ;
	}



	// 解密后的用户的所有信息
	/*public User userPassword(String username) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		User user = null;
		Connection con = BaseUtils.con();
		String sql = "SELECT *,AES_DECRYPT(UNHEX(PASSWORD), 'password') FROM user WHERE username=?";
		PreparedStatement pr = con.prepareStatement(sql);
		pr.setString(1, username);
		ResultSet resultSet = pr.executeQuery();
		while (resultSet.next()) {
			user = new User();
			user.setId(resultSet.getInt("id"));
			user.setDeptid(resultSet.getInt("deptid"));
			user.setUsername(resultSet.getString("username"));
			user.setPassword(resultSet.getString("AES_DECRYPT(UNHEX(PASSWORD), 'password')"));
			user.setPhone(resultSet.getString("phone"));
			user.setEmail(resultSet.getString("email"));
			user.setName(resultSet.getString("name"));
			user.setIslocked(resultSet.getBoolean("islocked"));
			// 必须写解密函数,看看能不能将密码封装到String字段上
		}
		return user;
	}
*/

@Override
public List<Menu> getAllFirMenu() {
	// TODO Auto-generated method stub
	AuthorityDao dao=new AuthorityDaoImpl();
	List<Menu> menus =new ArrayList<Menu>();
	try {
		List<Authority> authorityslist = dao.getAllAuthoritys();
		for (Authority authority : authorityslist) {
			int menuid = authority.getMenuid();
			Menu menu = dao.getMenubyId(menuid);
			menus.add(menu);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return menus;
}


@Override
public List<Menu> getAllMenuUndOnePar(int parid) {
	Session session = MysessionFactory.creatSessionObject();
	Transaction ts=null;
	List<Menu> list=new ArrayList<Menu>();
     try {
		 ts = session.beginTransaction();
		 Query query = session.createQuery("from Menu where mParentId=?");
		 query.setInteger(0,parid);
		 list = query.list();
		 //业务处理
		 ts.commit();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		ts.rollback();
	}
	return list;
}


@Override
public String getJSonAllFirMenu() {
	// TODO Auto-generated method stub
			AuthorityDao dao=new AuthorityDaoImpl();
			JSONObject jsonObject=new JSONObject();
			String result=null;
			List<Menu> list = dao.getAllFirMenu();
			if(list!=null&&list.size()>0){
				jsonObject.put("ALLFirMenu",list);
				result=JSON.toJSONString(jsonObject);
			}
	return result;
}


@Override
public String getJsonAllMenuUndPar(int parid) {
	// TODO Auto-generated method stub
	AuthorityDao dao=new AuthorityDaoImpl();
	JSONObject jsonObject=new JSONObject();
	String result=null;
	List<Menu> list = dao.getAllMenuUndOnePar(parid);
	if(list!=null&&list.size()>0){
		jsonObject.put("ALLFirMenu",list);
		result=JSON.toJSONString(jsonObject);
	}
return result;
}

}
