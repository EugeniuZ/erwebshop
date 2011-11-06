package ershop.entity.inventory;

import java.io.Serializable;

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

public class Tax {
    private TaxKey tKey;
    private ProductCategory prodCategory;
    private float vat;
}


class TaxKey implements Serializable{
    String countryPrefix;
    String productCategory;

    @Override
    public boolean equals(Object o)
    {
        if (o == this)
            return true;
        if (!(o instanceof TaxKey))
            return false;
        TaxKey other = (TaxKey) o;
        return countryPrefix == other.countryPrefix && productCategory.equals(other.productCategory);
    }

    @Override
    public int hashCode()
    {
        return (productCategory+countryPrefix).hashCode();
    }
}
