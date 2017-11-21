import soar.ws.calculator.Calculator;
import soar.ws.calculator.CalculatorServiceLocator;
import soar.ws.stockexchange.StockExchangeServiceLocator;
import soar.ws.stockexchange.StockPrice;

public class StockExchangePlus {
	public float getAveragePrice(String stock) throws Exception {
		StockPrice stockPrice = new StockExchangeServiceLocator().getStockExchange().getStockPrice(stock);
		
		Calculator calculator = new CalculatorServiceLocator().getCalculator();
		
		return calculator.average(stockPrice.getMin(), stockPrice.getMax());
	}
}
