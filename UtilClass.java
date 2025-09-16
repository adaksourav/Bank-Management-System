package util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UtilClass {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("sourav");

	public static EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}

	public static void shutdown() {
		if (emf != null && emf.isOpen()) {
			emf.close();
		}
	}
}
