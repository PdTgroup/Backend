package com.electricity.entity;

import java.util.HashSet;
import java.util.Set;

public class Menu {
	
	private Integer menuId;
	private String menuName;
	private String mUrl;
	private transient Menu parMenu;
	private transient Set<Menu> menus=new HashSet<Menu>();
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getmUrl() {
		return mUrl;
	}
	public void setmUrl(String mUrl) {
		this.mUrl = mUrl;
	}
	public Menu getParMenu() {
		return parMenu;
	}
	public void setParMenu(Menu parMenu) {
		this.parMenu = parMenu;
	}
	public Set<Menu> getMenus() {
		return menus;
	}
	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", menuName=" + menuName + ", mUrl=" + mUrl + ", parMenu=" + parMenu
				+ ", menus=" + menus + "]";
	}
	
	

	
	
	

}
