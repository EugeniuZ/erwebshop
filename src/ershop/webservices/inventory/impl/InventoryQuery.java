package ershop.webservices.inventory.impl;

import ershop.dao.QueryDao;
import ershop.entity.inventory.ProductEntity;
import ershop.webservices.inventory.IInventoryQuery;
import ershop.webservices.inventory.impl.faults.ItemsNotInStockException1;
import ershop.webservices.inventory.impl.faults.ItemsNotInStockException2;
import ershop.webservices.inventory.impl.faults.TechnicalException;
import ershop.webservices.inventory.impl.params.*;

import javax.jws.WebService;
import java.util.List;

@WebService(
        serviceName = "InventoryService",
        endpointInterface = "ershop.webservices.inventory.IInventoryQuery"
)
public class InventoryQuery implements IInventoryQuery {

    private QueryDao query = new QueryDao();

    public ProductRecord getProductInfo(int productID) throws TechnicalException {
        ProductRecord record = null;
        try {
            ProductEntity entity = query.findProduct(productID);
            record = DataMapper.convertToProductRecords(new ProductEntity[]{entity})[0];

        } catch (Exception ex) {
            throw new TechnicalException("Some internal error occured. Retry calling the web service later.", ex);
        }
        return record;
    }

    public ProductRecord[] findProducts(ProductField[] selectedFields, FilterCondition condition,
                                        OrderByField[] orderFields) throws TechnicalException {
        String queryString = DataMapper.getQueryString(selectedFields, condition, orderFields);
        List<Object[]> results = null;
        try {
            results = query.findProducts(queryString);
        } catch (Exception ex) {
            throw new TechnicalException("Some internal error occured. Retry calling the web service later.", ex);
        }
        return DataMapper.buildRecords(selectedFields, results);
    }

    public void extractProductsForShipment(
            MapEntry<Integer, Integer>[] lockedItems) throws ItemsNotInStockException2, TechnicalException {
        try {
            query.lockItems(lockedItems);
        } catch (ItemsNotInStockException2 ex) {
            throw ex;
        } catch (Exception ex) {
            throw new TechnicalException("Some internal error occured. Retry calling the web service later.", ex);
        }
    }

    public void putBackItems(
            MapEntry<Integer, Integer>[] itemsToUnlock) throws TechnicalException {
        try {
            query.unlockItems(itemsToUnlock);
        }catch (Exception ex) {
            throw new TechnicalException("Some internal error occured. Retry calling the web service later.", ex);
        }
    }

    public MapEntry<Integer, Double>[] computeFinalPrice(Integer[] productID, String countryPrefix) throws TechnicalException {
         try {
            return query.computePrices(productID, countryPrefix);
        }catch (Exception ex) {
            throw new TechnicalException("Some internal error occured. Retry calling the web service later.", ex);
        }
    }


}


