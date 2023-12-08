package com.nike.rpn.operator;

import java.math.BigDecimal;

public class AddOperator implements NumericOperator {

    public BigDecimal calculate(BigDecimal a, BigDecimal b) {
        return b.add(a);
    }

}
