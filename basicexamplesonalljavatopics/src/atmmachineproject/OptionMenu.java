package atmmachineproject;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account
{
	Scanner scanner=new Scanner(System.in);
	DecimalFormat moneyFormat=new DecimalFormat("'$'###,##0.00");
	HashMap<Integer,Integer> data=new HashMap<Integer,Integer>();
	
	public void getLogin()
	{
		int x=1;
		do
		{
			try 
			{
				data.put(12345, 54321);
				data.put(56789, 98765);
				System.out.println("Welcome too ATM project");
				System.out.println("Enter the Customer Number");
				setCustomerNumber(scanner.nextInt());
				System.out.println("Enter PIN number");
				setPinNumber(scanner.nextInt());
				
			} catch (Exception e)
			{
				System.out.println("\n"+"Invalid Character(s) Only numbers are allowed"+"\n");
				x=2;
			}
			
			int cn=getCustomerNumber();
			int pn=getPinNumber();
			if(data.containsKey(cn)&&data.get(cn)==pn)
			{
				getAccountType();
			}
			else
			{
				System.out.println("\n"+"Wrong customer number or pin number"+"\n");
			}
		} while (x==1);
	}
	public void getAccountType()
	{
		System.out.println("Select the account you want to access");
		System.out.println("Type 1 - Checking Account");
		System.out.println("Type 2 - Savings Account");
		System.out.println("Type 3 - Exit");
		
		int selection = scanner.nextInt();
		switch (selection) 
		{
			case 1: 
			{	
				getChecking();
				break;
			}
			case 2:
			{
				getSaving();
				break;
			}
			case 3:
			{
				System.out.println("Thankyou for using this ATM, Byee. \n");
				break;
			}
			default:
			{
				System.out.println("\nInvalid choice\n");
			}
		}
	}
	
	public void getChecking()
	{
		System.out.println("Checking Account");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Funds");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.print("Choice : ");
		int selection =scanner.nextInt();
		
		switch(selection)
		{
			case 1:
			{
				System.out.println("Checking Account Balance : " + moneyFormat.format(getCheckingBalance()));
				getAccountType();
				break;
			} 
			case 2:
			{
				getCheckingWithdrawInput();
				getAccountType();
				break;
			}
			case 3:
			{
				getCheckingDepositInput();
				getAccountType();
				break;
			}
			case 4:
			{
				System.out.println("Thank you for usiing this ATM, Byee\n");
				break;
			}
			default:
			{
				System.out.println("\nInvalid Choice\n");
			}
		}
	}
	public void getSaving()
	{
		System.out.println("Saving Account: ");
		System.out.println(" Type 1 - View Balance");
		System.out.println(" Type 2 - Withdraw Funds");
		System.out.println(" Type 3 - Deposit Funds");
		System.out.println(" Type 4 - Exit");
		System.out.print("Choice: ");
	
		int selection = scanner.nextInt();
		switch (selection) 
		{
			case 1:
			{
				System.out.println("Saving Account Balance: " +	moneyFormat.format(getSavingBalance()));
				getAccountType();	
				break;
			}
			case 2:
			{
				getSavingWithdrawInput();
				getAccountType();
				break;
			}
			case 3:
			{
				getSavingDepositInput();
				getAccountType();
				break;
			}
			case 4:
			{
				System.out.println("Thank You for using this ATM, bye.");
				break;
			}
			default:
			{
				System.out.println("\n" + "Invalid Choice." + "\n");
			}
		}	
	
	}

//	public static void main(String[] args) 
//	{
//		OptionMenu optionMenu=new OptionMenu();
//		optionMenu.getLogin();
//	}
			
	
}
