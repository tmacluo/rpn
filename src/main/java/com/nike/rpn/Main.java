package com.nike.rpn;

import com.nike.rpn.core.RPNCalculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        RPNCalculator rpmCalculator = new RPNCalculator();
        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()){
            String commandLine = input.nextLine();
            rpmCalculator.run(commandLine);
            System.out.println();
        }
    }
}
