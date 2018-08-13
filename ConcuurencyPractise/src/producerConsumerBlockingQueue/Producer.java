package producerConsumerBlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
class Producing implements Runnable{
	private final BlockingQueue block;
	Producing (BlockingQueue block) {
		this.block=block;
	}
	public void run () {
		for (int i=0; i<10 ; i++) {
			try {
				block.put(i);
				System.out.println("Produced "+i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class Consuming implements Runnable {
	private final BlockingQueue block;
	Consuming (BlockingQueue block) {
		this.block=block;
	}
	public void run () {
		while (true) {
			try {
				int i=(int)block.take();
				System.out.println("Consumed "+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
public class Producer {
	public static void main (String [] args) {
		
BlockingQueue block=new LinkedBlockingQueue();
Thread t1=new Thread (new Producing (block));
Thread t2=new Thread (new Consuming (block));
t1.start();
t2.start();
}
}