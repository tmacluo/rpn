package com.nike.rpn.operator;

import com.nike.rpn.exception.UnsupportedOperatorException;
import com.nike.rpn.operator.special.ClearOperator;
import com.nike.rpn.operator.special.SqrtOperator;
import com.nike.rpn.operator.special.UndoOperator;

public class OperatorFactory {
    public static Operator getOperator(String operator) {
        switch (operator.toLowerCase()) {
            case "+":
                return new AddOperator();
            case "-":
                return new SubtractOperator();
            case "*":
                return new MultiplyOperator();
            case "/":
                return new DivideOperator();
            case "clear":
                return new ClearOperator();
            case "undo":
                return new UndoOperator();
            case "sqrt":
                return new SqrtOperator();
            default:
                throw new UnsupportedOperatorException();
        }
    }
}
