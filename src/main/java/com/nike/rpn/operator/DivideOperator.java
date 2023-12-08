package com.nike.rpn.operator;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.nike.rpn.util.CalculatorUtil;

public class DivideOperator implements NumericOperator {

    public BigDecimal calculate(BigDecimal a, BigDecimal b) {
        if (b.equals(BigDecimal.ZERO)) {
            throw new IllegalArgumentException();
        }
        return b.divide(a, CalculatorUtil.DEFAULT_DIV_SCALE, RoundingMode.DOWN);
    }
}
