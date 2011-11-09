package ershop.webservices.inventory.impl.params;

/**
 * @author Eugen, 11/7/11 11:11 PM
 */
public class Promotion {
    private int minQuantityForPromotion;
    private float discount;


    /**
     * what's the minimal quantity to be bought to benefit from the discount
     */
    public int getMinQuantityForPromotion() {
        return minQuantityForPromotion;
    }

    public void setMinQuantityForPromotion(int minQuantityForPromotion) {
        this.minQuantityForPromotion = minQuantityForPromotion;
    }

    /**
     * the discount in decimal units, e.g. 5% = 0.05
     */
    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}