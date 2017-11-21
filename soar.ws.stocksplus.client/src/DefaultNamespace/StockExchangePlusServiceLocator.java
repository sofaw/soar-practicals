/**
 * StockExchangePlusServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

public class StockExchangePlusServiceLocator extends org.apache.axis.client.Service implements DefaultNamespace.StockExchangePlusService {

    public StockExchangePlusServiceLocator() {
    }


    public StockExchangePlusServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public StockExchangePlusServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for StockExchangePlus
    private java.lang.String StockExchangePlus_address = "http://localhost:8080/soar.ws.stocksplus/services/StockExchangePlus";

    public java.lang.String getStockExchangePlusAddress() {
        return StockExchangePlus_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String StockExchangePlusWSDDServiceName = "StockExchangePlus";

    public java.lang.String getStockExchangePlusWSDDServiceName() {
        return StockExchangePlusWSDDServiceName;
    }

    public void setStockExchangePlusWSDDServiceName(java.lang.String name) {
        StockExchangePlusWSDDServiceName = name;
    }

    public DefaultNamespace.StockExchangePlus getStockExchangePlus() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(StockExchangePlus_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getStockExchangePlus(endpoint);
    }

    public DefaultNamespace.StockExchangePlus getStockExchangePlus(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            DefaultNamespace.StockExchangePlusSoapBindingStub _stub = new DefaultNamespace.StockExchangePlusSoapBindingStub(portAddress, this);
            _stub.setPortName(getStockExchangePlusWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setStockExchangePlusEndpointAddress(java.lang.String address) {
        StockExchangePlus_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (DefaultNamespace.StockExchangePlus.class.isAssignableFrom(serviceEndpointInterface)) {
                DefaultNamespace.StockExchangePlusSoapBindingStub _stub = new DefaultNamespace.StockExchangePlusSoapBindingStub(new java.net.URL(StockExchangePlus_address), this);
                _stub.setPortName(getStockExchangePlusWSDDServiceName());
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
        if ("StockExchangePlus".equals(inputPortName)) {
            return getStockExchangePlus();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://DefaultNamespace", "StockExchangePlusService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://DefaultNamespace", "StockExchangePlus"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("StockExchangePlus".equals(portName)) {
            setStockExchangePlusEndpointAddress(address);
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
