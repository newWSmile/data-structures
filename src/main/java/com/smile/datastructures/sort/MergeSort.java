package com.smile.datastructures.sort;

/**
 * @author ：Smile(wangyajun)
 * @date ：Created in 2020/3/30 13:57
 * @description：
 */
public class MergeSort {

    public static void main(String[] args) {

//        int array[] = {8, 4, 5, 7, 1, 3, 6, 2};
//        int temp[] = new int[array.length];
//        mergeSort(array, 0, array.length - 1, temp);
//        System.out.println("归并排序分之后的结果为:"+ Arrays.toString(array));

        //性能测试
        int num = 80000;
        int[] array = new int[num];
        int temp[] = new int[array.length];
        for (int i = 0; i < num; i++) {
            array[i] = (int) (Math.random() * num * 1000);
        }

        long start = System.currentTimeMillis();
//        System.out.println("排序前的数组为:" + Arrays.toString(array));
        System.out.println("排序前的时间为:" + start);
        mergeSort(array, 0, array.length - 1, temp);//冒泡排序
        long end = System.currentTimeMillis();
//        System.out.println("排序后的数组为:" + Arrays.toString(array));
        System.out.println("排序后的时间为:" + end);
        System.out.println("共计花费:[" + (end - start) * 1.0 / 1000 + "]秒");


    }

    public static void mergeSort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid, temp);
            mergeSort(array, mid + 1, right, temp);
            merge(array, left, mid, right, temp);

        }

    }


    /**
     * @param array 原始数组
     * @param left  左边有序数列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  中转数组
     */
    public static void merge(int[] array, int left, int mid, int right, int[] temp) {
        int i = left;//初始化i,左边有序数列的初始索引
        int j = mid + 1;//初始化j，右边有序数列的初始索引
        int t = 0;//temp数组的当前索引

        //1 先把左右两边（有序）数据 填充到temp中 直到左右两边的数组有一方结束

        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[t] = array[i];
                t += 1;
                i += 1;
            } else {
                temp[t] = array[j];
                t += 1;
                j += 1;
            }
        }

        //2 将剩余的数组一方 依次填充temp
        while (i <= mid) {
            temp[t] = array[i];
            t += 1;
            i += 1;
        }

        while (j <= right) {
            temp[t] = array[j];
            t += 1;
            j += 1;
        }

        //3 将temp 重新拷贝到array
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            array[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }

    }

}
