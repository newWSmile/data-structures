package com.smile.datastructures.sort;

/**
 * @author ：Smile(wangyajun)
 * @date ：Created in 2020/3/19 16:58
 * @description：
 */
public class BubbleSort {

    public static void main(String[] args) {

//        int[] array = {3, 9, -1, 10, 20};
        int num = 80000;
        int[] array = new int[num];

        for (int i = 0; i < num; i++) {
            array[i] = (int) (Math.random() * num);
        }

//        System.out.println("排序前的数组为:" + Arrays.toString(array));
        long start = System.currentTimeMillis();
        System.out.println("排序前的时间为:" + start);
        bubbSort(array);//冒泡排序
//        System.out.println("排序后的数组为:" + Arrays.toString(array));
        long end = System.currentTimeMillis();
        System.out.println("排序后的时间为:" + end);
        System.out.println("共计花费:[" + (end - start) / 1000+"]秒");
    }

    private static void bubbSort(int[] array) {
        int temp = 0;

        boolean flag = false;
        for (int j = 1; j < array.length; j++) {
            for (int i = 0; i < array.length - j; i++) {
                if (array[i] > array[i + 1]) {
                    flag = true;
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }

            }
//            System.out.println("第" + j + "趟排序结果为:" + Arrays.toString(array));
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }

}
