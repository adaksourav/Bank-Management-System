package testOparation;

import java.util.Scanner;

import testaccount.CreateAccount;
import testaccount.DeleteAccount;
import testaccount.DepositeOrWithdraw;
import testaccount.Find_accounts;
import testaccount.UpdateAccount;

public class AccountOparation {
	public static void accountOparation() {
		Scanner kc = new Scanner(System.in);
		boolean f = true;
		while (f) {
			System.out.println("\n<><><><><><><><><><><><><><><><>");
			System.out.println("2)..Withdraw amount");
			System.out.println("3)..Deposit amount");
			System.out.println("4)..Find account");
			System.out.println("5)..Delete Account");
			System.out.println("6)..Update account details");
			System.out.println("7)..Create account");
			System.out.println("8)..Exit");
			System.out.println("<><><><><><><><><><><><><><><><>");
			System.out.print("Enter your choice: ");
			int key = kc.nextInt();
			switch (key) {
			case 2:
				 DepositeOrWithdraw.withdrawAmountToAccount();
				break;
			case 3:
				 DepositeOrWithdraw.depositeAmountToAccount();
				break;
			case 4:
				 Find_accounts.findAccountByBankAndNumber();
				break;
			case 5:
				 DeleteAccount.deleteAccount();
				break;
			case 6:
				 UpdateAccount.updateAccount();
				break;
			case 7:
				CreateAccount.create_account();
				break;
			case 8:
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
