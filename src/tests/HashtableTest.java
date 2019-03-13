package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.NoBookException;
import hashtable.Hashtable;

class HashtableTest {

	private Hashtable<Integer, String> hash;
	
	void stage1() {
		hash=new Hashtable<>(3);
	}
	
	void stage2() {
		stage1();
		hash.add(50, "Juliancho");
		hash.add(5, "Barrios");
		hash.add(53, "Bristo");
		hash.add(70, "Mora");
		hash.add(12, "Cristian");
		hash.add(4, "Norah");
		hash.add(23, "Kris");
	}
	
	@Test
	void addSuccesTest() {
		stage2();
		boolean flag=false;
		try {
			hash.find(53).getValue();
			assertEquals(hash.find(53).getValue(), "Bristo");
		} catch (NoBookException e) {
			flag=true;
		}
		assertFalse(flag);
	}
	
	@Test
	void deleteTest() {
		stage2();
		boolean flag=false;
		try {
			hash.delete(50, "Juliancho");
		} catch (NoBookException e) {
			flag=true;
		}
		assertFalse(flag);
		try {
			assertNull(hash.find(50));
		} catch (NoBookException e) {
			flag=true;
		}
		assertTrue(flag);
	}
	
	@Test
	void hashFunctoinTest() {
		stage2();
		boolean flag=true;
		if(hash.hashFunction(999999)>hash.getNodes().length) {
			flag=false;
		}
		assertTrue(flag);
	}

	@Test
	void test() {
		stage2();
		
	}
}
