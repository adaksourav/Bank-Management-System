package testbank;

import java.util.Arrays;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import mainclass.AccountDetails;
import mainclass.Bank;
import util.UtilClass;

public class Save_Bank_Account_Record {
	public static void addNewBankAndAccountDetails() {
	
		EntityManager em = UtilClass.getEntityManagerFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter bank details");
		System.out.print("Enter bank name : ");
		String bname = sc.nextLine();
		System.out.print("Enter bank IFSC number : ");
		String bifc = sc.nextLine();
		System.out.print("Enter no of branches : ");
		int bNoOfBranches = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter bank address : ");
		String bAddress = sc.nextLine();

		Bank b = new Bank(bname, bifc, bNoOfBranches, bAddress);

		boolean f = true;
		while (f) {
			System.out.println("<><><><><><><><><><><><><><><><>");
			System.out.println("2)..Enter account details");
			System.out.println("3)..Exit");
			System.out.println("<><><><><><><><><><><><><><><><>");

			System.out.println("Enter your choice");
			int key = sc.nextInt();
			sc.nextLine();
			switch (key) {
			case 2:
				System.out.print("Enter account number : ");
				long accountNumber = sc.nextLong();
				sc.nextLine();
				System.out.print("Enter account holder name : ");
				String name = sc.nextLine();
				System.out.print("Enter account holder D.O.B : ");
				String dob = sc.nextLine();
				System.out.print("Enter account holder email : ");
				String email = sc.nextLine();
				System.out.print("Enter account holder aadhar no : ");
				long aadharNo = sc.nextLong();
				sc.nextLine();
				System.out.print("Enter account balance : ");
				double balance = sc.nextDouble();
				sc.nextLine();
				AccountDetails a = new AccountDetails(accountNumber, name, dob, email, aadharNo, balance);
				b.setAccounts(Arrays.asList(a));
				a.setBank(b);

				et.begin();
				em.persist(b);
				em.persist(a);
				et.commit();

				System.out.println(" Account details saved successfully");
				break;

			case 3:
				f = false;
				System.out.println("Thank you visit again.....");
				break;

			default:
				System.out.println("wrong key");
				break;
			}
		}
		
	}

	public static void main(String[] args) {
        addNewBankAndAccountDetails();
	}
}
