package com.smile.datastructures.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Smile(wangyajun)
 * @date ：Created in 2020/3/31 15:03
 * @description：
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] array = {1, 5, 78, 99,235,235, 535, 747};
        int index = binarySearch(array, 0, array.length - 1, 235);
        List<Integer> indexList = binarySearch2(array, 0, array.length - 1, 235);

        System.out.println("结果下标为:" + index);
        System.out.println("结果下标为:" + indexList);


    }

    /**
     * @param array     数组
     * @param left      左边索引
     * @param right     右边索引
     * @param findValue 要查找的值
     * @return 返回下标
     */
    public static int binarySearch(int[] array, int left, int right, int findValue) {

        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        int midVal = array[mid];

        if (midVal < findValue) {
            return binarySearch(array, mid + 1, right, findValue);
        } else if (midVal > findValue) {
            return binarySearch(array, left, mid - 1, findValue);
        } else {
            return mid;
        }


    }


    public static List<Integer> binarySearch2(int[] array, int left, int right, int findValue) {

        ArrayList<Integer> list = new ArrayList<>();

        if (left > right) {
            return new ArrayList<>();
        }

        int mid = (left + right) / 2;
        int midVal = array[mid];

        if (midVal < findValue) {
            return binarySearch2(array, mid + 1, right, findValue);
        } else if (midVal > findValue) {
            return binarySearch2(array, left, mid - 1, findValue);
        } else {
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || array[temp] != findValue) {
                    break;
                }
                list.add(temp);
                temp -= 1;
            }
            list.add(mid);
            temp = mid + 1;
            while (true) {
                if (temp > array.length - 1 || array[temp] != findValue) {
                    break;
                }
                list.add(temp);
                temp += 1;
            }


            return list;
        }


    }

}
