package shoppingCart2;

public class Item {
String name;
double price;
int count;
Item (String name, double price, int count) {
	this.name=name;
	this.price=price;
	this.count=count;
}
public String getName () {
		return name;
}
public double getPrice() {
		return price;
}
public int getCount() {
		return count;
}
public void setCount(int count) {
		this.count=count;
}
}
