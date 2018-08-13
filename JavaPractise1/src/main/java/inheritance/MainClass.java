package main.java.inheritance;

import java.util.HashMap;
import java.util.Map;

public class MainClass {

    public static void main(String[] args) {
	Map<String, BaseFeedback> testMap = new HashMap<String, BaseFeedback>();

	Map<String, BaseFeedback> testMap2 = new HashMap<String, BaseFeedback>();
	BaseFeedback virtualObj1 = new ChildClass1();
	virtualObj1.setSomeVal("Obj1");
	BaseFeedback virtualObj2 = new ChildClass1();
	virtualObj1.setSomeVal("Obj2");
	testMap2.put("Intra", virtualObj1);
	testMap2.put("Intra2", virtualObj2);

	testMap.get("Intra");
	ChildClass1 object = ((ChildClass1) testMap2.get("Intra"));
	object.setSomeVal("Num");
	System.out.println(object.getSomeVal());
    }
}
