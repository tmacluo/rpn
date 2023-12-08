package com.nike.rpn.operator;

import java.math.BigDecimal;

public class MultiplyOperator implements NumericOperator {

    public BigDecimal calculate(BigDecimal a, BigDecimal b) {
        return b.multiply(a);
    }

}
