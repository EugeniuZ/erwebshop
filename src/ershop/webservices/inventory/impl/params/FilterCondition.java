package ershop.webservices.inventory.impl.params;

public abstract class FilterCondition {

    private ProductField field;
    private FilterCondition andCondition, orCondition;

    /**
     * Sets the field that will be tested by this FilterCriteria condition
     * @param field A field from the ProductCatalog table
     */
    void setTestedField(ProductField field)
    {
        this.field = field;
    }

    /**
     * Appends on OR condition to this condition
     * </p>
     * When the filter clause will be generated the OR condition will be placed after
     * this condition (e.g. "<this_condition> OR <or_condition>")
     * @param ORCondition
     */
    void setOrCondition(FilterCondition ORCondition)
    {
        orCondition = ORCondition;
    }

    /**
     * Appends on AND condition to this condition
     * </p>
     * When the filter clause will be generated the AND condition will be placed after
     * this condition (e.g. "<this_condition> AND <and_condition>")
     * @param ANDCondition
     */
    void setAndCondtition(FilterCondition ANDCondition){
        andCondition = ANDCondition;
    }

    /**
     * @return The string representation of a where clause condition
     */
    public String getFilterClause(){
        return field + getSpecificConditionString()+
                (andCondition==null?"":" AND "+andCondition.getFilterClause())+
                (orCondition==null?"":" OR "+orCondition.getFilterClause());
    }

    abstract public String getSpecificConditionString();
}
