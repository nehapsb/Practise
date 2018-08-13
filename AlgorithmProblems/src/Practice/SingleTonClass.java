package Practice;

public class SingleTonClass {

	private static volatile SingleTonClass obj;
	private SingleTonClass() {
	}
	public static SingleTonClass getInstance() {
		if (obj==null) {
			synchronized (SingleTonClass.class) {
				if (obj==null)
			obj=new SingleTonClass();
		}
		}
		return obj;
	}
	
	
	public void show () {
		int i=0;
		synchronized (obj) {
			i=i+1;
		}
		System.out.println("created");
	}
	public static void main (String[] args) {
		SingleTonClass obj1=getInstance();
		obj1.show();
		System.out.println(obj1);
		SingleTonClass obj2=getInstance();
		System.out.println(obj);
	}
}
