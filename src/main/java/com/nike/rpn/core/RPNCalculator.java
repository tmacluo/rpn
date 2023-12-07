package com.nike.rpn.core;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;
import java.util.StringTokenizer;

import com.nike.rpn.memento.MementoCaretaker;
import com.nike.rpn.operator.Operator;
import com.nike.rpn.operator.OperatorFactory;
import com.nike.rpn.util.CalculatorUtil;
import com.nike.rpn.exception.InsufficientParameterException;

/**
 * Class that can be used to a console application from a Java main
 * method. it waits for user input and expects to receive strings containing
 * whitespace separated lists of numbers and operators.
 * The calculator store real numbers into stack and display it in the console .
 */
public class RPNCalculator {

    /**
     * stack contains the real numbers
     */
    private Stack<String> stack = new Stack<>();
    /**
     * manage all historic status of numsStack to perform undo actions
     */
    private MementoCaretaker mc = new MementoCaretaker();

    public void run(String commandLine) {
        int index = 0;
        StringTokenizer tokenizer = new StringTokenizer(commandLine);
        while (tokenizer.hasMoreTokens()) {
            index++;
            String input = tokenizer.nextToken();
            if (CalculatorUtil.isDecimal(input)) {
                stack.push(CalculatorUtil.toPlainString(input));
                mc.createMemento(stack);
            } else if (CalculatorUtil.isOperator(input)) {
                try {
                    operate(input, index);
                } catch (InsufficientParameterException e) {
                    break;
                } catch (ArithmeticException e) {
                    System.out.println("can not divide by zero");
                    break;
                }
            } else {
                System.out.println("Ilegal input parameter:" + input);
                break;
            }
        }
        System.out.print("Stack: ");
        stack.forEach(result -> System.out.print(new BigDecimal(result).setScale(10,
                RoundingMode.DOWN).stripTrailingZeros().toPlainString() + " "));
    }

    public Stack<String> getStack() {
        return stack;
    }

    private void operate(String input, int index) {
        switch (input) {
            case "clear": {
                stack.clear();
                mc.clearMemento();
                break;
            }
            case "undo": {
                stack = mc.getMemento().getStack();
                break;
            }
            case "sqrt": {
                stack.push(CalculatorUtil.sqrt(stack.pop()));
                mc.createMemento(stack);
                break;
            }
            default: {
                // at least two numbers required to perform operations(+-*/).
                if (stack.size() < 2) {
                    System.out.printf("Operator %s (position: %s): insucient parameters%n", input, index * 2 - 1);
                    throw new InsufficientParameterException("insucient parameters");
                }
                Operator operator = OperatorFactory.getOperator(input);
                BigDecimal result = operator.calc(new BigDecimal(stack.pop()), new BigDecimal(stack.pop()));
                stack.push(result.stripTrailingZeros().toPlainString());
                mc.createMemento(stack);
            }
        }
    }


}
