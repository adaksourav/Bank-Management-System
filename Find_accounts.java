package testaccount;

import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mainclass.AccountDetails;
import mainclass.Bank;
import util.UtilClass;

public class Find_accounts {
	public static void findAccountByBankAndNumber() {
	
		EntityManager em = UtilClass.getEntityManagerFactory().createEntityManager();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter bank name to search:");
		String bankName = sc.nextLine();

		Bank bank = em.find(Bank.class, bankName);

		if (bank != null) {
			System.out.println("Bank found: " + bank.getBankName());
			System.out.println("Enter account number to find in this bank:");
			long accountNum = sc.nextLong();

			AccountDetails account = em.find(AccountDetails.class, accountNum);

			if (account != null && account.getBank().getBankName().equals(bankName)) {
				System.out.println("Account found in bank: " + account);
			} else {
				System.out.println("No account with number " + accountNum + " found in bank " + bankName);
			}
		} else {
			System.out.println("No bank found with name: " + bankName);
		}

		
	}

	public static void main(String[] args) {
		findAccountByBankAndNumber();
	}
}
