package com.smile.datastructures.sort;

import java.util.Arrays;

/**
 * @author ：Smile(wangyajun)
 * @date ：Created in 2020/3/30 15:28
 * @description：
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] array = {53, 3, 542, 748, 14, 214};

        radixSort(array);

        System.out.println("基数排序结果为:" + Arrays.toString(array));


//        int num = 8000000;
//        int[] array = new int[num];
//
//        for (int i = 0; i < num; i++) {
//            array[i] = (int) (Math.random() * num * 1000);
//        }
//
////        System.out.println("排序前的数组为:" + Arrays.toString(array));
//        long start = System.currentTimeMillis();
//        System.out.println("排序前的时间为:" + start);
//        radixSort(array);//
////        System.out.println("排序后的数组为:" + Arrays.toString(array));
//        long end = System.currentTimeMillis();
//        System.out.println("排序后的时间为:" + end);
//        System.out.println("共计花费:[" + (end - start) * 1.0 / 1000 + "]秒");
    }

    public static void radixSort(int[] array) {
        int[][] bucket = new int[10][array.length];

        int[] bucketElementCounts = new int[10];

        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        int maxLegth = ("" + max).length();

        for (int i = 0, n = 1; i < maxLegth; i++, n *= 10) {

            for (int j = 0; j < array.length; j++) {
                int digitOfElement = array[j] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = array[j];
                bucketElementCounts[digitOfElement]++;
            }

            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if (bucketElementCounts[k] > 0) {
                    for (int j = 0; j < bucketElementCounts[k]; j++) {
                        array[index++] = bucket[k][j];

                    }
                }
                bucketElementCounts[k] = 0;
            }
        }
    }

}
