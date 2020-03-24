package com.smile.datastructures.sort;

/**
 * @author ：Smile(wangyajun)
 * @date ：Created in 2020/3/24 14:00
 * @description：
 */
public class QuickSort2 {

    //输出函数
    private static void print(int[] a) {
        for (int num : a) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    //交换数组位置函数
    private static void swap(int[] a, int j, int i) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //quickSort
    private static void quickSort(int[] a, int l, int r) {
        if (l < r) {
            //把数组划分成两个子数组和一个元素
            int q = partition(a, l, r);
            quickSort(a, l, q - 1);
            quickSort(a, q + 1, r);

        }
    }

        private static int partition(int[] a, int l, int r) {
        //快排的优化----随机选取数列中的一个元素当作枢轴---交换到第1个元素的位置
        int rand = (int) (Math.random() * (r - l));
        swap(a, l, l + rand);
        int x = a[l];//第1个元素为枢轴
        int i = l;//在左侧搜索的游标:找大
        int j = r + 1;//在右侧搜索的游标:找小
        while (true) {
            while (a[++i] < x && i < r) ;//在左侧定位到比枢轴大的数
            while (a[--j] > x) ;//在右侧定位到比枢轴小的数
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        //把枢轴换到小值区的最后一个元素的位置
        swap(a, l, j);
        return j;
    }


    public static void main(String[] args) {
        int[] a = {21, 22, 5, 7, 86, 57, 9, -2, 37, -8};
        //快速排序
		quickSort(a,0,a.length-1);
        print(a);
    }
}

