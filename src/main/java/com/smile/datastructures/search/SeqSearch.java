package com.smile.datastructures.search;

/**
 * @author ：Smile(wangyajun)
 * @date ：Created in 2020/3/31 14:43
 * @description：
 */
public class SeqSearch {
    public static void main(String[] args) {
        int array[] = {1, 314, 34, -1, 5354, 66};
        int index = seqSearch(array, -1);
        if (index==-1){
            System.out.println("没有找到对应的值的下标");
        }
        System.out.println("找到对应的值的下标:"+index);
    }

    public static int seqSearch(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
