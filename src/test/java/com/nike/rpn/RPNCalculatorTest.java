package com.nike.rpn;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

import com.nike.rpn.core.RPNCalculator;
import com.nike.rpn.util.CalculatorUtil;

public class RPNCalculatorTest {

	RPNCalculator rpnCalc = new RPNCalculator();
	
	@Test
	public void testInvalidString(){
		String inputStr = "1 &";
		Stack<String> stack = new Stack<String>();
		stack.push("1");
		rpnCalc.run(inputStr);
		assertEquals(stack, rpnCalc.getStack());
	}
	
	@Test
	public void testInvalidNumber(){
		String inputStr = "1.0123456789012345";
		Stack<String> stack = new Stack<String>();
		rpnCalc.run(inputStr);
		assertEquals(stack, rpnCalc.getStack());
	}
	
	@Test
	public void testNormalNumbers(){
		String inputStr = "5 2";
		Stack<String> stack = new Stack<String>();
		stack.push("5");
		stack.push("2");
		rpnCalc.run(inputStr);
		assertEquals(stack, rpnCalc.getStack());
	}
	
	@Test
	public void testSqrt(){
		String inputStr = "2 sqrt";
		Stack<String> stack = new Stack<String>();
		stack.push(CalculatorUtil.sqrt("2"));
		rpnCalc.run(inputStr);
		assertEquals(stack, rpnCalc.getStack());
	}
	
	@Test
	public void testSqrtAndClear(){
		String inputStr = "2 sqrt clear 9 sqrt";
		Stack<String> stack = new Stack<String>();
		stack.push("3");
		rpnCalc.run(inputStr);
		assertEquals(stack, rpnCalc.getStack());
	}
	
	@Test
	public void testUndoAndMutiply(){
		String inputStr = "5 4 3 2 undo undo * 5 * undo";
		Stack<String> stack = new Stack<String>();
		stack.push("20");
		stack.push("5");
		rpnCalc.run(inputStr);
		assertEquals(stack, rpnCalc.getStack());
	}
	
	@Test
	public void testDivide(){
		String inputStr = "7 12 2 / * 4 /";
		Stack<String> stack = new Stack<String>();
		stack.push("10.5");
		rpnCalc.run(inputStr);
		assertEquals(stack, rpnCalc.getStack());
	}
	
	@Test
	public void testInsufficientParameter(){
		String inputStr = "1 2 3 * 5 + * * 6 5";
		Stack<String> stack = new Stack<String>();
		stack.push("11");
		rpnCalc.run(inputStr);
		assertEquals(stack, rpnCalc.getStack());
	}
	
}
