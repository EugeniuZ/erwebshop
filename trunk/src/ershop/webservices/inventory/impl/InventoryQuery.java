package ershop.webservices.inventory.impl;

import ershop.webservices.inventory.IInventoryQuery;
import ershop.webservices.inventory.impl.params.*;

import javax.jws.WebService;
import java.util.List;

@WebService(
        serviceName = "InventoryService",
        endpointInterface = "ershop.webservices.inventory.IInventoryQuery"
)
public class InventoryQuery implements IInventoryQuery {

    public ProductRecord getProductInfo(ProductRecord productID) {
        return null;
    }

    public ProductRecord[] findProducts(ProductField[] selectedFields, FilterCondition condition,
            List<MapContainer<ProductField, Boolean>> orderFields) {
        return null;
    }

    public void extractProductsForShipment(
            MapContainer<String, Integer> lockedItems) throws ItemsNotInStockException {
    }

    public void putBackItems(
            MapContainer<String, Integer> itemsToUnlock) {
    }

    public MapContainer<String, Float> computeFinalPrice(String[] productID, String countryPrefix) {
        return null;
    }
}
