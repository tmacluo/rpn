package com.nike.rpn.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorUtil {
    /**
     * limit the decimal place to 15
     */
    public static final int DEFAULT_DIV_SCALE = 15;
    /**
     * allowed list of operators
     */
    private static final Set<String> supportedOperators = new HashSet<>(Arrays.asList("+", "-", "*", "/", "clear", "undo", "sqrt"));

    public static boolean isDecimal(String num) {
        Pattern pattern = Pattern.compile("^(([1-9]\\d*)|(0))(\\.(\\d){0,15})?");
        Matcher match = pattern.matcher(num);
        return match.matches();
    }

    public static boolean isOperator(String c) {
        return supportedOperators.contains(c);
    }

    public static String toPlainString(String input) {
        return new BigDecimal(input).setScale(CalculatorUtil.DEFAULT_DIV_SCALE,
                RoundingMode.DOWN).stripTrailingZeros().toPlainString();
    }

    public static String doubleToPlainString(double input) {
        return new BigDecimal(input).setScale(CalculatorUtil.DEFAULT_DIV_SCALE,
                RoundingMode.DOWN).stripTrailingZeros().toPlainString();
    }

    public static String sqrt(String input) {
        return CalculatorUtil.doubleToPlainString(Math.sqrt(new BigDecimal(input).doubleValue()));
    }


}
