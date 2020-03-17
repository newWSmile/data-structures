package com.smile.datastructures.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author ：Smile(wangyajun)
 * @date ：Created in 2020/3/14 10:39
 * @description：
 */
public class PolandNotation {
    public static void main(String[] args) {
        String suffixExpression = "1+((2+3)x4)-5";

        List<String> postfixExpressionList = Infix2PostfixExpressionUtils.transformPostfixExpressionList(suffixExpression);
//        String suffixExpression = "3 4 + 5 x 6 -";
//        List<String> rpcList = getListByString(suffixExpression);

        System.out.printf("表达式[%s],结果为:[%d]\r\n", suffixExpression, calculate(postfixExpressionList));
    }

    public static int calculate(List<String> list) {
        Stack<String> stack = new Stack<>();
        for (String item : list) {
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equalsIgnoreCase("+")) {
                    res = num1 + num2;
                } else if (item.equalsIgnoreCase("-")) {
                    res = num2 - num1;
                } else if (item.equalsIgnoreCase("x")) {
                    res = num2 * num1;
                } else if (item.equalsIgnoreCase("/")) {
                    res = num2 / num1;
                } else {
                    throw new RuntimeException("不支持该运算符");
                }
                stack.push(String.valueOf(res));

            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static List<String> getListByString(String suffixExpression) {
        String[] s = suffixExpression.split(" ");
        return new ArrayList<>(Arrays.asList(s));
    }
}
