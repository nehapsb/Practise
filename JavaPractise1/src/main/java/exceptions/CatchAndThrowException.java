package main.java.exceptions;

import java.util.Date;

public class CatchAndThrowException {

    public void throwingException() throws Exception {
	int i = 0;
	try {
	    i = 5 / 0;
	} catch (Exception e) {
	    System.out.println("Caught exception");
	    System.out.println(new Date());
	}
    }

    public void catchingException() {
	try {
	    throwingException();
	} catch (Exception e) {
	    System.out.println("Exception Thrown");
	}
    }

    public static void main(String[] args) {
	new CatchAndThrowException().catchingException();
    }
}
