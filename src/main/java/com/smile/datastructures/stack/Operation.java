package com.smile.datastructures.stack;

/**
 * @author ：Smile(wangyajun)
 * @date ：Created in 2020/3/16 16:58
 * @description：
 */
public class Operation {

    private static int ADD = 1;

    private static int SUB = 1;

    private static int MUL = 2;

    private static int DIV = 2;

    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "x":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }


}
