package com.smile.datastructures.sort;

/**
 * @author ：Smile(wangyajun)
 * @date ：Created in 2020/3/19 20:28
 * @description：
 */
public class InsertSort {

    public static void main(String[] args) {
//        int[] array = {101, 30, 59, 5};
//        insertSort(array);
//        System.out.println("排序后的数组为:" + Arrays.toString(array));


        int num = 80000;
        int[] array = new int[num];

        for (int i = 0; i < num; i++) {
            array[i] = (int) (Math.random() * num*1000);
        }

        long start = System.currentTimeMillis();
//        System.out.println("排序前的数组为:" + Arrays.toString(array));
        System.out.println("排序前的时间为:" + start);
        insertSort(array);//冒泡排序
        long end = System.currentTimeMillis();
//        System.out.println("排序后的数组为:" + Arrays.toString(array));
        System.out.println("排序后的时间为:" + end);
        System.out.println("共计花费:[" + (end - start)*1.0 / 1000 + "]秒");

    }


    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int insertVal = array[i];
            int insertIndex = i - 1;

            while (insertIndex >= 0 && insertVal < array[insertIndex]) {
                array[insertIndex + 1] = array[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                array[insertIndex + 1] = insertVal;
            }


//            System.out.println("第" + i + "趟排序结果为:" + Arrays.toString(array));
        }
    }

}
