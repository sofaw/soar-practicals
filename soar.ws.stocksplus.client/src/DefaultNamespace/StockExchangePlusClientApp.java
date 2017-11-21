package DefaultNamespace;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.configuration.FileProvider;

public class StockExchangePlusClientApp {
	public static void main(String[] args) throws Exception {
		EngineConfiguration config = new FileProvider(StockExchangePlusClientApp.class
				.getResourceAsStream("stockexchangeplusclient.wsdd"));
		
		StockExchangePlusSoapBindingStub stub = (StockExchangePlusSoapBindingStub)
				new StockExchangePlusServiceLocator(config).getStockExchangePlus();
		
		stub.setUsername("joe");
		
		System.out.println(stub.getAveragePrice("IBM"));
	}
}
