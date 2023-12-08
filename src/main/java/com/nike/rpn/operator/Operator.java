package com.nike.rpn.operator;

import com.nike.rpn.memento.MementoManager;

import java.util.Stack;

public interface Operator {

    void calculate(Stack<String> stack, MementoManager mc);

}
