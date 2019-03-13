package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import stack.IStack;
import stack.Stack;

class StackTest {

	IStack<Integer> stack;
	
	void stage1(){
		stack=new Stack<>();
	}
	
	void stage2() {
		stage1();
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
	}
	
	
	@Test
	void popTest() {
		stage2();
		
	}

}
