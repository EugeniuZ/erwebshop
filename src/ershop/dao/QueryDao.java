package ershop.dao;

import ershop.dao.exceptions.DBException;
import ershop.entity.inventory.ProductEntity;
import ershop.entity.inventory.TaxEntity;
import ershop.entity.inventory.TaxKey;
import ershop.webservices.inventory.impl.faults.*;
import ershop.webservices.inventory.impl.params.MapEntry;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eugen, 11/7/11 7:58 PM
 */
public class QueryDao {
    public final String PERSISTENCE_UNIT = "Inventory";

    private EntityManagerFactory emf;
    private Exception dbException;

    public QueryDao() {
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        } catch (Exception ex) {
            ex.printStackTrace();
            dbException = ex;
            // also could log that
        }
    }


    public List<Object[]> findProducts(String query) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createNativeQuery(query);
        List results = q.getResultList();
        em.close();
        return results;
    }

    public ProductEntity findProduct(int id) throws DBException {
        if (emf != null) {
            EntityManager em = emf.createEntityManager();
            ProductEntity prod = em.find(ProductEntity.class, id);
            em.close();
            return prod;
        } else {
            throw new DBException("A database problem was encountered. Please try calling the web service later", dbException);
        }

    }

    public void lockItems(MapEntry<Integer, Integer>[] lockedItems) throws ItemsNotInStockException2 {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tm = em.getTransaction();
        List<MapEntry<Integer, Integer>> unavailableItems = new ArrayList<MapEntry<Integer, Integer>>();
        List<MapEntry<ProductEntity, Integer>> entitiesToLock = new ArrayList<MapEntry<ProductEntity, Integer>>();
        tm.begin();
        for (MapEntry<Integer, Integer> lockedItem : lockedItems) {
            ProductEntity p = em.find(ProductEntity.class, lockedItem.getKey(), LockModeType.PESSIMISTIC_WRITE);
            int missingItems = 0;
            if ((missingItems = lockedItem.getValue() - p.getQuantityInStock()) > 0) {
                unavailableItems.add(new MapEntry<Integer, Integer>(lockedItem.getKey(), missingItems));
            } else {
                entitiesToLock.add(new MapEntry<ProductEntity, Integer>(p, lockedItem.getValue()));
            }
        }
        if (unavailableItems.size() > 0) {
            tm.commit();
            em.close();
            ItemsNotInStockList list = new ItemsNotInStockList();
            list.setUnavailableItems(unavailableItems.toArray(new MapEntry[0]));
            ItemsNotInStockException ex = new ItemsNotInStockException("Some items are not available in requested quanity", list);
            /*throw new ItemsNotInStockException1(new IntegerArray(new Integer(3)));*/
            throw new ItemsNotInStockException2(new Integer(3));
            /*throw ex;*/
        } else {
            for (MapEntry<ProductEntity, Integer> entry : entitiesToLock) {
                ProductEntity entity = entry.getKey();
                entity.setQuantityInStock(entity.getQuantityInStock() - entry.getValue());
                entity.setQuantityLocked(entity.getQuantityLocked() + entry.getValue());
                em.persist(entity);
            }
            tm.commit();
            em.close();
        }
    }

    public void unlockItems(MapEntry<Integer, Integer>[] itemsToUnlock) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tm = em.getTransaction();
        tm.begin();
        for (MapEntry<Integer, Integer> entry : itemsToUnlock) {
            ProductEntity p = em.find(ProductEntity.class, entry.getKey());
            p.setQuantityInStock(p.getQuantityInStock() + entry.getValue());
            p.setQuantityLocked(p.getQuantityLocked() - entry.getValue());
            em.persist(p);
        }
        tm.commit();
        em.close();
    }

    public MapEntry<Integer, Double>[] computePrices(Integer[] productIDList, String countryPrefix) {
        MapEntry<Integer, Double>[] prices = (MapEntry<Integer, Double>[]) Array.newInstance(MapEntry.class, productIDList.length);
        EntityManager em = emf.createEntityManager();
        int i = 0;
        TypedQuery<Object[]> query = em.createQuery("SELECT p.categoryRef.category, p.price FROM ProductEntity p WHERE p.id = ?1", Object[].class);
        for (Integer productID : productIDList)
        {
            query.setParameter(1,productID);
            Object[] results = query.getResultList().get(0);
            TaxEntity tax = em.find(TaxEntity.class, new TaxKey(countryPrefix, (String)results[0]));
            double price = (Double) results[1];
            prices[i++] = new MapEntry<Integer, Double>(productID, price*(1+tax.getVat()) );
        }
        em.close();
        return prices;
    }
}
