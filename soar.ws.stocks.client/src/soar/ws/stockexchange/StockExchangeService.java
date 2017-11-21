/**
 * StockExchangeService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package soar.ws.stockexchange;

public interface StockExchangeService extends javax.xml.rpc.Service {
    public java.lang.String getStockExchangeAddress();

    public soar.ws.stockexchange.StockExchange getStockExchange() throws javax.xml.rpc.ServiceException;

    public soar.ws.stockexchange.StockExchange getStockExchange(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
