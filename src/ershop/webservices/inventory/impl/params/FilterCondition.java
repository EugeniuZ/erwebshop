package ershop.webservices.inventory.impl.params;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class FilterCondition{

    @XmlElement(name = "field")
    private ProductField field;
    @XmlElement(name = "operator")
    private String operator;
    @XmlElement(name = "values")
    private String values;

    @XmlElement(name = "andCondition")
    private FilterCondition andCondition;
    @XmlElement(name = "orCondition")
    private FilterCondition orCondition;

    @XmlElement(name = "prefix")
    private String prefix = "";

    public FilterCondition() {
    }

    public FilterCondition(ProductField field, String operator, String values) {
        this.field = field;
        this.operator = operator;
        this.values = values;
    }

    /**
     * Sets the field that will be tested by this FilterCriteria condition
     *
     * @param field A field from the ProductCatalog table
     */
    public void setTestedField(ProductField field) {
        this.field = field;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setValues(String values) {
        this.values = values;
    }

    /**
     * Appends on OR condition to this condition
     * </p>
     * When the filter clause will be generated the OR condition will be placed after
     * this condition (e.g. "<this_condition> OR <or_condition>")
     *
     * @param ORCondition
     */
    public void setOrCondition(FilterCondition ORCondition) {
        orCondition = ORCondition;
    }

    /**
     * Appends on AND condition to this condition
     * </p>
     * When the filter clause will be generated the AND condition will be placed after
     * this condition (e.g. "<this_condition> AND <and_condition>")
     *
     * @param ANDCondition
     */
    public void setAndCondtition(FilterCondition ANDCondition) {
        andCondition = ANDCondition;
    }

    /**
     * @return The string representation of a where clause condition
     */
    public String getFilterClause() {
        return prefix+field +" "+operator+" "+values+
                (andCondition == null ? "" : " AND " + andCondition.getFilterClause()) +
                (orCondition == null ? "" : " OR " + orCondition.getFilterClause());
    }

    public void setPrefix(String p)
    {
        prefix = p+".";
        if (andCondition != null)
            andCondition.setPrefix(p);
        if (orCondition != null)
            orCondition.setPrefix(p);
    }
}
