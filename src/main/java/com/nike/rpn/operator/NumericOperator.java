package com.nike.rpn.operator;

import com.nike.rpn.memento.MementoCaretaker;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Simple interface to specify calculation methods allowed by the calculator
 */
public interface NumericOperator extends Operator {
    BigDecimal calculate(BigDecimal a, BigDecimal b);

    default void calculate(Stack<String> stack, MementoCaretaker mc){
        BigDecimal result = calculate(new BigDecimal(stack.pop()), new BigDecimal(stack.pop()));
        stack.push(result.stripTrailingZeros().toPlainString());
        mc.createMemento(stack);
    }
}
