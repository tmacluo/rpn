package com.nike.rpn.operator;

import java.math.BigDecimal;

public class SubtractOperator implements NumericOperator {

    public BigDecimal calculate(BigDecimal a, BigDecimal b) {
        return b.subtract(a);
    }
}
