package com.electricity.entity;

import java.util.List;

public class Paging {
	private Integer currentPage;// ��ǰҳ
	private Integer totalCount;// ������
	private Integer totalPage;// ��ҳ��
	private Integer pageSize;// ��ǰҳ�Ĵ�С
	private Integer beginCount;// �ӵڵڼ������ݿ�ʼ
	private List<User> list;// ��ǰҳ�ļ���
	private List<Role> roleList;// ��ǰҳ�Ľ�ɫ����

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getBeginCount() {
		return beginCount;
	}

	public void setBeginCount(Integer beginCount) {
		this.beginCount = beginCount;
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public Paging(Integer currentPage, Integer totalCount, Integer totalPage, Integer pageSize, Integer beginCount,
			List<User> list, List<Role> roleList) {
		super();
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.pageSize = pageSize;
		this.beginCount = beginCount;
		this.list = list;
		this.roleList = roleList;
	}

	public Paging() {
		super();
	}

	@Override
	public String toString() {
		return "Paging [currentPage=" + currentPage + ", totalCount=" + totalCount + ", totalPage=" + totalPage
				+ ", pageSize=" + pageSize + ", beginCount=" + beginCount + ", list=" + list + ", roleList=" + roleList
				+ "]";
	}

}
