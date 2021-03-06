package validePINproject;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidatePIN 
{
	// Function to validate the pin code.
    public static boolean isValidPin(String pinCode)
    {
        String regex = "^([0-9]{4}|[0-9]{6})$";
        Pattern p = Pattern.compile(regex);
        if (pinCode == null) {
            return false;
        }
 
       Matcher m = p.matcher(pinCode);
       return m.matches();
    }
    public static void main(String[] args) 
    {
    	Scanner sc = new Scanner(System.in);
    	boolean run = true;
    	System.out.println("Press * to exit");

    	while(run)
    	{
    		System.out.println("Please enter your PIN:");
    		String input = sc.next();
    		if(input.equals("*")) 
			{
				run = false;
				System.exit(0);
			}
    		System.out.println(isValidPin(input));
    	}	
	
    }
}
