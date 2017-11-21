package calculator.app;

import calculator.ApplicationInfo;
import calculator.CalculatorPOA;

public class CalculatorImpl extends CalculatorPOA {

	@Override
	public int add(int x, int y) {
		return x + y;
	}

	@Override
	public int[] getNext(int base, int howMany) {
		int[] next = new int[howMany];
		for(int i = 0; i < howMany; i++) {
			next[i] = base + i + 1;
		}
		return next;
	}

	@Override
	public ApplicationInfo getApplicationInfo() {
		return new ApplicationInfo(1, "First version");
	}

}
