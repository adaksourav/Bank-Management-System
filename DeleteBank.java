package testbank;

import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import mainclass.Bank;
import util.UtilClass;

public class DeleteBank {
	public static void deleteBank() {

		EntityManager em = UtilClass.getEntityManagerFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		Scanner dc = new Scanner(System.in);
		System.out.println("Enter bank name to delete");
		String bankName = dc.nextLine();
		Bank b = em.find(Bank.class, bankName);
		if (b != null) {
			et.begin();
			em.remove(b);
			et.commit();
			System.out.println("Delete bank details sucessfully");
		} else {
			System.err.println("invalid bank to delete to find");
		}
		
	}
	public static void main(String[] args) {
		deleteBank();
	}
}
