package com.smile.datastructures.search;

import java.util.Arrays;

/**
 * @author ：Smile(wangyajun)
 * @date ：Created in 2020/4/13 15:59
 * @description：
 */
public class FibonacciSearch {
    private static int maxSize = 20;

    public static void main(String[] args) {


        int[] array = {1, 8, 10, 89, 1000, 1234};
        int index = fibSearch(array, 1000);
        System.out.println("fib找到的下表为:"+index);


    }


    public static int fibSearch(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;
        int k = 0;
        int mid = 0;

        int f[] = fib();
        while (right > f[k] - 1) {
            k++;
        }
        //不足用0填充
        int[] temp = Arrays.copyOf(array, f[k]);
        //将0改成最后一个数
        for (int i = right + 1; i < temp.length; i++) {
            temp[i] = array[right];
        }
        while (left <= right) {
            mid = left + f[k - 1] - 1;
            if (key < temp[mid]) {
                right = mid - 1;
                k--;
            }else if (key > temp[mid]){
                left = mid +1;
                k -=2;
            }else{
                if (mid <=right){
                    return mid ;
                }else{
                    return right;
                }
            }
        }
        return -1;

    }

    /**
     * 非递归方式得到斐波那契数组
     *
     * @return
     */
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;

    }


}
