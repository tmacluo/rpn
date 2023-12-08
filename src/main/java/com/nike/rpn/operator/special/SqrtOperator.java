package com.nike.rpn.operator.special;


import com.nike.rpn.memento.MementoCaretaker;
import com.nike.rpn.util.CalculatorUtil;

import java.util.Stack;

public class SqrtOperator implements SpecialOperator {
    @Override
    public void calculate(Stack<String> stack, MementoCaretaker mc) {
        stack.push(CalculatorUtil.sqrt(stack.pop()));
        mc.createMemento(stack);
    }
}
