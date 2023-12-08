package com.nike.rpn.operator;

import com.nike.rpn.memento.MementoCaretaker;

import java.math.BigDecimal;
import java.util.Stack;

public class AddOperator implements NumericOperator {

    public BigDecimal calculate(BigDecimal a, BigDecimal b) {
        return b.add(a);
    }

}
