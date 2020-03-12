package com.smile.datastructures.sparseArray;

/**
 * @author ：Smile(wangyajun)
 * @date ：Created in 2020/3/4 18:29
 * @description：
 */
public class SparseArray {

    private static final int V = 0;

    public static void main(String[] args) {

        int chessArray[][] = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        System.out.println("原始数组:");
        printArray(chessArray);
        System.out.println("===============");
        int[][] sparseArray = array2sparseArray(chessArray);
        System.out.println("稀疏数组:");
        printArray(sparseArray);
        System.out.println("=========");

        int[][] array = sparse2array(sparseArray);
        System.out.println("还原后的数组为:");
        printArray(array);
        System.out.println("============");

    }

    private static void printArray(int[][] array) {
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println("\r\n");
        }
    }


    private static int[][] sparse2array(int[][] sparseArray) {

        int c = sparseArray[0][0];
        int l = sparseArray[0][1];
        int sum = sparseArray[0][2];

        int[][] array = new int[c][l];

        for (int i = 1; i <= sum; i++) {
            int col = sparseArray[i][0];
            int line = sparseArray[i][1];
            int value = sparseArray[i][2];
            array[col][line] = value;
        }

        return array;

    }


    private static int[][] array2sparseArray(int[][] array) {

        int sum = 0;
        int c = array.length;
        int l = 0;

        for (int i = 0; i < array.length; i++) {
            l = array[i].length;
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != V) {
                    sum++;
                }
            }
        }

        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = c;
        sparseArray[0][1] = l;
        sparseArray[0][2] = sum;

        int count = 1;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != V) {
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = array[i][j];
                    count++;
                }
            }
        }

        return sparseArray;

    }

}
