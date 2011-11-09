package ershop.webservices.inventory.impl;

import ershop.entity.inventory.ProductEntity;
import ershop.entity.inventory.PromotionEntity;
import ershop.webservices.inventory.impl.params.*;

import java.util.List;

/**
 * @author Eugen, 11/8/11 11:24 AM
 */
public class DataMapper {

    static ProductRecord[] convertToProductRecords(ProductEntity[] productEntities) {
        ProductRecord[] records = new ProductRecord[productEntities.length];
        int index = 0;
        for (ProductEntity p : productEntities) {
            ProductRecord record = new ProductRecord();
            record.setName(p.getName());
            record.setCategoryItemID(p.getProductCategoryItemID());
            record.setDescription(p.getDescription());
            record.setPrice(p.getPrice());
            record.setQuantityInStock(p.getQuantityInStock());
            record.setWeight(p.getWeight());
            record.setQuantityLocked(p.getQuantityLocked());
            record.setQuantityResupply(p.getResupplyQuantity());
            for (PromotionEntity promo : p.getPromotionEntities()) {
                Promotion promotion = new Promotion();
                promotion.setDiscount(promo.getDiscount());
                promotion.setMinQuantityForPromotion(promo.getQuantityMin());
                record.addPromotion(promotion);
            }
            records[index++] = record;
        }
        return records;
    }

    public static String getQueryString(ProductField[] selectedFields, FilterCondition condition, OrderByField[] orderFields) {
        StringBuilder query = new StringBuilder();

        // Create SELECT Clause
        query.append("SELECT ");
        if (selectedFields.length == 0) {
            //query.append("p");
        } else {
            for (int i = 0; i < selectedFields.length;) {
                query.append(selectedFields[i++]);
                if (i < selectedFields.length)
                {
                    query.append(",");
                }
            }
        }
        // Create FROM Clause
        query.append(" FROM webshop.ProductCatalog ");
        // Create WHERE Clause
        if (condition != null)
        {
            query.append(" WHERE ");
            //condition.setPrefix("p");
            query.append(condition.getFilterClause());
        }
        // Create ORDER BY Clause
        if (orderFields.length > 0)
        {
            query.append(" ORDER BY ");
            for (int i = 0; i < orderFields.length;)
            {
                OrderByField entry = orderFields[i++];
                query.append(entry.getField()+(entry.getAscending()?" ASC":" DESC"));
                if (i < orderFields.length)
                {
                    query.append(",");
                }
            }
        }
        return query.toString();
    }

    public static ProductRecord[] buildRecords(ProductField[] selectedFields, List<Object[]> results) {
        ProductRecord[] r = new ProductRecord[results.size()];
        for (int j = 0; j < results.size(); j++)
        {
            r[j] = new ProductRecord();
            for (int i = 0; i < selectedFields.length; i++)
            {
                selectedFields[i].setValue(r[j], results.get(j)[i]);
            }
        }
        return r;
    }
}
