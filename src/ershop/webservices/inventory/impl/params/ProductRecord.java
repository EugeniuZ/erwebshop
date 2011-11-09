package ershop.webservices.inventory.impl.params;

import java.util.ArrayList;
import java.util.List;

//must be the JPA entity of the ProductCatalog table

public class ProductRecord {
    private String categoryItemID;
    private String producerName;
    private String categoryRef;
    private String description;
    private int productID;
    private String name;
    private double price;
    private int quantityInStock;
    private double weight;
    private int availabilityThreshold;
    private int quantityResupply;
    private int quantityLocked;
    private List<Promotion> promotions;

    public String getCategoryItemID() {
        return categoryItemID;
    }

    public void setCategoryItemID(String categoryItemID) {
        this.categoryItemID = categoryItemID;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getCategoryRef() {
        return categoryRef;
    }

    public void setCategoryRef(String categoryRef) {
        this.categoryRef = categoryRef;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAvailabilityThreshold() {
        return availabilityThreshold;
    }

    public void setAvailabilityThreshold(int availabilityThreshold) {
        this.availabilityThreshold = availabilityThreshold;
    }

    public int getQuantityResupply() {
        return quantityResupply;
    }

    public void setQuantityResupply(int quantityResupply) {
        this.quantityResupply = quantityResupply;
    }

    public int getQuantityLocked() {
        return quantityLocked;
    }

    public void setQuantityLocked(int quantityLocked) {
        this.quantityLocked = quantityLocked;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        if (this.promotions != null)
        {
            this.promotions.addAll(promotions);
        }
        else
        {
            this.promotions = promotions;
        }
    }

    public void addPromotion(Promotion promo)
    {
        if (promotions == null)
        {
            promotions = new ArrayList<Promotion>(1);
        }
        promotions.add(promo);
    }

}