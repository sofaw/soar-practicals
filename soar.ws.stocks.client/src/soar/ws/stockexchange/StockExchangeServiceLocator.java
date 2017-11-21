/**
 * StockExchangeServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package soar.ws.stockexchange;

public class StockExchangeServiceLocator extends org.apache.axis.client.Service implements soar.ws.stockexchange.StockExchangeService {

    public StockExchangeServiceLocator() {
    }


    public StockExchangeServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public StockExchangeServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for StockExchange
    private java.lang.String StockExchange_address = "http://www-users.cs.york.ac.uk/~dkolovos/apps/stocks/index.php";

    public java.lang.String getStockExchangeAddress() {
        return StockExchange_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String StockExchangeWSDDServiceName = "StockExchange";

    public java.lang.String getStockExchangeWSDDServiceName() {
        return StockExchangeWSDDServiceName;
    }

    public void setStockExchangeWSDDServiceName(java.lang.String name) {
        StockExchangeWSDDServiceName = name;
    }

    public soar.ws.stockexchange.StockExchange getStockExchange() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(StockExchange_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getStockExchange(endpoint);
    }

    public soar.ws.stockexchange.StockExchange getStockExchange(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            soar.ws.stockexchange.StockExchangeBindingStub _stub = new soar.ws.stockexchange.StockExchangeBindingStub(portAddress, this);
            _stub.setPortName(getStockExchangeWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setStockExchangeEndpointAddress(java.lang.String address) {
        StockExchange_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (soar.ws.stockexchange.StockExchange.class.isAssignableFrom(serviceEndpointInterface)) {
                soar.ws.stockexchange.StockExchangeBindingStub _stub = new soar.ws.stockexchange.StockExchangeBindingStub(new java.net.URL(StockExchange_address), this);
                _stub.setPortName(getStockExchangeWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("StockExchange".equals(inputPortName)) {
            return getStockExchange();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://stockexchange.ws.soar", "StockExchangeService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://stockexchange.ws.soar", "StockExchange"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("StockExchange".equals(portName)) {
            setStockExchangeEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
