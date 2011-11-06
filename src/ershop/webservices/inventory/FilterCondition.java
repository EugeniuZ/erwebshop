package ershop.webservices.inventory;

public interface FilterCondition {

    /**
     * Sets the field that will be tested by this FilterCriteria condition
     * @param field A field from the ProductCatalog table
     */
    void setTestedField(ProductField field);

    /**
     * Appends on OR condition to this condition
     * </p>
     * When the filter clause will be generated the OR condition will be placed after
     * this condition (e.g. "<this_condition> OR <or_condition>")
     * @param ORCondition
     */
    void setOrCondition(FilterCondition ORCondition);

    /**
     * Appends on AND condition to this condition
     * </p>
     * When the filter clause will be generated the AND condition will be placed after
     * this condition (e.g. "<this_condition> AND <and_condition>")
     * @param ANDCondition
     */
    void setAndCondtition(FilterCondition ANDCondition);

    /**
     * @return The string representation of a where clause condition
     */
    public String getFilterClause();
}
