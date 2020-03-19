package com.smile.datastructures.sort;

/**
 * @author ：Smile(wangyajun)
 * @date ：Created in 2020/3/19 17:58
 * @description：
 */
public class SelectSort {

    public static void main(String[] args) {
        int num = 80000;
        int[] array = new int[num];

        for (int i = 0; i < num; i++) {
            array[i] = (int) (Math.random() * num);
        }

//        System.out.println("排序前的数组为:" + Arrays.toString(array));
        long start = System.currentTimeMillis();
        System.out.println("排序前的时间为:" + start);
        sort(array);//冒泡排序
//        System.out.println("排序后的数组为:" + Arrays.toString(array));
        long end = System.currentTimeMillis();
        System.out.println("排序后的时间为:" + end);
        System.out.println("共计花费:[" + (end - start) / 1000+"]秒");

    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            int min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                array[minIndex] = array[i];
                array[i] = min;
            }
        }
    }

}
