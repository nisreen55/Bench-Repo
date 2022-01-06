package com.bench;

import java.awt.MenuItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoffeeShop 
{
	private String Name = "Happy Meal";
	private MenuItems menuItems;
	private List<MenuItems> orderList = new ArrayList<>();
	private List<OrderItems> orderItems = new ArrayList<>();
	
	private List<MenuItems> tempFoods = new ArrayList<>();
	private List<MenuItems> tempDrinks = new ArrayList<>();


	//private String[] tempDrink = new String[10];
	
	public CoffeeShop( ) {
		super();
	}
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public MenuItems getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(MenuItems menuItems) {
		this.menuItems = menuItems;
	}

	public List<MenuItems> addOrder(int orderNum, String itemName, int itemType, double itemPrice ) 
	{
		App app = new App();
		if(itemType == 1 )
		{
			int itemsNum =orderList.size();
			System.out.println("length :"+itemsNum);
			System.out.println("inside add "+itemsNum);
			orderList.add(new MenuItems(itemsNum,"Food" , itemName, itemPrice));
			tempFoods.add(new MenuItems(itemsNum,"Food" , itemName, itemPrice));
			System.out.println("after add "+orderList.size());
			System.out.println("printing inside addOrder "+orderList.get(itemsNum).getMenuItemName()+ " "+orderList.get(itemsNum).getMenuItemPrice());
			orderItems.add(new OrderItems(orderNum, orderList));
		}
		if(itemType == 2)
		{
			List<MenuItems> drink = app.addDrinktems();
			int itemsNum =orderList.size();
			System.out.println("length :"+itemsNum);
			orderList.add(new MenuItems(itemsNum,"Drink" , itemName, itemPrice));
			tempDrinks.add(new MenuItems(itemsNum,"Drink" , itemName, itemPrice));
			System.out.println("printing inside addOrder "+orderList.get(itemsNum).getMenuItemName()+ " "+orderList.get(itemsNum).getMenuItemPrice() );
			orderItems.add(new OrderItems(orderNum, orderList));
			System.out.println("printing inside addOrder "+orderList.get(0).getMenuItemName()+ " "+orderList.get(0).getMenuItemPrice() + " index:" + 0);
		}
		return orderList;
	}
	public List<OrderItems> listOrder() 
	{
		return orderItems;
	}
	
	public  List<MenuItems> drinkOnly() 
	{
		return 	tempDrinks;
	}
	
	public  List<MenuItems> foodOnly() 
	{
		return tempFoods;
	}
	
	public String cheapestItem() 
	{
		double lowerPrice = orderList.get(0).getMenuItemPrice();
		String lowerItem = orderList.get(0).getMenuItemName();
		for(int i = 0; i < orderList.size(); i++)
		{
			if(orderList.get(i).getMenuItemPrice() < lowerPrice)
			{
				lowerPrice = orderList.get(i).getMenuItemPrice();
				lowerItem = orderList.get(i).getMenuItemName();
			}
		}
		return lowerItem;
	}
	
	public double dueAmount() 
	{
		double totalAmount = 0;
		for(int i = 0; i < orderList.size(); i++)
		{
			totalAmount = totalAmount + orderList.get(i).getMenuItemPrice();
		}
		return totalAmount;
	}
	
	public int fullFillOrder() 
	{
		return orderItems.isEmpty()? 0 : orderItems.size();
	}
}
