package soar.ws.knowyourneighbours;

import java.net.URL;

import javax.xml.rpc.ServiceException;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.configuration.FileProvider;

public class KnowYourNeighboursApp {
	public static void main(String[] args) throws Exception {
		EngineConfiguration config = new FileProvider(
				KnowYourNeighboursApp.class.getResourceAsStream("knowyourneighboursclient.wsdd"));
		KnowYourNeighboursSoapBindingStub stub = 
				(KnowYourNeighboursSoapBindingStub) 
					new KnowYourNeighboursServiceLocator(config)
					.getKnowYourNeighbours(new URL("http://localhost:8280/services/KnowYourNeighboursProxy"));
		
		stub.setUsername("joe");
		
		System.out.println(stub.getNeighbours("France"));
		
		//KnowYourNeighbours k = new KnowYourNeighboursServiceLocator().getKnowYourNeighbours();
		//System.out.println(k.getNeighbours("France"));
	}
}