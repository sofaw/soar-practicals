/**
 * KnowYourNeighboursServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package soar.ws.knowyourneighbours;

public class KnowYourNeighboursServiceLocator extends org.apache.axis.client.Service implements soar.ws.knowyourneighbours.KnowYourNeighboursService {

    public KnowYourNeighboursServiceLocator() {
    }


    public KnowYourNeighboursServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public KnowYourNeighboursServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for KnowYourNeighbours
    private java.lang.String KnowYourNeighbours_address = "http://localhost:8080/soar.ws.knowyourneighbours/services/KnowYourNeighbours";

    public java.lang.String getKnowYourNeighboursAddress() {
        return KnowYourNeighbours_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String KnowYourNeighboursWSDDServiceName = "KnowYourNeighbours";

    public java.lang.String getKnowYourNeighboursWSDDServiceName() {
        return KnowYourNeighboursWSDDServiceName;
    }

    public void setKnowYourNeighboursWSDDServiceName(java.lang.String name) {
        KnowYourNeighboursWSDDServiceName = name;
    }

    public soar.ws.knowyourneighbours.KnowYourNeighbours getKnowYourNeighbours() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(KnowYourNeighbours_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getKnowYourNeighbours(endpoint);
    }

    public soar.ws.knowyourneighbours.KnowYourNeighbours getKnowYourNeighbours(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            soar.ws.knowyourneighbours.KnowYourNeighboursSoapBindingStub _stub = new soar.ws.knowyourneighbours.KnowYourNeighboursSoapBindingStub(portAddress, this);
            _stub.setPortName(getKnowYourNeighboursWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setKnowYourNeighboursEndpointAddress(java.lang.String address) {
        KnowYourNeighbours_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (soar.ws.knowyourneighbours.KnowYourNeighbours.class.isAssignableFrom(serviceEndpointInterface)) {
                soar.ws.knowyourneighbours.KnowYourNeighboursSoapBindingStub _stub = new soar.ws.knowyourneighbours.KnowYourNeighboursSoapBindingStub(new java.net.URL(KnowYourNeighbours_address), this);
                _stub.setPortName(getKnowYourNeighboursWSDDServiceName());
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
        if ("KnowYourNeighbours".equals(inputPortName)) {
            return getKnowYourNeighbours();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://knowyourneighbours.ws.soar", "KnowYourNeighboursService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://knowyourneighbours.ws.soar", "KnowYourNeighbours"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("KnowYourNeighbours".equals(portName)) {
            setKnowYourNeighboursEndpointAddress(address);
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
