package com.nike.rpn.operator;

import java.math.BigDecimal;

import com.nike.rpn.util.CalculatorUtil;

public class DivideOperator implements Operator{

	public BigDecimal calc(BigDecimal a, BigDecimal b) {
		return b.divide(a, CalculatorUtil.DEFAULT_DIV_SCALE, BigDecimal.ROUND_DOWN);
	}
}
