package com.nike.rpn.core;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;
import java.util.StringTokenizer;

import com.nike.rpn.memento.MementoCaretaker;
import com.nike.rpn.operator.NumericOperator;
import com.nike.rpn.operator.Operator;
import com.nike.rpn.operator.OperatorFactory;
import com.nike.rpn.operator.special.UndoOperator;
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
    private final MementoCaretaker mc = new MementoCaretaker();

    public void run(String commandLine) {
        int index = 0;
        StringTokenizer tokenizer = new StringTokenizer(commandLine);
        while (tokenizer.hasMoreTokens()) {
            index++;
            String token = tokenizer.nextToken();
            if (CalculatorUtil.isDecimal(token)) {
                // stack token for further calculation
                stack(token);
            } else if (CalculatorUtil.isOperator(token)) {
                try {
                    operate(token, index);
                } catch (InsufficientParameterException e) {
                    System.out.println("Insufficient parameter");
                    break;
                } catch (ArithmeticException e) {
                    System.out.println("Can not divide by zero");
                    break;
                }
            } else {
                System.out.println("Illegal token parameter:" + token);
                break;
            }
        }
        System.out.print("Stack: ");
        stack.forEach(result -> System.out.print(new BigDecimal(result).setScale(10,
                RoundingMode.DOWN).stripTrailingZeros().toPlainString() + " "));
    }

    private void stack(String input) {
        stack.push(CalculatorUtil.toPlainString(input));
        mc.createMemento(stack);
    }

    private void operate(String input, int index) {
        Operator operator = OperatorFactory.getOperator(input);
        if (operator instanceof NumericOperator) {
            rangeCheck(input, index);
        }
        if (operator instanceof UndoOperator) {
            stack = mc.getMemento().getStack();
        }
        operator.calculate(stack, mc);
    }

    private void rangeCheck(String input, int index) {
        if (stack.size() < 2) {
            System.out.printf("Operator %s (position: %s): insufficient parameters%n", input, index * 2 - 1);
            throw new InsufficientParameterException("insufficient parameters");
        }
    }

    public Stack<String> getStack() {
        return stack;
    }
}
