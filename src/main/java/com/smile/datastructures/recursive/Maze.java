package com.smile.datastructures.recursive;

/**
 * @author ：Smile(wangyajun)
 * @date ：Created in 2020/3/17 14:42
 * @description：
 */
public class Maze {

    public static void main(String[] args) {

        int[][] map = new int[8][7];

        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;

        printMap(map);

        setWay(map,1,1);


        printMap(map);


    }


    /**
     * @param map 地图
     * @param i   位置行
     * @param j   位置列
     * @return 是否找到通路
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        }

        if (map[i][j] == 0) {
            map[i][j] = 2;
            if (setWay(map, i + 1, j)) {
                return true;
            } else if (setWay(map, i, j + 1)) {
                return true;
            } else if (setWay(map, i - 1, j)) {
                return true;
            } else if (setWay(map, i, j - 1)) {
                return true;
            } else {
                map[i][j] = 3;
                return false;
            }
        } else {
            return false;
        }
    }


    public static void printMap(int[][] map) {
        System.out.println("=================地图现在情况为:=================");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("================================================");
    }

}
