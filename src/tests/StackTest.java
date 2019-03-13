package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import stack.Stack;

class StackTest {

	Stack<String> stack;
	
	void stage1(){
		stack=new Stack<>();
	}
	
	void stage2() {
		stage1();
		stack.push("Esternocleidomastoideo");
		stack.push("bone");
		stack.push("meme");
		stack.push("pc");
		stack.push("table");
	}
	
	
	@Test
	void popTest() {
		stage2();
		assertEquals("table", stack.pop());
		assertNotEquals("This is not it", stack.pop());
		String tested=stack.pop()+" "+stack.pop();
		assertEquals("meme bone", tested);
		assertNotNull(stack.pop());
		assertTrue(stack.isEmpty());
	}

	@Test
	void reverseTest() {
		stage2();
		stack=stack.reverse(stack);
		assertNotEquals("table", stack.pop());
		assertEquals("bone", stack.pop());
		String tested=stack.pop()+" "+stack.pop();
		assertEquals("meme pc", tested);
		assertNotNull(stack.pop());
		assertTrue(stack.isEmpty());
	}
	
	@Test
	void pushTest() {
		stage2();
		String element="new Element";
		stack.push(element);
		assertEquals(element, stack.peek());
		assertFalse(stack.isEmpty());
	}
	
}
