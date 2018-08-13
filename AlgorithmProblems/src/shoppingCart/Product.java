package shoppingCart;

public class Product {
	
	String name;
	int price;
	
	Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public Product(String string) {
		this.name=string;
		// TODO Auto-generated constructor stub
	}
	public String getName(){
		return name;
	}
	public int getPrice() {
		return price;
	}
	public boolean equals (Object o) {
		if (o instanceof Product) {
			Product p = (Product) o;
			if (p.getName()==name) {
				return true;
			}
		}
		return false;
	}
	public int hashCode () {
		int hash=0;
		for (int i=0;i<name.length(); i++) {
			hash=hash+name.charAt(i);
		}
		return hash*31;
	}

}
