package ershop.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Eugen, 11/3/11 8:58 PM
 */
public class SetupDB {
    static final private String PERSISTENCE_UNIT= "Inventory";
    // Create DB tables by instantiation the EntityManager for the given PersistenceUnit
    public static void main(String[] args) throws InterruptedException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        em.close();
    }
}
