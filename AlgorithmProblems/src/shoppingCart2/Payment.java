package shoppingCart2;

import java.util.ArrayList;
import java.util.List;

public class Payment {
	List<String> availablePaymentStrategies;
	Payment() {
		this.availablePaymentStrategies= new ArrayList<>();
	}
	public void availablePaymentMethods() {
		System.out.println("Please select your payment method");
		availablePaymentStrategies.add("Credit Card");
		availablePaymentStrategies.add("Paypal");
		for (int i=0; i<availablePaymentStrategies.size(); i++) {
			System.out.println(i+1+"     "+availablePaymentStrategies.get(i));
		}
	}
	public int getAvailablePaymentStrategiesSize () {
		return availablePaymentStrategies.size();
	}
}
