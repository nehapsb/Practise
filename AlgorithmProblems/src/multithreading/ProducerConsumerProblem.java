package multithreading;

import java.util.Vector;

public class ProducerConsumerProblem {
public static void main (String [] args) {
	Vector sharingVector = new Vector<>();
	Thread produce = new Thread (new Produce(sharingVector));
	Thread consume = new Thread (new Consumer(sharingVector));
	produce.start();
	consume.start();
}
}

class Produce implements Runnable{
	Vector sharingVector;
	int count=0;
	Produce (Vector sharingVector) {
		this.sharingVector=sharingVector;
	}
	public void run () {
		for (int i=0; i<10;i++) {
			produce();
		}
	}
	private void produce () {
		synchronized (sharingVector) {
			if (!sharingVector.isEmpty()) {
				try {
					sharingVector.wait ();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Produced "+count);
			sharingVector.add(count++);
			sharingVector.notify();
		}
	}
	
}
class Consumer implements Runnable{
	Vector sharingVector;
	Consumer (Vector sharingVector) {
		this.sharingVector=sharingVector;
	}
	public void run () {
		for (int i=0;i<10;i++)
		consume ();
	}
	void consume(){
		synchronized (sharingVector) {
			if (sharingVector.isEmpty()) {
				try {
				sharingVector.wait ();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			System.out.println("Consumed "+sharingVector.get(0));
			sharingVector.remove(0);
			sharingVector.notify();
		}
	}
}