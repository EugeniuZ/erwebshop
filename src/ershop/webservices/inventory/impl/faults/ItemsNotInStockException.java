package ershop.webservices.inventory.impl.faults;

import ershop.webservices.inventory.impl.params.MapEntry;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.ws.WebFault;

@WebFault(name = "ItemsNotInStockException", faultBean = "ItemsNotInStockList")
public class ItemsNotInStockException extends Exception {

    @XmlElement(name = "exceptionData")
    @XmlElementWrapper(name = "NeedToResupplyItemsList")
    private ItemsNotInStockList exceptionData;

    public ItemsNotInStockException() {

    }

    public ItemsNotInStockException(ItemsNotInStockList faultBean) {
        exceptionData = faultBean;
    }


    public ItemsNotInStockException(String msg, ItemsNotInStockList faultBean) {
        super(msg);
        exceptionData = faultBean;
    }

    public ItemsNotInStockException(String msg, ItemsNotInStockList faultBean, Throwable t) {
        super(msg, t);
        exceptionData = faultBean;
    }

    /*must implement this method to enable throwing the exception by the web service
  * see: http://www.ibm.com/developerworks/forums/thread.jspa?threadID=216339*/
    public ItemsNotInStockList getFaultInfo() {
        return exceptionData;
    }

    public ItemsNotInStockList getExceptionData() {
        return exceptionData;
    }

    public MapEntry<Integer, Integer>[] getUnavailableItems() {
        return exceptionData.getUnavailableItems();
    }
}