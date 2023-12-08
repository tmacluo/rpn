package com.nike.rpn.operator.special;

import com.nike.rpn.memento.MementoCaretaker;

import java.util.Stack;

public class ClearOperator implements SpecialOperator {
    @Override
    public void calculate(Stack<String> stack, MementoCaretaker mc) {
        stack.clear();
        mc.clearMemento();
    }
}
