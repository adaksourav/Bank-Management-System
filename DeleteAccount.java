package testaccount;

import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import mainclass.Bank;
import util.UtilClass;
import mainclass.AccountDetails;

public class DeleteAccount {
	public static void deleteAccount() {
		EntityManager em = UtilClass.getEntityManagerFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter bank name:");
		String bankName = sc.nextLine();
		Bank bank = em.find(Bank.class, bankName);

		if (bank != null) {
			System.out.println("Enter account number to delete from bank " + bankName + ":");
			long accountNum = sc.nextLong();

			AccountDetails acc = em.find(AccountDetails.class, accountNum);

			if (acc != null && acc.getBank().getBankName().equals(bankName)) {
				et.begin();
				Query q = em.createQuery("DELETE FROM AccountDetails a WHERE a.accountNumber = :accountNum");
				q.setParameter("accountNum", accountNum);
				int rows = q.executeUpdate();
				et.commit();

				if (rows > 0) {
					System.out.println("Account " + accountNum + " deleted successfully from bank " + bankName);
				} else {
					System.out.println("Failed to delete account " + accountNum);
				}
			} else {
				System.out.println("No account with number " + accountNum + " found in bank " + bankName);
			}
		} else {
			System.out.println("No bank found with name: " + bankName);
		}

	}

}
