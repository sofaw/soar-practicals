package soar.ws.stockexchange;

public class StockExchangeProxy implements soar.ws.stockexchange.StockExchange {
  private String _endpoint = null;
  private soar.ws.stockexchange.StockExchange stockExchange = null;
  
  public StockExchangeProxy() {
    _initStockExchangeProxy();
  }
  
  public StockExchangeProxy(String endpoint) {
    _endpoint = endpoint;
    _initStockExchangeProxy();
  }
  
  private void _initStockExchangeProxy() {
    try {
      stockExchange = (new soar.ws.stockexchange.StockExchangeServiceLocator()).getStockExchange();
      if (stockExchange != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)stockExchange)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)stockExchange)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (stockExchange != null)
      ((javax.xml.rpc.Stub)stockExchange)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public soar.ws.stockexchange.StockExchange getStockExchange() {
    if (stockExchange == null)
      _initStockExchangeProxy();
    return stockExchange;
  }
  
  public soar.ws.stockexchange.StockPrice getStockPrice(java.lang.String stock) throws java.rmi.RemoteException{
    if (stockExchange == null)
      _initStockExchangeProxy();
    return stockExchange.getStockPrice(stock);
  }
  
  
}