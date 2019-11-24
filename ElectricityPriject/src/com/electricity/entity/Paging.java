package com.electricity.entity;

import java.util.List;

public class Paging {
	private Integer currentPage;// 当前页
	private Integer totalCount;// 总条数
	private Integer totalPage;// 总页数
	private Integer pageSize;// 当前页的大小
	private Integer beginCount;// 从第第几条数据开始
	private List<User> list;// 当前页的集合
	private List<Role> roleList;// 当前页的角色集合

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
