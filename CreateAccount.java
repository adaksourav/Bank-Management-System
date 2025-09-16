package testaccount;

import java.util.Arrays;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import mainclass.AccountDetails;
import mainclass.Bank;
import util.UtilClass;

public class CreateAccount {
	public static void create_account() {
		EntityManager em = UtilClass.getEntityManagerFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter bank name to add account");
		String bname = sc.nextLine();
		Bank b = em.find(Bank.class, bname);
		if (b != null) {
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
		}
		else {
			System.out.println("Invalid bank name to enter account");
		}
		
		}
}
