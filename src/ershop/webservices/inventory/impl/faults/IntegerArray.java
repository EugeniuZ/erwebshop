package ershop.webservices.inventory.impl.faults;

/**
 * @author Eugen, 11/9/11 12:03 PM
 */
public class IntegerArray {
    private Integer unavailableItems;

    public IntegerArray() {}
    public IntegerArray(Integer array)
    {
        unavailableItems = array;
    }


    public Integer getUnavailableItems() {
        return unavailableItems;
    }

    public void setUnavailableItems(Integer unavailableItems) {
        this.unavailableItems = unavailableItems;
    }
}
