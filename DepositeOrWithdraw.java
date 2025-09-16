package testaccount;

import java.util.Scanner;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import mainclass.AccountDetails;
import mainclass.Bank;
import util.UtilClass;

public class DepositeOrWithdraw {

	private static EntityManager em = UtilClass.getEntityManagerFactory().createEntityManager();
	private static EntityTransaction et = em.getTransaction();
	private static Scanner sc = new Scanner(System.in);

	public static void depositeAmountToAccount() {
		System.out.print("Enter bank name: ");
		String bankName = sc.nextLine();
		Bank bank = em.find(Bank.class, bankName);

		if (bank == null) {
			System.err.println("Bank not found!");
			return;
		}

		System.out.print("Enter account number: ");
		long accNum = sc.nextLong();

		AccountDetails account = em.find(AccountDetails.class, accNum);

		if (account == null || !account.getBank().getBankName().equals(bankName)) {
			System.err.println("Account not found in this bank!");
			return;
		}

		System.out.print("Enter deposit amount (multiple of 500): ");
		double amount = sc.nextDouble();

		if (amount % 500 != 0) {
			System.err.println("Deposit amount must be multiple of 500!");
			return;
		}

		et.begin();
		account.setBlance(account.getBlance() + amount);
		em.merge(account);
		et.commit();

		System.out.println("Deposit successful! New Balance: " + account.getBlance());
	}

	public static void withdrawAmountToAccount() {
		System.out.print("Enter bank name: ");
		String bankName = sc.nextLine();
		Bank bank = em.find(Bank.class, bankName);

		if (bank == null) {
			System.err.println("Bank not found!");
			return;
		}

		System.out.print("Enter account number: ");
		long accNum = sc.nextLong();

		AccountDetails account = em.find(AccountDetails.class, accNum);

		if (account == null || !account.getBank().getBankName().equals(bankName)) {
			System.err.println("Account not found in this bank!");
			return;
		}

		System.out.print("Enter withdraw amount (multiple of 100): ");
		double amount = sc.nextDouble();

		if (amount % 100 != 0) {
			System.err.println("Withdraw amount must be multiple of 100!");
			return;
		}

		if (amount > account.getBlance()) {
			System.err.println("Insufficient balance!");
			return;
		}

		et.begin();
		account.setBlance(account.getBlance() - amount);
		em.merge(account);
		et.commit();

		System.out.println("Withdrawal successful! New Balance: " + account.getBlance());
	}

	
}
