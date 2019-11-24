package com.electricity.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;

import com.electricity.entity.Authority;
import com.electricity.entity.Paging;
import com.electricity.entity.Role;
import com.electricity.entity.User;
import com.electricity.service.AuthorityService;

public class CommonAdminServlet extends BaseServlet {
	AuthorityService service=new AuthorityService();

	// ��ѯ���й���Ա
	protected void selectAllAdmin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		HttpSession session = request.getSession();
		List<Role> list = service.getAllRole();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/lookCommomAdmin.jsp").forward(request, response);
	}

	// ��ѯ����Ȩ��
	protected void selectAllAuthorities(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		List<Authority> list = service.getAllAuthoritys();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/lookAuthorties.jsp").forward(request, response);
	}

	// �����ͨ����Ա
	protected void addCommonAdmin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		Role commonAdmin = new Role();
		commonAdmin.setRoleName(request.getParameter("name"));
		commonAdmin.setRoleDescription(request.getParameter("description"));
		service.addCommonAdmin(commonAdmin);
		request.getRequestDispatcher("${pageContext.request.contextPath}/authority?methodName=selectAllAuthorities")
				.forward(request, response);
	}

	// ��ѯ�����û�
	protected void selectAllUsers(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException, SQLException {
		List<User> list = service.getAllUser();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/lookUser.jsp").forward(request, response);
	}

	// ��ѯ�����û�
	protected void selectUser(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException, SQLException {
		String username = request.getParameter("username");
		User user = service.findUser(username);
		List<Role> allUserRoles = service.getAllUserRoles(user.getId());
		List<Role> list = service.getAllRole();
		request.setAttribute("user", user);
		request.setAttribute("allUserRoles", allUserRoles);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/accredit.jsp").forward(request, response);
	}

	// ��ѯ������ɫ
	protected void selectRole(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String rolename = request.getParameter("username");
		Role findRole = service.findRole(rolename);
		List<Authority> allRoleAuthoritys = service.getAllRoleAuthoritys(findRole.getRoleId());
		List<Authority> allAuthoritys = service.getAllAuthoritys();
		request.setAttribute("role", findRole);
		request.setAttribute("allRoleAuthoritys", allRoleAuthoritys);
		request.setAttribute("list", allAuthoritys);
		request.getRequestDispatcher("/jsp/accrectRole.jsp").forward(request, response);
	}

	// Ϊ�û������ɫ
	@SuppressWarnings("all")
	protected void accreditUser(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException, SQLException {
		// �õ��������Ҫ��ӽ�ɫ��id
		String[] ids = request.getParameterValues("roleId");
		if (ids == null && ids.length == 0) {
			response.getWriter().print("�㻹δ��ӽ�ɫ");
		}
		int[] IDS = new int[ids.length];
		for (int i = 0; i < ids.length; i++) {
			IDS[i] = Integer.parseInt(ids[i]);
		}
		// ��ȡ�û�id
		String user_id = request.getParameter("username");
		int id = Integer.parseInt(user_id);
		User user = service.findUser(id);
		List<Role> list = new ArrayList<Role>();
		for (int ID : IDS) {
			/* list.add(service.findAuthority(ID)); */
			list.add(service.findRole(ID));
		}
		service.addRoleUser(user, list);
		request.getRequestDispatcher("/jsp/welcome.jsp").forward(request, response);
	}

	// Ϊ��ɫ����Ȩ��
	@SuppressWarnings("all")
	protected void accreditRole(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException, SQLException {
		// �õ��������Ҫ��ӽ�ɫ��id
		String[] ids = request.getParameterValues("AuthorityId");
		if (ids == null && ids.length == 0) {
			response.getWriter().print("�㻹δ��ӽ�ɫ");
		}
		int[] IDS = new int[ids.length];
		for (int i = 0; i < ids.length; i++) {
			IDS[i] = Integer.parseInt(ids[i]);
		}
		// ��ȡ��ɫid
		String role_id = request.getParameter("username");
		int id = Integer.parseInt(role_id);
		Role findRole = service.findRole(id);
		List<Authority> list = new ArrayList<Authority>();
		for (int ID : IDS) {
			list.add(service.findAuthority(ID));
		}
		service.addAuthoriesRole(findRole, list);
		request.getRequestDispatcher("/jsp/welcome.jsp").forward(request, response);
	}

	protected void paging(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		HttpSession session = request.getSession();
		// ������ҳ����
		Paging paging = new Paging();
		// ���õ�ǰҳ
		Integer currentPage = 0;
		String currentPag = request.getParameter("currentPage");
		if (currentPag != null && currentPag.length() > 0) {
			currentPage = Integer.valueOf(currentPag);
		}
		paging.setCurrentPage(currentPage);
		// ����ÿҳ��ʵ��������
		Integer pageSize = 3;
		paging.setPageSize(pageSize);
		// �õ�������
		Integer total = service.totalCount();
		paging.setTotalCount(total);
		// �õ���ҳ��
		Integer totalPage = 0;
		if (total / pageSize == 0) {
			totalPage = total / pageSize;
		} else {
			totalPage = total / pageSize + 1;
		}
		paging.setTotalPage(totalPage);
		Integer begin = (currentPage - 1) * pageSize;
		paging.setBeginCount(begin);
		List<User> userList = service.userList(begin, pageSize);
		paging.setList(userList);
		session.setAttribute("pageBean", paging);
		request.getRequestDispatcher("/jsp/lookUser.jsp").forward(request, response);
	}

	protected void rolePaging(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		HttpSession session = request.getSession();
		// ������ҳ����
		Paging paging1 = new Paging();
		// ���õ�ǰҳ
		Integer currentPage = 0;
		String currentPag = request.getParameter("currentPage");
		if (currentPag != null && currentPag.length() > 0) {
			currentPage = Integer.valueOf(currentPag);
		}
		paging1.setCurrentPage(currentPage);
		// ����ÿҳ��ʵ��������
		Integer pageSize = 3;
		paging1.setPageSize(pageSize);
		// �õ�������
		int roleTotalCount = service.roleTotalCount();
		paging1.setTotalCount(roleTotalCount);
		// �õ���ҳ��
		Integer totalPage = 0;
		if (roleTotalCount / pageSize == 0) {
			totalPage = roleTotalCount / pageSize;
		} else {
			totalPage = roleTotalCount / pageSize + 1;
		}
		paging1.setTotalPage(totalPage);
		Integer begin = (currentPage - 1) * pageSize;
		paging1.setBeginCount(begin);
		List<Role> roleList = service.roleList(begin, pageSize);
		paging1.setRoleList(roleList);
		session.setAttribute("roleBean", paging1);
		request.getRequestDispatcher("/jsp/lookRole.jsp").forward(request, response);
	}

	/*protected void delUser(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException, SQLException {
		try {
			String username = request.getParameter("username");
			String Page = request.getParameter("currentPage");
			System.out.println(username + Page + "test");
			if (username != null) {
				service.delUser(username);
				response.sendRedirect("${pageContext.request.contextPath}/authority?methodName=paging&currentPage=" + Page);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/

}
