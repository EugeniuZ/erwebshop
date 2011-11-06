package ershop.webservices.inventory.impl.params;

import java.util.List;

//must be the JPA entity of the ProductCatalog table

public class ProductRecord {
    private int categoryItemID;
    private String categoryRef;
    private int productID;
    private String name;
    private float price;
    private int quantityInStock;
    private float weight;
    private int availabilityThreshold;
    private int quantityResupply;
    private int quantityLocked;
    List<Promotion> promotions;

    class Promotion {
        /**
         * what's the minimal quantity to be bought to benefit from the discount
         */
        private int minQuantityForPromotion;
        /**
         * the discount in decimal units, e.g. 5% = 0.05
         */
        private float discount;


        public void setminQuantityForPromotion(int minQuantityForPromotion) {
            this.minQuantityForPromotion = minQuantityForPromotion;
        }

        public int getminQuantityForPromotion() {
            return minQuantityForPromotion;
        }


        public void setdiscount(float discount) {
            this.discount = discount;
        }

        public float getdiscount() {
            return discount;
        }

    }


    public void setcategoryItemID(int categoryItemID) {
        this.categoryItemID = categoryItemID;
    }

    public int getcategoryItemID() {
        return categoryItemID;
    }


    public void setcategoryRef(String categoryRef) {
        this.categoryRef = categoryRef;
    }

    public String getcategoryRef() {
        return categoryRef;
    }


    public void setproductID(int productID) {
        this.productID = productID;
    }

    public int getproductID() {
        return productID;
    }


    public void setname(String name) {
        this.name = name;
    }

    public String getname() {
        return name;
    }

    public void setprice(float price) {
        this.price = price;
    }

    public float getprice() {
        return price;
    }

    public void setquantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public int getquantityInStock() {
        return quantityInStock;
    }

    public void setweight(float weight) {
        this.weight = weight;
    }

    public float getweight() {
        return weight;
    }

    public void setavailabilityThreshold(int availabilityThreshold) {
        this.availabilityThreshold = availabilityThreshold;
    }

    public int getavailabilityThreshold() {
        return availabilityThreshold;
    }

    public void setquantityResupply(int quantityResupply) {
        this.quantityResupply = quantityResupply;
    }

    public int getquantityResupply() {
        return quantityResupply;
    }

    public void setquantityLocked(int quantityLocked) {
        this.quantityLocked = quantityLocked;
    }

    public int getQuantityLocked() {
        return quantityLocked;
    }
}