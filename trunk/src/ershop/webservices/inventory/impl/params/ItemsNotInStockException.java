package ershop.webservices.inventory.impl.params;

import java.util.HashMap;
import java.util.Map;

public class ItemsNotInStockException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1591417775669724847L;
	final private Map<String, Integer> unavailableItems;

    protected ItemsNotInStockException(Map<String, Integer> items){
        unavailableItems = new HashMap<String,Integer>();
        unavailableItems.putAll(items);
    }

    public Map<String, Integer> getUnavailbleItems()
    {
        return unavailableItems;
    }
}