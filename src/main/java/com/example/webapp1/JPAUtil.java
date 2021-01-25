package com.example.webapp1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final String PERSISTENCE_UNIT = "persistencePU";
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public static void closeEntityManager() {
        if (factory != null) {
            factory.close();
        }
    }
}
