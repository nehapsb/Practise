package shoppingCart;

import java.util.Hashtable;
import java.util.Set;
import java.util.Map.Entry;

public class MakeOrders {
	
	Hashtable<Product, Integer> productsTable = new Hashtable<Product, Integer>();
	
	public MakeOrders(Hashtable products){
		productsTable = products;
	}
	
	public void getProduct(Product product){
		int quantity = productsTable.get(product);
		System.out.println("Product is "+product.getName()+" And Price is "+product.getPrice()+" and quantity is "+quantity);
	//	productsTable.put(product, quantity);
	}

	public void displayAvailableProducts() {
		Set<Entry<Product, Integer>> entries = productsTable.entrySet();
		for(Entry<Product, Integer> entry : entries){
			 System.out.println(entry.getKey().getName()+" ==> "+entry.getValue());
		}
	}
	
	public static void main(String[] args) {
		Hashtable<Product, Integer> productAvailable = new Hashtable<Product, Integer>();
		Product p1= new Product("Product1", 250);
		Product p2=new Product("Product2", 200);
		Product p3=new Product("Product3", 285);
		/*Product p4=new Product("Product4", 300);
		Product p5=new Product("Product5", 150);
		*/productAvailable.put(p1, 5);
		productAvailable.put(p2, 2);
		productAvailable.put(p3, 3);
		productAvailable.put(new Product("Product4", 300), 4);
		productAvailable.put(new Product("Product5", 150), 6);
		MakeOrders order = new MakeOrders(productAvailable);
		order.displayAvailableProducts();
		Product p1Get = new Product ("Product5");
		order.getProduct(p1Get);
	}
}
