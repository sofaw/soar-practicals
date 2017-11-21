package DefaultNamespace;

public class StockExchangePlusProxy implements DefaultNamespace.StockExchangePlus {
  private String _endpoint = null;
  private DefaultNamespace.StockExchangePlus stockExchangePlus = null;
  
  public StockExchangePlusProxy() {
    _initStockExchangePlusProxy();
  }
  
  public StockExchangePlusProxy(String endpoint) {
    _endpoint = endpoint;
    _initStockExchangePlusProxy();
  }
  
  private void _initStockExchangePlusProxy() {
    try {
      stockExchangePlus = (new DefaultNamespace.StockExchangePlusServiceLocator()).getStockExchangePlus();
      if (stockExchangePlus != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)stockExchangePlus)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)stockExchangePlus)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (stockExchangePlus != null)
      ((javax.xml.rpc.Stub)stockExchangePlus)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public DefaultNamespace.StockExchangePlus getStockExchangePlus() {
    if (stockExchangePlus == null)
      _initStockExchangePlusProxy();
    return stockExchangePlus;
  }
  
  public float getAveragePrice(java.lang.String stock) throws java.rmi.RemoteException{
    if (stockExchangePlus == null)
      _initStockExchangePlusProxy();
    return stockExchangePlus.getAveragePrice(stock);
  }
  
  
}