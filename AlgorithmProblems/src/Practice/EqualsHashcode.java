package Practice;

class EqualsTest {
	int id;
	String name;
	
	EqualsTest(int id, String name) { // Even if you don't use constructor to initialize the id and name param, 
		this.id = id;					//in main method if you call setID and then check equality..it will work according to equals method
		this.name= name;
	}
	public int getID(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setID(int ID){
		this.id = ID;
	}
	
	public void setName(String name){
		this.name = name;;
	}
	
	public boolean equals(Object o){
		if(o instanceof EqualsTest){
			if(this.getID() == ((EqualsTest)o).getID()){
				return true;
			}
		}
		return false;
	}
	
}

public class EqualsHashcode {
	public static void main(String[] args) {
		EqualsTest eqTest1 = new EqualsTest(1, "name1");
		EqualsTest eqTest2 = new EqualsTest(2, "name2");
		eqTest1.setID(2);
		eqTest2.setID(2);
		System.out.println("eqTest1 == eqTest2 --> " + ( eqTest1==eqTest2));
		System.out.println("eqTest1.equals eqTest2 --> " + ( eqTest1.equals(eqTest2)));
		System.out.println("eqTest1.hashcode() -->" + eqTest1.hashCode() + "  eqTest2.hashcode() -->" + eqTest2.hashCode());
	}
}
