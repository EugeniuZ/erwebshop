package ershop.webservices.inventory.impl.faults;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.ws.WebFault;

@WebFault(name = "ItemsNotInStockException2", faultBean = "java.lang.Integer")
public class ItemsNotInStockException2 extends Exception {

    @XmlElement(name = "exceptionData")
    private Integer exceptionData;

    public ItemsNotInStockException2() {

    }

    public ItemsNotInStockException2(Integer faultBean) {
        exceptionData = faultBean;
    }


    public ItemsNotInStockException2(String msg, Integer faultBean) {
        super(msg);
        exceptionData = faultBean;
    }

    public ItemsNotInStockException2(String msg, Integer faultBean, Throwable t) {
        super(msg, t);
        exceptionData = faultBean;
    }

    /*must implement this method to enable throwing the exception by the web service
  * see: http://www.ibm.com/developerworks/forums/thread.jspa?threadID=216339*/
    public Integer getFaultInfo() {
        return exceptionData;
    }
}