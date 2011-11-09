package ershop.webservices.inventory.impl.faults;

import javax.xml.ws.WebFault;

/**
 * @author Eugen, 11/7/11 11:51 PM
 */

@WebFault(name = "TechnicalException")
public class TechnicalException extends Exception {
    public TechnicalException(){
        super();
    }
    public TechnicalException(String msg)
    {
        super(msg);
    }
    public TechnicalException(String msg, Throwable t)
    {
        super(msg,t);
    }

    /*must implement this method to enable throwing the exception by the web service
    * see: http://www.ibm.com/developerworks/forums/thread.jspa?threadID=216339*/
    public String getFaultInfo()
    {
        return getMessage();
    }


}
