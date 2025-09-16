package testaccount;

import java.util.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import util.UtilClass;

public class UpdateAccount {
	
	private static EntityManager em = UtilClass.getEntityManagerFactory().createEntityManager();
	private static EntityTransaction et = em.getTransaction();
	private static Scanner c = new Scanner(System.in);

	public static void updateAccountName() {
		System.out.println("Enter account number to update name:");
		long accNum = c.nextLong();
		c.nextLine();
		System.out.println("Enter new name:");
		String newName = c.nextLine();

		et.begin();
		Query q = em.createQuery("UPDATE AccountDetails a SET a.name = :name WHERE a.accountNumber = :accNum");
		q.setParameter("name", newName);
		q.setParameter("accNum", accNum);
		int rows = q.executeUpdate();
		et.commit();

		if (rows > 0)
			System.out.println("Name updated successfully!");
		else
			System.err.println("No account found with account number: " + accNum);
	}

	public static void updateAccoutEmail() {
		System.out.println("Enter account number to update email:");
		long accNum = c.nextLong();
		c.nextLine();
		System.out.println("Enter new email:");
		String newEmail = c.nextLine();

		et.begin();
		Query q = em.createQuery("UPDATE AccountDetails a SET a.email = :email WHERE a.accountNumber = :accNum");
		q.setParameter("email", newEmail);
		q.setParameter("accNum", accNum);
		int rows = q.executeUpdate();
		et.commit();

		if (rows > 0)
			System.out.println("Email updated successfully!");
		else
			System.err.println("No account found with account number: " + accNum);
	}

	public static void updateAccountBalance() {
		System.out.println("Enter account number to update balance:");
		long accNum = c.nextLong();
		c.nextLine();
		System.out.println("Enter new balance:");
		double newBalance = c.nextDouble();

		et.begin();
		Query q = em.createQuery("UPDATE AccountDetails a SET a.blance = :balance WHERE a.accountNumber = :accNum");
		q.setParameter("balance", newBalance);
		q.setParameter("accNum", accNum);
		int rows = q.executeUpdate();
		et.commit();

		if (rows > 0)
			System.out.println("Balance updated successfully!");
		else
			System.err.println("No account found with account number: " + accNum);
	}

	public static void updateAccount() {
		boolean f = true;
		while (f) {
			System.out.println("\n<><><><><><><><><><><><><><><><>");
			System.out.println("2)..Update account holder email");
			System.out.println("3)..Update account balance");
			System.out.println("4)..Update account holder name");
			System.out.println("5)..Exit");
			System.out.println("<><><><><><><><><><><><><><><><>");
			System.out.print("Enter your choice: ");
			int key = c.nextInt();
			switch (key) {
			case 4:
				updateAccountName();
				break;
			case 2:
				updateAccoutEmail();
				break;
			case 3:
				updateAccountBalance();
				break;
			case 5:
				f = false;
				System.out.println("Exiting account update menu...");
				break;
			default:
				System.out.println("Invalid choice. Try again.");
				break;
			}
		}
	}

	public static void main(String[] args) {
		updateAccount();
	}
}
