package testbank;

import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mainclass.AccountDetails;
import mainclass.Bank;
import util.UtilClass;

public class FindBank_all_account {
	public static void findRecord() {
		EntityManager em = UtilClass.getEntityManagerFactory().createEntityManager();
		Scanner fc = new Scanner(System.in);
		System.out.println("Enter Bank name to find the record");
		String bankName = fc.nextLine();
		Bank b = em.find(Bank.class, bankName);
		if (b != null) {
			List<AccountDetails> ac = b.getAccounts();
			for (AccountDetails p : ac) {
				System.out.println(p);
			}

		}
		else {
			System.err.println("Invalid bank name to find");
		}
		
	}
	public static void main(String[] args) {
		findRecord();
	}
}