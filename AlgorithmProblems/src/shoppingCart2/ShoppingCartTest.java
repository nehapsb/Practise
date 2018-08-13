package shoppingCart2;
import java.util.List;
import java.util.Scanner;
public class ShoppingCartTest {
	
public static void main (String [] args) {
	Item firstItem= new Item ("First", 100, 2);
	Item secondItem= new Item ("Second", 200, 3);
	Item thirdItem= new Item ("Third", 300, 7);
	ShoppingCart sc= new ShoppingCart();
	sc.addItem(firstItem);
	sc.addItem(secondItem);
	sc.addItem(thirdItem);
	sc.displayItems(sc);
	System.out.println("");
	sc.buyItem(sc);
	System.out.println("");
	String c = null;
	boolean bool=true;
	Scanner scan = new Scanner (System.in);
	while (bool) {
		System.out.println("Do you want to add more items (y/n)");
		c = scan.next();
		if (c.equals("y")) {
			sc.displayItems(sc);
			sc.buyItem(sc);
		} else if (c.equals("n")){
			bool = false;
		} else {
			System.out.println("Please choose right answer");
		}
	}
	sc.payAmount(sc);
	}
}
