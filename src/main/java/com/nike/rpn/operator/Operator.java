package com.nike.rpn.operator;

import com.nike.rpn.memento.MementoCaretaker;

import java.util.Stack;

public interface Operator {

    void calculate(Stack<String> stack, MementoCaretaker mc);

}
