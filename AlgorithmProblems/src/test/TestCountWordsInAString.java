package test;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import Practice.CountWordsInAString;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCountWordsInAString {
	CountWordsInAString obj= null;
	@Before 
	public void setup() {
		obj= new CountWordsInAString();
	}
	@After
	public void cleanup () {
		obj=null;
	}
	@Test
	public void testCountAndSortWordsInAStringKey() {
		Map<String, Integer> m = new TreeMap<String, Integer>();
		assertArrayEquals( returnValueMap(), convertMapToArray(obj.countAndSortWordsInAStringKey("this is what this is")));
		assertNull(obj.countAndSortWordsInAStringKey(null));
		assertNull(convertMapToArray(obj.countAndSortWordsInAStringKey("")));
		m.put("this", 1);
		assertArrayEquals( convertMapToArray(m), convertMapToArray(obj.countAndSortWordsInAStringKey("this")));
	}
	public Object [] convertMapToArray (Map<?, ?> m) {
		if (m==null) {
			return null;
		}
		Set<?> entry = m.entrySet();
		return entry.toArray();
	}
	public Object [] returnValueMap() {
		Map<String, Integer> m = new TreeMap<String, Integer>() ;
		m.put("this", 2);
		m.put("is", 2);
		m.put("what", 1);
		return convertMapToArray(m);
	}

}
