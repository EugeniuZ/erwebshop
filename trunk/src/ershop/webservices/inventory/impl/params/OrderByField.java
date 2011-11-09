package ershop.webservices.inventory.impl.params;

/**
 * @author Eugen, 11/8/11 3:33 PM
 */
public class OrderByField {
    private ProductField field;

    public ProductField getField() {
        return field;
    }

    public void setField(ProductField field) {
        this.field = field;
    }

    public Boolean getAscending() {
        return isAscending;
    }

    public void setAscending(Boolean ascending) {
        isAscending = ascending;
    }

    private Boolean isAscending;


}
