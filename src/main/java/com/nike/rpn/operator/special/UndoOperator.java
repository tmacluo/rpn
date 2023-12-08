package com.nike.rpn.operator.special;

import com.nike.rpn.memento.MementoCaretaker;

import java.util.Stack;

public class UndoOperator implements SpecialOperator {
    @Override
    public void calculate(Stack<String> stack, MementoCaretaker mc) {
        // already handle in the RPNCalculator
    }
}
