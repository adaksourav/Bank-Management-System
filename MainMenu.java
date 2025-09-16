package mainclass;

import java.util.Scanner;

import testOparation.AccountOparation;
import testOparation.BankOparation;
import util.UtilClass;


public class MainMenu {
	public static void main(String[] args) {
		Scanner jc = new Scanner(System.in);
		boolean f = true;
		while (f) {
			System.out.println("\n<><><><><><><><><><><><><><><><>");
			System.out.println("2)..Bank Opration");
			System.out.println("3)..Account Operation");
			System.out.println("4)..Exit");
			System.out.println("<><><><><><><><><><><><><><><><>");
			System.out.print("Enter your choice: ");
			int key = jc.nextInt();
			switch (key) {
			case 3:
				AccountOparation.accountOparation();
				break;
			case 2:
				BankOparation.bankOparation();
				break;
			case 4:
				f = false;
				System.out.println("Exiting main menu...");
				break;
			default:
				System.out.println(" Invalid choice. Try again.");
			}
			
		}
		UtilClass.shutdown();
        System.out.println("Application closed.");
		jc.close();
	}
}
