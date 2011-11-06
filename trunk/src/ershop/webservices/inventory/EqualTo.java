package ershop.webservices.inventory;

public class EqualTo implements FilterCondition{

	private ProductField field;
	private String constant;
	private FilterCondition orCondition, andCondition;
	
	public EqualTo ()
	{
	}
	
	public EqualTo (String constant)
	{
		this.constant = constant;
	}
	
	
	public void setTestedField(ProductField field)
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
    public void setOrCondition(FilterCondition orCondition)
    {
    	this.orCondition = orCondition;
    }

    /**
     * Appends on AND condition to this condition
     * </p>
     * When the filter clause will be generated the AND condition will be placed after
     * this condition (e.g. "<this_condition> AND <and_condition>")
     * @param ANDCondition
     */
    public void setAndCondtition(FilterCondition andCondition)
    {
    	this.andCondition = andCondition;
    }	
    /**
     * @return The string representation of a where clause condition
     */
    public String getFilterClause()
    {
    	return field + "=" + constant + " AND (" + 
    	andCondition.getFilterClause() + ") OR (" + orCondition.getFilterClause()
    	+ ")";
    }


}
