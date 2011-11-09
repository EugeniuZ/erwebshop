package ershop.entity.inventory;

/**
 * @author Eugen, 11/3/11 5:52 PM
 */

/**
 * Represents an entity class that stores information about the tax value for a given product.
 * <p/>
 *      The tax for a product varies according to its type (e.g. book, beverages, appliances, etc.) and the
 *      destination country (each country may apply different taxes for a given type of product).
 *      <br/>
 *      The primary key of the table consists of the pair: <country code, product category>
 */

public class TaxEntity {
    private TaxKey tKey;
    private ProductCategoryEntity prodCategory;
    private double vat;

    public TaxKey gettKey() {
        return tKey;
    }

    public void settKey(TaxKey tKey) {
        this.tKey = tKey;
    }

    public ProductCategoryEntity getProdCategory() {
        return prodCategory;
    }

    public void setProdCategory(ProductCategoryEntity prodCategory) {
        this.prodCategory = prodCategory;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }
}


