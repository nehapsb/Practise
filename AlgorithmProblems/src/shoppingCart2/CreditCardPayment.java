package shoppingCart2;

import java.util.Date;

public class CreditCardPayment implements PaymentStrategy {
long cardNumber;
int cvv;
Date expiryDate;
public	CreditCardPayment (long cardNumber, int cvv, Date expiryDate) {
	this.cardNumber=cardNumber;
	this.cvv=cvv;
	this.expiryDate=expiryDate;
}
	public void pay (double amount) {
	System.out.println(amount+" paid through credit card");
}
}
