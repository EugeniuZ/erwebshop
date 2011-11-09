package ershop.webservices.inventory.impl.faults;

import ershop.webservices.inventory.impl.params.MapEntry;

/**
 * @author Eugen, 11/8/11 9:19 PM
 */

public class ItemsNotInStockList {
    private MapEntry<Integer, Integer>[] unavailableItems;

    public MapEntry<Integer, Integer>[] getUnavailableItems() {
        return unavailableItems;
    }

    public void setUnavailableItems(MapEntry<Integer, Integer>[] unavailableItems) {
        this.unavailableItems = unavailableItems;
    }
}
