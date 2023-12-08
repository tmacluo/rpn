package com.nike.rpn.operator;

import com.nike.rpn.exception.UnsupportedOperatorException;
import com.nike.rpn.operator.special.ClearOperator;
import com.nike.rpn.operator.special.SpecialOperator;
import com.nike.rpn.operator.special.SqrtOperator;
import com.nike.rpn.operator.special.UndoOperator;
import org.junit.Assert;
import org.junit.Test;

public class OperatorFactoryTest {

    @Test
    public void testCreateAddOperator() {
        Operator operator = OperatorFactory.getOperator("+");
        Assert.assertTrue(operator instanceof NumericOperator);
        Assert.assertTrue(operator instanceof AddOperator);
    }

    @Test
    public void testCreateSubtractOperator() {
        Operator operator = OperatorFactory.getOperator("-");
        Assert.assertTrue(operator instanceof NumericOperator);
        Assert.assertTrue(operator instanceof SubtractOperator);
    }

    @Test
    public void testCreateMultiplyOperator() {
        Operator operator = OperatorFactory.getOperator("*");
        Assert.assertTrue(operator instanceof NumericOperator);
        Assert.assertTrue(operator instanceof MultiplyOperator);
    }

    @Test
    public void testCreateDivideOperator() {
        Operator operator = OperatorFactory.getOperator("/");
        Assert.assertTrue(operator instanceof NumericOperator);
        Assert.assertTrue(operator instanceof DivideOperator);
    }

    @Test
    public void testCreateClearOperator() {
        Operator operator = OperatorFactory.getOperator("clear");
        Assert.assertTrue(operator instanceof SpecialOperator);
        Assert.assertTrue(operator instanceof ClearOperator);
    }

    @Test
    public void testCreateUndoOperator() {
        Operator operator = OperatorFactory.getOperator("undo");
        Assert.assertTrue(operator instanceof SpecialOperator);
        Assert.assertTrue(operator instanceof UndoOperator);
    }

    @Test
    public void testCreateSqrtOperator() {
        Operator operator = OperatorFactory.getOperator("sqrt");
        Assert.assertTrue(operator instanceof SpecialOperator);
        Assert.assertTrue(operator instanceof SqrtOperator);
    }

    @Test(expected = UnsupportedOperatorException.class)
    public void testCreateUnknownOperator() {
        OperatorFactory.getOperator("unknown");
    }
}
