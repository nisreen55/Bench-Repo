package com.bench;

import java.awt.MenuItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App 

{
	public static void displayMainMenu()
	{
		System.out.println ("Please choose from our menu : ");
		System.out.println ("1 : Add Food ");
		System.out.println ("2 : Add Drink ");
		System.out.println ("3 : View Order ");
		System.out.println ("4 : View Food ");
		System.out.println ("5 : View Drink ");
		System.out.println ("6 : View Amount ");
		System.out.println ("7 : View Cheapest Item ");
		System.out.println ("8 : Order Status ");
		System.out.println ("9 : Exit ");
	}
	
	public static void displayFoodSubMenu()
	{
		List<MenuItems> foods = addFoodtems();
		for (int i = 0; i < foods.size(); i++)
			System.out.println(i+1 + ". "+foods.get(i).getMenuItemName()+ "    "+foods.get(i).getMenuItemPrice());
		System.out.println("0 . Exit");
	}
	
	public static void displayDrinkSubMenu()
	{
		List<MenuItems> drinks = addDrinktems();
		for (int i = 0; i < drinks.size(); i++)
			System.out.println(i+1 + ". "+drinks.get(i).getMenuItemName()+ "    "+drinks.get(i).getMenuItemPrice());
		System.out.println("0 . Exit");
	}
	
	public static List<MenuItems> addFoodtems()
	{
		List<MenuItems> menuFoodItems = new ArrayList<>();
		menuFoodItems.add(new MenuItems(1, "Food","Fried chicken", 12.0 ));
		menuFoodItems.add(new MenuItems(2, "Food","Burgers", 11.0 ));
		menuFoodItems.add(new MenuItems(3, "Food","Chicken soup", 5.0));
		menuFoodItems.add(new MenuItems(4, "Food","Spaghetti with meatballs", 3.0));
		menuFoodItems.add(new MenuItems(5, "Food","Mashed potatoes", 2.0  ));
		menuFoodItems.add(new MenuItems(6, "Food","Mac & cheese", 8.0 ));
		return menuFoodItems;
	}
	
	public static List<MenuItems> addDrinktems()
	{
		List<MenuItems> menuDrinkItems = new ArrayList<>();
		menuDrinkItems.add(new MenuItems(1, "Drink","Orange Juice", 7.0 ));
		menuDrinkItems.add(new MenuItems(2, "Drink","Grape Juice", 7.0 ));
		menuDrinkItems.add(new MenuItems(3, "Drink","Coke", 5.0));
		return menuDrinkItems;
	}
	
	
	public static void main(String[] args)
	{
		CoffeeShop coffeeShop = new CoffeeShop();
		
		int foodLen = addFoodtems().size();	
		int drinkLen = addDrinktems().size();

		Boolean runMainMenu = true;
		Boolean runSubMenu = true;
		
		System.out.println ("Welcome to "+ coffeeShop.getName());
		Scanner input = new Scanner(System.in);
		System.out.println ("Order number is :");
		int orderNum = input.nextInt();
		displayMainMenu();

		Scanner scanner = new Scanner(System.in);

		while(runMainMenu)
		{
			int customerItemType = scanner.nextInt();

			if(customerItemType != 0)
			{
				switch(customerItemType)
				{
					case 1: 
					{
						displayFoodSubMenu();
						runSubMenu = true;
						Scanner sc = new Scanner(System.in);
						while(runSubMenu) 
						{
							int customerOrder = sc.nextInt(); 
							if(customerOrder != 0)
							{
								List<MenuItems> custOrder = coffeeShop.addOrder(orderNum, addFoodtems().get(customerOrder-1).getMenuItemName(), customerItemType,
										                                 addFoodtems().get(customerOrder-1).getMenuItemPrice());
								System.out.println( "You added : "+ custOrder.size()+" items" );
								for (int i = 0; i < custOrder.size(); i++) 
									if(custOrder.get(i) != null)
										System.out.println(custOrder.get(i).getMenuItemName());
							}
							else
							{
								System.out.println( "Return to main menu " );
								displayMainMenu();
							}

							switch(customerOrder)
							{
								case 0: 
								{
									runSubMenu = false;
									System.out.println( "Thanks for ordering Food" );				
									break;
								}
							}
						} 
						break;
					} 
					case 2: 
					{
						
						displayDrinkSubMenu();
						runSubMenu = true;
						Scanner sc = new Scanner(System.in);
						while(runSubMenu) 
						{
							int customerOrder = sc.nextInt(); 
							if(customerOrder != 0)
							{
								List<MenuItems>  custOrder = coffeeShop.addOrder(orderNum, addDrinktems().get(customerOrder-1).getMenuItemName(), customerItemType, 
																		addDrinktems().get(customerOrder-1).getMenuItemPrice());
								System.out.println( "You added : " );
								for (int i = 0; i < custOrder.size(); i++) 
									if(custOrder.get(i) != null)
										System.out.println(custOrder.get(i).getMenuItemName());
							}
							else
							{
								System.out.println( "Return to main menu " );
								displayMainMenu();
							}

							switch(customerOrder)
							{
								case 0: 
								{
									runSubMenu = false;
									System.out.println( "Thanks for ordering Drink" );				
									break;
								}
							}
						} 
						break;
					} 
					case 3: 
					{
						List<OrderItems> custOrder = coffeeShop.listOrder();
						for (int i = 0; i < custOrder.size(); i++) 
							System.out.println(custOrder.get(i).getOrderId()+" "+ custOrder.get(i).getMenuItems().get(i).getMenuItemName() +" "+ custOrder.get(i).getMenuItems().get(i).getMenuItemPrice());
						break;
					} 
					case 4: 
					{
						List<MenuItems> custOrder = coffeeShop.foodOnly();
						for (int i = 0; i < custOrder.size(); i++) 
							if(custOrder.get(i) != null)
							{
								System.out.println(custOrder.get(i).getMenuItemName());
							}
							else
							{
								if(custOrder.get(i) == null)
								{
									System.out.println("Please add food to your order..");
									break;
								}
							}
						break;
					}
					case 5: 
					{
						List<MenuItems> custOrder = coffeeShop.drinkOnly();
						for (int i = 0; i < custOrder.size(); i++) 
							if(custOrder.get(i) != null)
							{
								System.out.println(custOrder.get(i).getMenuItemName());
							}
							else
							{
								if(custOrder.get(i) == null)
								{
									System.out.println("Please add food to your order..");
									break;
								}
							}
						break;
					} 
					case 6: 
					{
						double totAmount = coffeeShop.dueAmount();
						System.out.println("Your Total Amount is :$ "+totAmount );
						break;
					} 
					case 7: 
					{
						String lowerItem = coffeeShop.cheapestItem();
						System.out.println(lowerItem);
						break;
					}
					case 8: 
					{
						if(coffeeShop.fullFillOrder()==0)
						{
							System.out.println("Order has been fullfilled");
							System.exit(0);
						}
						else 
						{
							System.out.println("Items are ready!");
						}
						break;
					} 
				}
			} 
			
			switch(customerItemType)
			{
				case 9: 
				{
					runMainMenu = false;
					System.out.println( "Thanks for using my app. Good bye.." );				
					break;
				}
			}
		}
		scanner.close();
		}
	}
	

