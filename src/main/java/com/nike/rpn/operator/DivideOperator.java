package com.nike.rpn.operator;

import java.math.BigDecimal;
import java.util.Stack;

import com.nike.rpn.memento.MementoCaretaker;
import com.nike.rpn.util.CalculatorUtil;

public class DivideOperator implements NumericOperator {

    public BigDecimal calculate(BigDecimal a, BigDecimal b) {
        return b.divide(a, CalculatorUtil.DEFAULT_DIV_SCALE, BigDecimal.ROUND_DOWN);
    }
}
