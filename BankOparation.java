package testOparation;

import java.util.Scanner;

import testbank.DeleteBank;
import testbank.FindBank_all_account;
import testbank.Save_Bank_Account_Record;
import testbank.UpdateBank;

public class BankOparation {
	public static void bankOparation() {
		Scanner sc = new Scanner(System.in);
		boolean f = true;
		while (f) {
			System.out.println("\n<><><><><><><><><><><><><><><><>");
			System.out.println("2)..Find all the accout");
			System.out.println("3)..Delete Bank");
			System.out.println("4)..Update Bank details");
			System.out.println("5)..Create Bank");
			System.out.println("6)..Exit");
			System.out.println("<><><><><><><><><><><><><><><><>");
			System.out.print("Enter your choice: ");
			int key = sc.nextInt();
			switch (key) {
			case 2:
				 FindBank_all_account.findRecord();
				break;
			case 3:
				 DeleteBank.deleteBank();
				break;
			case 4:
				 UpdateBank.updateBank();
				break;
			case 5:
				Save_Bank_Account_Record.addNewBankAndAccountDetails();
				break;
			case 6:
				 f=false;
				 System.out.println("Thak you visit again");
				break;
			default:
				System.out.println("Worng choice");
				break;
			}
		}
	
	}
}
