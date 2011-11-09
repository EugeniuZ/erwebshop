package ershop.entity.inventory;

/**
 * @author Eugen, 11/3/11 5:50 PM
 */

/**
 * Represents an entity class that stores information about a promotion for a given productEntity.
 * <p/>
 *     The promotion states that for a given 'productEntity id' (referencing productID from {@link ProductEntity})
 *     there is a percentage discount (represented as decimal number between 0 and 1) if the customer buys
 *     at least some minimal quantity of items. The primary key is the promotion ID.
 *
 */
public class PromotionEntity {
    private int id;
    private ProductEntity productEntity;
    private int quantityMin;
    private float discount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public int getQuantityMin() {
        return quantityMin;
    }

    public void setQuantityMin(int quantityMin) {
        this.quantityMin = quantityMin;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}
