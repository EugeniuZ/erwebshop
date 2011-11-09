package ershop.entity.inventory;

import java.io.Serializable;

/**
 * @author Eugen, 11/9/11 10:27 AM
 */
public class TaxKey implements Serializable {
    private String countryPrefix;
    private String productCategory;

    public TaxKey() {}

    public TaxKey (String countryPrefix, String productCategory)
    {
        this.countryPrefix = countryPrefix;
        this.productCategory = productCategory;
    }

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
