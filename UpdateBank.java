package testbank;

import java.util.Scanner;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import util.UtilClass;

public class UpdateBank {
	

	public static void updateNoOfBranches() {
		 
		 EntityManager em = UtilClass.getEntityManagerFactory().createEntityManager();
		 EntityTransaction et = em.getTransaction();
		 Scanner uc = new Scanner(System.in);
		System.out.println("Enter Bank Name:");
		String bankName = uc.next();

		System.out.println("Enter new number of branches:");
		int branches = uc.nextInt();

		try {
			et.begin();
			Query query = em.createQuery("UPDATE Bank b SET b.noOfBranches = :branches WHERE b.bankName = :name");
			query.setParameter("branches", branches);
			query.setParameter("name", bankName);
			int rows = query.executeUpdate();
			et.commit();
			if (rows > 0) {
				System.out.println(" Number of branches updated successfully.");
			} else {
				System.out.println(" No bank found with given Name.");
			}
		} catch (Exception e) {
			if (et.isActive())
				et.rollback();
			e.printStackTrace();
		}
	}

	public static void updateIFSCcode() {

		 EntityManager em = UtilClass.getEntityManagerFactory().createEntityManager();
		 EntityTransaction et = em.getTransaction();
		 Scanner uc = new Scanner(System.in);
		System.out.println("Enter Bank Name:");
		String bankName = uc.next();

		System.out.println("Enter new IFSC code:");
		String ifsc = uc.next();

		try {
			et.begin();
			Query query = em.createQuery("UPDATE Bank b SET b.ifscNo = :ifsc WHERE b.bankName = :name");
			query.setParameter("ifsc", ifsc);
			query.setParameter("name", bankName);
			int rows = query.executeUpdate();
			et.commit();
			if (rows > 0) {
				System.out.println(" IFSC code updated successfully.");
			} else {
				System.out.println(" No bank found with given Name.");
			}
		} catch (Exception e) {
			if (et.isActive())
				et.rollback();
			e.printStackTrace();
		}
	}

	public static void updateAddress() {
		
		 EntityManager em = UtilClass.getEntityManagerFactory().createEntityManager();
		 EntityTransaction et = em.getTransaction();
		 Scanner uc = new Scanner(System.in);
		System.out.println("Enter Bank Name:");
		String bankName = uc.next();

		System.out.println("Enter new Address:");
		uc.nextLine();
		String address = uc.nextLine();

		try {
			et.begin();
			Query query = em.createQuery("UPDATE Bank b SET b.BankAddress = :address WHERE b.bankName = :name");
			query.setParameter("address", address);
			query.setParameter("name", bankName);
			int rows = query.executeUpdate();
			et.commit();
			if (rows > 0) {
				System.out.println(" Address updated successfully.");
			} else {
				System.out.println(" No bank found with given Name.");
			}
		} catch (Exception e) {
			if (et.isActive())
				et.rollback();
			e.printStackTrace();
		}
	}

	public static void updateBank(){
		Scanner uc=new Scanner(System.in);
		boolean f = true;
		while (f) {
			System.out.println("\n<><><><><><><><><><><><><><><><>");
			System.out.println("2)..Update IFSC code");
			System.out.println("3)..Update bank address");
			System.out.println("4)..Update number of branches");
			System.out.println("5)..Exit");
			System.out.println("<><><><><><><><><><><><><><><><>");
			System.out.print("Enter your choice: ");
			int key = uc.nextInt();
			switch (key) {
			case 4:
				updateNoOfBranches();
				break;
			case 2:
				updateIFSCcode();
				break;
			case 3:
				updateAddress();
				break;
			case 5:
				f = false;
				System.out.println("Exiting update menu...");
				break;
			default:
				System.out.println(" Invalid choice. Try again.");
			}
		}
	}
}
