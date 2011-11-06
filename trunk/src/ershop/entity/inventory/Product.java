package ershop.entity.inventory;

import java.util.Collection;

/**
 * @author Eugen, 11/3/11 5:16 PM
 */

/**
 * Represents and entity class that stores information about a given type of product\
 * <p/>
 * This is the primary entity managed by the inventory component of our webshop.
 * The entity has 2 keys:
 * <ul>
 * <li> &lt;categoryRef, categoryItemID&gt; which is used as a primary key (e.g. categoryRef = science fiction book,
 * categoryItemID = ISBN of that book).
 * <li> productID which is used as a unique key (referenced by other tables as a foreign key)
 * </ul>
 * The entity also stores product related info such as : name, description, producer, price, weight as well as
 * accounting information related to availability:
 * <ul>
 * <li> Number of items present in stock
 * <li> Number of items that are currently locked (reserved for some buyer but still not sold)
 * <li> Availability threshold - the minimal number of items, below which we start the resupply process for that item
 * <li> Resupply quantity - the number of items that will be acquired during the resupply process for this given type of item
 * </ul>
 */

public class Product {

    private int id;
    private ProductCategory categoryRef;
    private int productCategoryItemID;
    private String name;
    private String producerName;
    private float price;
    private float weight;
    private int quantityInStock;
    private int quantityLocked;
    private int availabilityThreshold;
    private int resupplyQuantity;
    private String description;
    private Collection<Promotion> promotions;
}
