package com.nike.rpn.operator.special;


import com.nike.rpn.memento.MementoManager;
import com.nike.rpn.util.CalculatorUtil;

import java.util.Stack;

public class SqrtOperator implements SpecialOperator {
    @Override
    public void calculate(Stack<String> stack, MementoManager mc) {
        stack.push(CalculatorUtil.sqrt(stack.pop()));
        mc.create(stack);
    }
}
