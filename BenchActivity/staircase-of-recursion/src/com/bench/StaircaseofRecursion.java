package com.bench;

import java.util.Scanner;

public class StaircaseofRecursion 
{
	 public static int counting(int n)
	    {
	        int result = 0;
	        if (n >= 1) 
	        {
	            result += counting(n-1);
	            if (n >= 2) 
	            {
	                result += counting(n-2);
	                if (n >= 3) 
	                    result += counting(n-3);
	            }
	        }
	        else
	            result += 1;
	        return result;
	    }
	public static void main(String[] args) 
	{
		Scanner scn = new Scanner(System.in); 
		System.out.println("Please type number of stair to reach");
		int input = scn.nextInt();
	    System.out.printf("Total ways to reach the %d'th stair are %d", input, counting(input));
	}

}
