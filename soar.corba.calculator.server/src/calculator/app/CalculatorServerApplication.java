package calculator.app;

import calculator.CalculatorHelper;
import soar.corba.easyorb.EasyORB;

public class CalculatorServerApplication {
	public static void main(String[] args) throws Exception {
		EasyORB orb = new EasyORB();
		orb.connect();
		orb.addService(new CalculatorImpl(), "Calculator", CalculatorHelper.class);
		orb.publishServices();
	}
} 
