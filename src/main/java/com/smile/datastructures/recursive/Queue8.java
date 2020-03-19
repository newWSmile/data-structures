package com.smile.datastructures.recursive;

/**
 * @author ：Smile(wangyajun)
 * @date ：Created in 2020/3/18 15:44
 * @description：
 */
public class Queue8 {

    int max = 8;
    int array[] = new int[max];

    static int count = 0;

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);

        System.out.println(count);
    }

    private void check(int n){
        if (n == max){
            printArray();
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (judge(n)){
                check(n+1);
            }

        }
    }


    /**
     *
     * @param n 第n个皇后
     * @return
     */
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }



    public void printArray(){
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

}
