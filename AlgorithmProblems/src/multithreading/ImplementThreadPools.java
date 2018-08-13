package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ImplementThreadPools implements Runnable {
	String city=null;
	public ImplementThreadPools(String city) {
		this.city=city;
	}
	public void run () {
		System.out.println("Started");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		optimisedProcess(city);
		System.out.println("Completed");
		
	}
public void optimisedProcess (String city) {
		System.out.println("Processing city "+city+" with thread Pool Id "+Thread.currentThread().getName());
	}
public static void main (String [] args) {
	//ExecutorService exec = Executors.newFixedThreadPool(10);
	ExecutorService exec = Executors.newCachedThreadPool();
	
	List <String> cityList= new ArrayList <String> ();
	for (int i=0; i<10;i++) {
	cityList.add("city"+i);
	}
	for (int i=0; i< 10;i++) {
		exec.submit(new ImplementThreadPools(cityList.get(i)));
	}
	exec.shutdown();
	System.out.println("All tasks submitted");
	try {
	exec.awaitTermination(1, TimeUnit.DAYS);
	} catch (InterruptedException e) {
		
	}
	System.out.println("All tasks Completed");
	}
}
