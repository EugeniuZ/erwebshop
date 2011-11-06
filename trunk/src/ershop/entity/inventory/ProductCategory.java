package ershop.entity.inventory;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author Eugen, 11/3/11 5:48 PM
 */

/**
 * Represents an entity class that stores information about a given product category mapping.
 * <p/>
 *     The category states the custom categories used in our database for a product (e.g. electronic book, cartoons, fabric)
 *     and its mapping to a common product type identifier which should be understood universally by other web shops, i.e.
 *     the 'category' is the internally used product type identifier and the 'product type identifier' designates the universal
 *     product type identifiers.
 */
public class ProductCategory implements Serializable {

    private String category;
    // we might have categories of products that are not mapped to any global standart product type
    private String productTypeIdentifier;
    private Collection<Product> products;
    private Collection<Tax> taxes;
}
