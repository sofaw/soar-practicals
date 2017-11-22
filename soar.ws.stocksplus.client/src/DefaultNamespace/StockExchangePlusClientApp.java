package DefaultNamespace;

import java.net.URL;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.configuration.FileProvider;

public class StockExchangePlusClientApp {
	public static void main(String[] args) throws Exception {
		EngineConfiguration config = new FileProvider(StockExchangePlusClientApp.class
				.getResourceAsStream("stockexchangeplusclient.wsdd"));
		
		StockExchangePlusSoapBindingStub stub = (StockExchangePlusSoapBindingStub)
				new StockExchangePlusServiceLocator(config).getStockExchangePlus(
						new URL("http://localhost:8280/services/StockExchangePlusProxy"));
		
		stub.setUsername("joe");
		
		System.out.println(stub.getAveragePrice("IBM"));
	}
}
