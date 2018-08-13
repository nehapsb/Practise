package shoppingCart2;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class ShoppingCart {
List<Item> items;
List<Item> availItems;
public ShoppingCart() {
	this.items= new ArrayList<>();
	this.availItems= new ArrayList<>();
}
public void addItem(Item item) {
	this.items.add(item);
}
public boolean remove(Item item) {
	return this.items.remove(item);
}
public double calculateTotal () {
double total=0;
	for (Item i: availItems) {
		total=total+i.getPrice();
	}
	return total;
}
public void pay (PaymentStrategy payment) {
	double amount = calculateTotal();
    payment.pay(amount);
}
public int totalItems () {
	return items.size();
}
public Item getItem (int index) {
	return items.get(index);
}
public void displayItems(ShoppingCart list) {
	System.out.println("Items Available are ");
	System.out.println("Sno     Name          Price");
	for (int i=0; i <list.totalItems();i++)
	System.out.println(i+1+"    "+list.getItem(i).getName()+"          "+list.getItem(i).getPrice()+"     "+list.getItem(i).getCount());
}
public void addItemToBoughtList (Item i) {
	availItems.add(i);
}
public void decreaseCountForitem(Item item) {
	item.setCount(item.getCount()-1);
}
public void buyItem(ShoppingCart sc) {
	System.out.println("Please enter your choice ");
	Scanner scan= new Scanner(System.in); 
	int arg=scan.nextInt();
	if (arg <= sc.totalItems()) {
		if (sc.getItem(arg-1).getCount()>0) {
		sc.addItemToBoughtList(sc.getItem(arg-1));
		System.out.println("Thanks for choosing "+sc.getItem(arg-1).getName()+" your amount is "+sc.getItem(arg-1).getPrice());
		System.out.println("Total amount is "+sc.calculateTotal());
		decreaseCountForitem(sc.getItem(arg-1));
	} else {
		System.out.println("Sorry, no more items are available for this product");
		System.out.println("Your total is "+sc.calculateTotal());
	}
	} else {
		System.out.println("Please give the right choice");
	}
}
public void payAmount(ShoppingCart sc) {
	double toBePaid= sc.calculateTotal();
	Payment p = new Payment();
	p.availablePaymentMethods();
	Scanner scan = new Scanner(System.in);
	int arg=scan.nextInt();
	if (arg<=p.getAvailablePaymentStrategiesSize()) {
		System.out.println("Thanks for paying the amount"+toBePaid);
		if ((arg-1)==1 ) {
			
		}
	}
}
}
