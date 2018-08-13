package shoppingCart2;

import java.security.KeyStore.PasswordProtection;

public class PayPalPayment {
String emailId;
String password;
PasswordProtection pwd;
public PayPalPayment(String emailId, String password) {
	this.emailId=emailId;
	this.password=password;
	pwd = new PasswordProtection(password.toCharArray());

}
public void pay (double amount) {
	System.out.println(amount+" paid using paypal");
	System.out.println("Password is "+password+" passwordprotection is "+pwd);
}
}
