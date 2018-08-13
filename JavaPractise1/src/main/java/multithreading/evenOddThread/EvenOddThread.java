package main.java.multithreading.evenOddThread;

 class PrintEvenNumbersJob {

private Object lock;

public PrintEvenNumbersJob(Object lock) {
    this.lock = lock;
}
Runnable even = new Runnable () {
@Override
public void run() {
    synchronized (lock) {
        for (int i = 0; i <= 10; i += 2) {
            lock.notify();
            System.out.println("Even number : " + i);
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
       // lock.notify(); // not required if thread1 gains lock first
    }
}

};
Runnable odd = new Runnable() {
	@Override
	public void run() {
	    synchronized (lock) {
	        for (int i = 1; i < 10; i += 2) {
	            lock.notify();
	            System.out.println("Odd Number: "+i);

	            try {
	                lock.wait();
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }

	        }
	        lock.notify();
	    }
	}
};


}

public class EvenOddThread {
	public static void main(String[] args) {
		Object lock = new Object();
	    Thread thread1 = new Thread(new PrintEvenNumbersJob(lock).even);
	    Thread thread2 = new Thread(new PrintEvenNumbersJob(lock).odd);
	    thread1.start();
	    thread2.start();
	    
}
}
