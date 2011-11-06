package ershop.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Eugen, 11/3/11 8:58 PM
 */
public class SetupDB {
    static final private String PERSISTENCE_UNIT= "Inventory";
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        em.close();
    }
}
