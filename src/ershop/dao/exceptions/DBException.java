package ershop.dao.exceptions;

/**
 * @author Eugen, 11/8/11 10:19 AM
 */
public class DBException extends Exception {

    public DBException(){
        super();
    }
    public DBException(String msg)
    {
        super(msg);
    }
    public DBException(String msg, Throwable t)
    {
        super(msg,t);
    }

}
