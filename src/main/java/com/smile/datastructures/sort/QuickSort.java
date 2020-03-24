package com.smile.datastructures.sort;

/**
 * @author ：Smile(wangyajun)
 * @date ：Created in 2020/3/24 11:45
 * @description：
 */
public class QuickSort {


    public static void main(String[] args) {

//        int[] array = {3, 9, -1, 10, 20};
        int num = 800000;
        int[] array = new int[num];

        for (int i = 0; i < num; i++) {
            array[i] = (int) (Math.random() * num*1000);
        }

//        System.out.println("排序前的数组为:" + Arrays.toString(array));
        long start = System.currentTimeMillis();
        System.out.println("排序前的时间为:" + start);
        quickSort(array,0,array.length-1);//冒泡排序
//        System.out.println("排序后的数组为:" + Arrays.toString(array));
        long end = System.currentTimeMillis();
        System.out.println("排序后的时间为:" + end);
        System.out.println("共计花费:[" + (end - start)*1.0 / 1000+"]秒");

    }

    public static void quickSort(int[] array, int left, int right) {
        int l = left;
        int r = right;

        int pivot = array[(right + left) / 2];

        while (l < r) {
            while (array[l] < pivot) {
                l += 1;
            }
            while (array[r] > pivot) {
                r -= 1;
            }

            if (l >= r) {
                break;
            }

            int temp = 0;
            temp = array[l];
            array[l] = array[r];
            array[r] = temp;

            if (array[l] == pivot) {
                l+=1;
            }

            if (array[r] == pivot) {
                r-=1;
            }
        }
        if (l==r){
            l+=1;
            r-=1;
        }
        if (left<r){
            quickSort(array,left,r);
        }
        if (right>l){
            quickSort(array,l,right);
        }



    }

}
