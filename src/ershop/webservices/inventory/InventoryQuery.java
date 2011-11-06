package ershop.webservices.inventory;

import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Map;


import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;



@WebService(
        name = "InventoryQuery",
        serviceName = "InventoryService",
        targetNamespace = "http://imselabs/lab2/group4"
)
@SOAPBinding(
        style = SOAPBinding.Style.DOCUMENT,
        use = SOAPBinding.Use.LITERAL,
        parameterStyle = SOAPBinding.ParameterStyle.WRAPPED
)

public class InventoryQuery implements IInventoryQuery{
	
	
	//private final static Map<String, Person> people = new Map<String, Person>();
	private static final HashMap<String, Float> Map = null;
	//private static final Map<String, Float> Map1 = new Map<String, Float>();
	
	ProductRecord[] ProductRecord = null;
	ProductRecord productID;
	
	/**
     * Returns the full product information for a given product type (given by a product identifier = ProductID field in ProductCatalog)
     *
     * @param productID The internal ID of the product type in the database
     * @return full product information
     */
	
	@WebMethod(
            operationName = "getProductInfo",
            action = "urn:getProductInfo"
    )
    @WebResult(
            name = "productID",
            targetNamespace = "http://imselabs/lab2/group4"
    )
    public ProductRecord getProductInfo(ProductRecord productID){
    	System.out.println("What's up");
    	return productID;
    }

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
	
	@WebMethod(
            operationName = "findProducts",
            action = "urn:findProducts"
    )
    @WebResult(
            name = "ProductRecord",
            targetNamespace = "http://imselabs/lab2/group4"
    )
    public ProductRecord[] findProducts(
    		@WebParam(name = "selectedFields")ProductField[] selectedFields, 
    		@WebParam(name = "condition")FilterCondition condition, 
    		@WebParam(name = "orderFields") ArrayList<HashMap<ProductField, Boolean>> orderFields)
    {
    	return ProductRecord;
    }

    /**
     * Locks the selected items in the repository so that no other customer can purchase them
     * <p/>
     * One usage scenario is to call this method when creating the order object from the shopping cart contents
     *
     * @param lockedItems A list of items to lock. The list is a map that contains as key the product ID and as value the number
     * of items to lock
     * @throws ItemsNotInStockException Thrown when the required number of items is not available in the stock. The exception
     * will contain a list of items that are not any more in the stock as well as the quantity required to resupply in order
     * to satisfy this request
     */
	
	@Oneway
	public void extractProductsForShipment(
			@WebParam(name = "lockedItems") HashMap<String, Integer> lockedItems) 
				throws ItemsNotInStockException
	{
	System.out.println("Hello!");	
	}

    /**
     * Unlocks the items previously locked and makes them available for other customer to acquire
     * <p/>
     * One usage scenario is to call this method when some item is removed from the order list or when the order is cancelled althogether
     *
     * @param itemsToUnlock  A list of items to unlock. The list is a map that contains as key the product ID and as value the number
     * of items to unlock
     */
	
	@Oneway
    public void putBackItems(
    		@WebParam(name = "itemsToUnlock") HashMap<String, Integer> itemsToUnlock)
    {
    	
    }

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
	@WebMethod(
            operationName = "getMap",
            action = "urn:HashMap"
    )
    @WebResult(
            name = "Map",
            targetNamespace = "http://imselabs/lab2/group4"
    )
	public HashMap<String, Float> computeFinalPrice(
			@WebParam(name = "productID") String[] productID, 
			@WebParam(name = "countryPrefix") String countryPrefix)
	{
		System.out.println("hello map");
		return Map;
	}
}
