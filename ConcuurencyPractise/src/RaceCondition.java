
public class RaceCondition {

int x=0,y=0;

int setX () {
	x=1;
	int i=y;
	System.out.println("X is "+x);
	return i;
}
int setY () {
	int j=x;
	y=1;
	
	System.out.println("y is "+y);
	return j;
}

public static void main (String [] args) {
	

Runnable r1 = new Runnable() {
	
	@Override
	public void run() {
		System.out.println("Thread 1 "+(new RaceCondition()).setX());
	}
};
Runnable r2 = new Runnable() {
	
	@Override
	public void run() {
		System.out.println("Thread 2 "+(new RaceCondition()).setY());
		
	}
};

Thread t1 = new Thread (r1);
Thread t2 = new Thread (r2);
t1.start();
t2.start();
}
}
