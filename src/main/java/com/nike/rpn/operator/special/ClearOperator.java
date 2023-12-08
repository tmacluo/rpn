package com.nike.rpn.operator.special;

import com.nike.rpn.memento.MementoManager;

import java.util.Stack;

public class ClearOperator implements SpecialOperator {
    @Override
    public void calculate(Stack<String> stack, MementoManager mc) {
        stack.clear();
        mc.clear();
    }
}
