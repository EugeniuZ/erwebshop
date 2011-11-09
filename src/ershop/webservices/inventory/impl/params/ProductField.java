package ershop.webservices.inventory.impl.params;

public enum ProductField {
    CategoryItemID("PRODUCTCATEGORYITEM_ID") {
        public void setValue(ProductRecord r, Object value) {
            r.setCategoryRef((String) value);
        }
    },
    Category_REF("PRODUCTCATEGORY_IDREF") {
        public void setValue(ProductRecord r, Object value) {
            r.setCategoryItemID((String) value);
        }
    },
    ProductID("ID") {
        public void setValue(ProductRecord r, Object value) {
            r.setProductID((Integer) value);
        }
    },
    Name("NAME") {
        public void setValue(ProductRecord r, Object value) {
            r.setName((String) value);
        }
    },
    Price("PRICE") {
        public void setValue(ProductRecord r, Object value) {
            r.setPrice((Double) value);
        }
    },
    QuantityInStock("QTYSTOCK") {
        public void setValue(ProductRecord r, Object value) {
            r.setQuantityInStock((Integer) value);
        }
    },
    Weight("WEIGHT") {
        public void setValue(ProductRecord r, Object value) {
            r.setWeight((Float) value);
        }
    },
    AvailabilityThreshold("AVAILABILITYTHRESHOLD") {
        public void setValue(ProductRecord r, Object value) {
            r.setAvailabilityThreshold((Integer) value);
        }
    },
    Description("DESCRIPTION") {
        public void setValue(ProductRecord r, Object value) {
            r.setDescription((String) value);
        }
    },
    ProducerName("PRODUCERNAME") {
        public void setValue(ProductRecord r, Object value) {
            r.setProducerName((String) value);
        }
    },
    ResupplyQuantity("QTYRESUPPLY") {
        public void setValue(ProductRecord r, Object value) {
            r.setQuantityResupply((Integer) value);
        }
    },
    LockedQuantity("QTYLOCKED") {
        public void setValue(ProductRecord r, Object value) {
            r.setQuantityLocked((Integer) value);
        }
    };

    private String fieldName;

    ProductField(String name) {
        fieldName = name;
    }

    @Override
    public String toString() {
        return fieldName;
    }

    abstract public void setValue(ProductRecord rec, Object value);
}
