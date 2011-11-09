package ershop.webservices.inventory.impl.faults;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.WebFault;

@WebFault(name = "ItemsNotInStockException1", faultBean = "IntegerArray")
@XmlSeeAlso(ershop.webservices.inventory.impl.faults.IntegerArray.class)
public class ItemsNotInStockException1 extends Exception {

    @XmlElement(name = "exceptionData")
    private IntegerArray exceptionData;

    public ItemsNotInStockException1() {

    }

    public ItemsNotInStockException1(IntegerArray faultBean) {
        exceptionData = faultBean;
    }


    public ItemsNotInStockException1(String msg, IntegerArray faultBean) {
        super(msg);
        exceptionData = faultBean;
    }

    public ItemsNotInStockException1(String msg, IntegerArray faultBean, Throwable t) {
        super(msg, t);
        exceptionData = faultBean;
    }

    /*must implement this method to enable throwing the exception by the web service
  * see: http://www.ibm.com/developerworks/forums/thread.jspa?threadID=216339*/
    public IntegerArray getFaultInfo() {
        return exceptionData;
    }
}