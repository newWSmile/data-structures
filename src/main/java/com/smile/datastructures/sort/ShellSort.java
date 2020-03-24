package com.smile.datastructures.sort;

import java.util.Arrays;

/**
 * @author ：Smile(wangyajun)
 * @date ：Created in 2020/3/23 10:33
 * @description：
 */
public class ShellSort {

    public static void main(String[] args) {

        int[] array = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        shellSort(array);
        shellSort2(array);
        System.out.println(Arrays.toString(array));

//        int num = 80000;
//        int[] array = new int[num];
//
//        for (int i = 0; i < num; i++) {
//            array[i] = (int) (Math.random() * num*1000);
//        }
//
////        System.out.println("排序前的数组为:" + Arrays.toString(array));
//        long start = System.currentTimeMillis();
//        System.out.println("排序前的时间为:" + start);
//        shellSort2(array);//冒泡排序
////        System.out.println("排序后的数组为:" + Arrays.toString(array));
//        long end = System.currentTimeMillis();
//        System.out.println("排序后的时间为:" + end);
//        System.out.println("共计花费:[" + (end - start)*1.0 / 1000+"]秒");


    }


    public static void shellSort(int[] array) {
        int temp = 0;

        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (array[j] > array[j + gap]) {
                        temp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = temp;
                    }
                }
            }
        }
    }

    public static void shellSort2(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < array.length; i++) {
                int j = i;
                int temp = array[j];

//                if (array[j] < array[j - gap]) {
                    while (j - gap >= 0 && temp < array[j - gap]) {
                        array[j] = array[j-gap];
                        j -= gap;
                    }

                    array[j] = temp;
//                }
            }
        }

    }

}
