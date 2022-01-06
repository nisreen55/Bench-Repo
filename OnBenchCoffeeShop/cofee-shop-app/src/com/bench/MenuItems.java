package com.bench;

public class MenuItems 
{
	private int menuItemId;
	private String menuItemType;
	private String menuItemName;
	private double menuItemPrice;
	
	public MenuItems(int menuItemId, String menuItemType, String menuItemName, double menuItemPrice) {
		super();
		this.menuItemId = menuItemId;
		this.menuItemType = menuItemType;
		this.menuItemName = menuItemName;
		this.menuItemPrice = menuItemPrice;
	}
	
	public MenuItems() {
		super();
	}
	public int getMenuItemId() {
		return menuItemId;
	}

	public void setMenuItemId(int menuItemId) {
		this.menuItemId = menuItemId;
	}
	public String getMenuItemType() {
		return menuItemType;
	}

	public void setMenuItemType(String menuItemType) {
		this.menuItemType = menuItemType;
	}

	public String getMenuItemName() {
		return menuItemName;
	}

	public void setMenuItemName(String menuItemName) {
		this.menuItemName = menuItemName;
	}

	public double getMenuItemPrice() {
		return menuItemPrice;
	}

	public void setMenuItemPrice(double menuItemPrice) {
		this.menuItemPrice = menuItemPrice;
	}

	@Override
	public String toString() {
		return "MenuItems [menuItemId=" + menuItemId + ", menuItemType=" + menuItemType + ", menuItemName="
				+ menuItemName + ", menuItemPrice=" + menuItemPrice + "]";
	}

	
	
	


}
