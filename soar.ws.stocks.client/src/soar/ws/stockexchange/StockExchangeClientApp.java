package soar.ws.stockexchange;

public class StockExchangeClientApp {
	public static void main(String[] args) throws Exception {
		StockExchange stockExchange = new StockExchangeServiceLocator().getStockExchange();
		StockPrice stockPrice = stockExchange.getStockPrice("IBM");
		
		System.out.println("Current: " + stockPrice.getCurrent());
		System.out.println("Min: " + stockPrice.getMin());
		System.out.println("Max: " + stockPrice.getMax());
	}
}
