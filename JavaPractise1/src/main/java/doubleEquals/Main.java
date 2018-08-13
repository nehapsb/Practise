package main.java.doubleEquals;

public class Main {
	final static double EPSILON = 0.001;

	public static void main(String[] argv) {
		double da = 77.58613586425781;
		double db = 77.5860278;

		// Compare two numbers that are expected to be close.
		if (da == db) {
			System.out.println("Java considers " + da + "==" + db);
			// else compare with our own equals method
		} else if (equals(da, db, 0.001)) {
			System.out.println("True within epsilon " + EPSILON);
		} else {
			System.out.println(da + " != " + db);
		}
	}

	/** Compare two doubles within a given epsilon */
	public static boolean equals(double a, double b, double eps) {
		if (a == b) {
			return true;
		}
		// If the difference is less than epsilon, treat as equal.
		return Math.abs(a - b) < eps;
	}

	/** Compare two doubles, using default epsilon */
	public static boolean equals(double a, double b) {
		if (a == b) {
			return true;
		}
		// If the difference is less than epsilon, treat as equal.
		return Math.abs(a - b) < (EPSILON * Math.max(Math.abs(a), Math.abs(b)));
	}
}