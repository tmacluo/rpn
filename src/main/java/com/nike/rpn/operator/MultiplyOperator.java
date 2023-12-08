package com.nike.rpn.operator;

import com.nike.rpn.memento.MementoCaretaker;

import java.math.BigDecimal;
import java.util.Stack;

public class MultiplyOperator implements NumericOperator {

    public BigDecimal calculate(BigDecimal a, BigDecimal b) {
        return b.multiply(a);
    }

}
