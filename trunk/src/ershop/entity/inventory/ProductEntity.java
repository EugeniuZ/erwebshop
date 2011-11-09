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

public class ProductEntity {

    private int id;
    private ProductCategoryEntity categoryRef;
    private String productCategoryItemID;
    private String name;
    private String producerName;
    private double price;
    private double weight;
    private int quantityInStock;
    private int quantityLocked;
    private int availabilityThreshold;
    private int resupplyQuantity;
    private String description;
    private Collection<PromotionEntity> promotionEntities;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductCategoryEntity getCategoryRef() {
        return categoryRef;
    }

    public void setCategoryRef(ProductCategoryEntity categoryRef) {
        this.categoryRef = categoryRef;
    }

    public String getProductCategoryItemID() {
        return productCategoryItemID;
    }

    public void setProductCategoryItemID(String productCategoryItemID) {
        this.productCategoryItemID = productCategoryItemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public int getQuantityLocked() {
        return quantityLocked;
    }

    public void setQuantityLocked(int quantityLocked) {
        this.quantityLocked = quantityLocked;
    }

    public int getAvailabilityThreshold() {
        return availabilityThreshold;
    }

    public void setAvailabilityThreshold(int availabilityThreshold) {
        this.availabilityThreshold = availabilityThreshold;
    }

    public int getResupplyQuantity() {
        return resupplyQuantity;
    }

    public void setResupplyQuantity(int resupplyQuantity) {
        this.resupplyQuantity = resupplyQuantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<PromotionEntity> getPromotionEntities() {
        return promotionEntities;
    }

    public void setPromotionEntities(Collection<PromotionEntity> promotionEntities) {
        this.promotionEntities = promotionEntities;
    }
}
