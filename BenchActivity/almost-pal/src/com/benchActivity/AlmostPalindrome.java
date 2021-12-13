package com.benchActivity;

import java.util.Scanner;

public class AlmostPalindrome 
{
	 static boolean isAlmostPalindrome(String str)
	 {
		 int unMatched = 0;
		 for (int i = 0; i < str.length()/2; ++i)
		    if (str.charAt(i) != str.charAt(str.length() - i - 1))
		        ++unMatched;
		 return (unMatched <= 1);
	}
	 
	public static void main(String[] args) 
	{
		Scanner scn = new Scanner(System.in); 
		System.out.println("Please type string to ckeck is it Almost Palindrome");
		String input = scn.next();

		if (isAlmostPalindrome(input))
			System.out.println("True");
		else
		    System.out.println("False");
		scn.close();
	}
	
}
