package ershop.entity.inventory;

/**
 * @author Eugen, 11/3/11 5:50 PM
 */

/**
 * Represents an entity class that stores information about a promotion for a given product.
 * <p/>
 *     The promotion states that for a given 'product id' (referencing productID from {@link Product})
 *     there is a percentage discount (represented as decimal number between 0 and 1) if the customer buys
 *     at least some minimal quantity of items. The primary key is the promotion ID.
 *
 */
public class Promotion {
    private int id;
    private Product product;
    private int quantityMin;
    private float discount;

}
