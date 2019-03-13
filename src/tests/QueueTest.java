package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import queue.Queue;

class QueueTest {

	Queue<String> queue;
	
	void stage1() {
		queue= new Queue<String>();
	}
	
	void stage2() {
		stage1();
		queue.offer("alv");
		queue.offer("Mammaaaa");
		queue.offer("Ayuwoki");
		queue.offer("Eooo");
		queue.offer("HeeHee");
		queue.offer("LUV");
		
	}

	@Test
	void peekTest() {
		stage2();
		assertNotNull(queue.peek());
		assertFalse(queue.isEmpty());
		assertEquals("alv",queue.peek());
		assertNotEquals("you shall not pass", queue.peek());
		
	}
	
	@Test
	void offerTest() {
		stage1();
		assertNull(queue.poll());
		assertTrue(queue.isEmpty());
		
		queue.offer("It works!");
		queue.offer("It´s alive!!");
		queue.offer("we clearly can see that this works :)");
		queue.offer("100% real no feik :v");
		
		assertEquals(4, queue.size());
		assertEquals("It works!", queue.peek());
		assertNotNull(queue.peek());
		assertFalse(queue.isEmpty());
	}

	@Test
	void pollTest() {
		stage2();
		assertEquals(6, queue.size());
		assertEquals("alv", queue.poll());
		assertNotEquals(6, queue.size());
		assertEquals(5, queue.size());
		queue.poll();
		queue.poll();
		assertEquals(3, queue.size());
	}





}
