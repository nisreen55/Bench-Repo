/**
* Weekly Coding Challenge
* Simulate "Rock, Paper, Scissors" Game
* Input: Players Option'
* Output: Game Result
* @author Nisreen Hassan - 2021
*/

package com.bench;

import java.util.Scanner;

public class Game 
{
	enum Option 
	{
	   ROCK,
	   PAPER,
	   SCISSORS
	}
	/**
	 * Method to read players option from scanner, validate input 
	 * @return player option
	 */
	public static String getPlayerOption()
	{
	    Scanner scan = new Scanner(System.in);
	    String option = scan.next();
	    String playerOption = option.toUpperCase();
	    if(playerOption.equals("ROCK") || playerOption.equals("PAPER") || playerOption.equals("SCISSORS"))
	    {
	        return playerOption;
	    }else
	    {
	        System.out.println("Sorry, Try again!");
	        return "Invalid Input";
	    }
	}
	
	/**
	 * Main Method. Display main menu, call getPlayerOption method	to read players options, 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		  System.out.println("Rock Paper Game is running....");
		  System.out.println("First Player option: ");
		  System.out.println("**********************************************");
	      System.out.println("ROCK");
	      System.out.println("PAPER");
	      System.out.println("SCISSORS");
	 
	      String firstPlayerOption = getPlayerOption();
	      System.out.println("first move is: "+ firstPlayerOption);
	      if(!firstPlayerOption.equals("Bad Input")) 
	      {
			System.out.println("Second Player option: ");
	  	    System.out.println("ROCK");
	  	    System.out.println("PAPER");
	  	    System.out.println("SCISSORS");
	  	    
		    String secondPlayerOption = getPlayerOption();
	        System.out.println("second move is: " + secondPlayerOption);
	        
	        if (firstPlayerOption.equals(secondPlayerOption)) 
	        	System.out.println("Game is Tie !!");
	        
	        // Checks players options, and display game result      
	        else if (firstPlayerOption.equals(Option.ROCK.name())) 
	        {
	            if(secondPlayerOption.equals(Option.PAPER.name())) 
	                System.out.println("Second player Wins");
	            else 
	                System.out.println("First Player Win!");
	        }
	        else if (firstPlayerOption.equals(Option.PAPER.name())) 
	        {
	            if(secondPlayerOption.equals(Option.SCISSORS.name())) 
	                System.out.println("Second Player Wins");
	            else 
	                System.out.println("First Player Win!");
	        }
	        else
	        {
	           if(secondPlayerOption.equals(Option.ROCK.name())) 
	                System.out.println("Second Player Wins");
	           else 
	                System.out.println("First Player Win!");
	        }
	     }
	}
}
