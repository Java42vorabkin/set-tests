package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetTests {
Integer[] initialNumbers = {
	10, 20, 40, 60	
};
Set<Integer> set;
	@BeforeEach
	void setUp() throws Exception {
		set = new TreeSet<>();
		fillSet();
	}

	private void fillSet() {
		for(Integer num: initialNumbers) {
			set.add(num);
		}
		
	}

	@Test
	void addTest() {
		assertEquals(initialNumbers.length, set.size());
		for(Integer num: initialNumbers) {
			assertTrue(set.contains(num));
		}
		assertTrue(set.add(80));
		assertFalse(set.add(80));
		
	}
	@Test
	void containsTest() {
		assertTrue(set.contains(60));
		assertFalse(set.contains(80));
	}
	private <T> T[] getArrayFromSet(Set<T> set) {
		T[] res = (T[]) new Object[set.size()];
		Iterator<T> itr = set.iterator();
		int ind = 0;
		while(itr.hasNext()) {
			res[ind++] = itr.next();
		}
		return res;
	}
	private <T> Set<T> createSetFromArray(T[] array) {
		Set<T> set = new TreeSet<>();
		for(T value : array) {
			set.add(value);
		}
		return set;
	}
	@Test
	//TODO
	//Done!!
	void iteratorTreeSetTest() {
		
		set.add(-80);
		set.add(55);
		set.add(60);
		set.add(-100);
		set.add(100);
		set.add(90);
		set.add(115);
		Integer exp1[] = {-80, 55, 60, -100, 100, 90, 115, 10, 20, 40};
		Arrays.sort(exp1);
		assertArrayEquals(exp1, getArrayFromSet(set));
		//
		Integer exp2[] = { 100, 4, -18, 74, -34, 204 };
		Set<Integer> tmpSet = createSetFromArray(exp2);
		Arrays.sort(exp2);
		assertArrayEquals(exp2, getArrayFromSet(tmpSet));
		//
		Integer exp3[] = { -18, -34, 74, 100, 204, 4 };
		Set<Integer> tmpSet1 = createSetFromArray(exp3);
		Arrays.sort(exp3);
		assertArrayEquals(exp3, getArrayFromSet(tmpSet1));
	}
	

}
