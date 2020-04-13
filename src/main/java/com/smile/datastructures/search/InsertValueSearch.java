package com.smile.datastructures.search;

/**
 * @author ：Smile(wangyajun)
 * @date ：Created in 2020/4/13 13:54
 * @description：
 */
public class InsertValueSearch {

    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = i+1;
        }
        int index = insertValueSearch(array,0,array.length-1,78);
        System.out.println("找到的索引下标是:"+index);



    }

    public static int insertValueSearch(int[] array, int left, int right , int findValue){
        System.out.println("调用头插查找法");
        if (left>right ||findValue < array[0] || findValue> array[array.length-1]){
            return -1;
        }

        int mid = left+(right-left) * (findValue - array[left])/(array[right]-array[left]);

        int midValue = array[mid];

        if (findValue>midValue){
            return insertValueSearch(array,mid+1,right,findValue);
        }else if (findValue<midValue){
            return insertValueSearch(array,left,mid-1,findValue);
        }else{
            return mid ;
        }


    }

}
