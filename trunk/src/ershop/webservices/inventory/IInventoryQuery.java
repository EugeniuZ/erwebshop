package ershop.webservices.inventory;

import ershop.webservices.inventory.impl.params.*;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * @author Eugen, 11/1/11 6:22 PM
 */
@WebService(
        name = "InventoryQuery",
        targetNamespace = "http://imselabs/lab2/group4"
)
public interface IInventoryQuery {

    /**
     * Returns the full product information for a given product type (given by a product identifier = ProductID field in ProductCatalog)
     *
     * @param productID The internal ID of the product type in the database
     * @return full product information
     */
    @WebMethod
    ProductRecord getProductInfo(ProductRecord productID);

    /**
     * Retrieves the list of products according to some filter conditions
     * <p/>
     * Internally the filter condition will be transformed into a 'where' clause on the database. The method abstracts
     * this from the client through a client-friendly API
     *
     * @param selectedFields The list of fields that should be selected from the database
     * @param condition The filter condition (or chain of conditions connected by logical operators) to apply to the search
     * @param orderFields The list of product fields to order the result by. The boolean variable states if the sorting should be
     * done in ascending order (true) or descending (false)
     * @return The list of products that match the filtering conditions. The product records will contain only relevant values
     * only in the fields selected in 'selectedFields' parameter
     */
    @WebMethod
    ProductRecord[] findProducts(ProductField[] selectedFields, FilterCondition condition, List<MapContainer<ProductField, Boolean>> orderFields);

    /**
     * Locks the selected items in the repository so that no other customer can purchase them
     * <p/>
     * One usage scenario is to call this method when creating the order object from the shopping cart contents
     *
     * @param lockedItems A list of items to lock. The list is a map that contains as key the product ID and as value the number
     * of items to lock
     * @throws ershop.webservices.inventory.impl.params.ItemsNotInStockException Thrown when the required number of items is not available in the stock. The exception
     * will contain a list of items that are not any more in the stock as well as the quantity required to resupply in order
     * to satisfy this request
     */
    @WebMethod
	void extractProductsForShipment(MapContainer<String, Integer> lockedItems) throws ItemsNotInStockException;

    /**
     * Unlocks the items previously locked and makes them available for other customer to acquire
     * <p/>
     * One usage scenario is to call this method when some item is removed from the order list or when the order is cancelled althogether
     *
     * @param itemsToUnlock  A list of items to unlock. The list is a map that contains as key the product ID and as value the number
     * of items to unlock
     */
    @WebMethod
    @Oneway
    void putBackItems(MapContainer<String, Integer> itemsToUnlock);

    /**
     * Computes the price of a product taking into consideration the country-dependent taxes for that particular product
     * <p/>
     * Method will be invoked in order to compute the price of the products in the order list taking into consideration
     * the taxes that apply to that product for that particular country
     *
     * @param productID The product ID ( = ProductID from the ProductCatalog table)
     * @param countryPrefix The country prefix ( = Prefix field from the Country table)
     * @return The list of products together with their prices (original price + country-specific taxes)
     */
    @WebMethod
    MapContainer<String, Float> computeFinalPrice(String[] productID, String countryPrefix);
}



