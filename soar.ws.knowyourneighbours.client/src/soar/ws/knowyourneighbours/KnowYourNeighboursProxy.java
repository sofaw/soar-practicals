package soar.ws.knowyourneighbours;

public class KnowYourNeighboursProxy implements soar.ws.knowyourneighbours.KnowYourNeighbours {
  private String _endpoint = null;
  private soar.ws.knowyourneighbours.KnowYourNeighbours knowYourNeighbours = null;
  
  public KnowYourNeighboursProxy() {
    _initKnowYourNeighboursProxy();
  }
  
  public KnowYourNeighboursProxy(String endpoint) {
    _endpoint = endpoint;
    _initKnowYourNeighboursProxy();
  }
  
  private void _initKnowYourNeighboursProxy() {
    try {
      knowYourNeighbours = (new soar.ws.knowyourneighbours.KnowYourNeighboursServiceLocator()).getKnowYourNeighbours();
      if (knowYourNeighbours != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)knowYourNeighbours)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)knowYourNeighbours)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (knowYourNeighbours != null)
      ((javax.xml.rpc.Stub)knowYourNeighbours)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public soar.ws.knowyourneighbours.KnowYourNeighbours getKnowYourNeighbours() {
    if (knowYourNeighbours == null)
      _initKnowYourNeighboursProxy();
    return knowYourNeighbours;
  }
  
  public java.lang.String getNeighbours(java.lang.String country) throws java.rmi.RemoteException{
    if (knowYourNeighbours == null)
      _initKnowYourNeighboursProxy();
    return knowYourNeighbours.getNeighbours(country);
  }
  
  
}