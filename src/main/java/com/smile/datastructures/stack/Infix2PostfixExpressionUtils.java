package com.smile.datastructures.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ：Smile(wangyajun)
 * @date ：Created in 2020/3/16 11:34
 * @description：
 */
public class Infix2PostfixExpressionUtils {

    public static void main(String[] args) {
        String expression = "1+((2+3)x4)-5";
        List<String> postfixExpressionList = transformPostfixExpressionList(expression);
        System.out.println(postfixExpressionList);
    }

    public static List<String> transformPostfixExpressionList(String infixExpression) {
        List<String> inInfixList = toInInfixListByString(infixExpression);

        Stack<String> s1 = new Stack<>();
        List<String> s2 = new ArrayList<>();

        for (String item : inInfixList) {
            //如果是数  入s2
            if (item.matches("\\d+")){
                s2.add(item);
            }else if (item.equalsIgnoreCase("(")){
                s1.add(item);
            }else if (item.equalsIgnoreCase(")")){
                while (!s1.peek().equalsIgnoreCase("(")){
                    s2.add(s1.pop());
                }
                s1.pop();
            }else{
                while (s1.size()!=0&& Operation.getValue(s1.peek())>=Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }

        while (s1.size()!=0){
            s2.add(s1.pop());
        }

        return s2;
    }




    private static List<String> toInInfixListByString(String infixExpression) {

        List<String> result = new ArrayList<>();

        int i = 0;

        String str;

        char c;

        do {
            if ((c = infixExpression.charAt(i)) < 48 || (c = infixExpression.charAt(i)) > 57) {
                result.add("" + c);
                i++;
            } else {
                str = "";
                while (i < infixExpression.length() && ((c = infixExpression.charAt(i)) >= 48 && (c = infixExpression.charAt(i)) <= 57)) {
                    str += c;
                    i++;
                }
                result.add(str);
            }

        } while (i < infixExpression.length());

        return result;

    }

}


