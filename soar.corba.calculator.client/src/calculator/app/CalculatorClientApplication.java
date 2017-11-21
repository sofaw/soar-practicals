package calculator.app;

import java.util.Arrays;
import calculator.Calculator;
import calculator.CalculatorHelper;
import soar.corba.easyorb.EasyORB;

public class CalculatorClientApplication {
	public static void main(String[] args) throws Exception {
		EasyORB orb = new EasyORB();
		orb.connect();
		Calculator calculator = (Calculator) orb.getService("Calculator", CalculatorHelper.class);
		System.out.println(calculator.add(5, 3));
		System.out.println(Arrays.toString(calculator.getNext(5, 3)));
		System.out.println(calculator.getApplicationInfo().description);
	}
} 
