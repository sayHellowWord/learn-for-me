package com.yd.jianzhioffer.array;

/**
 * 二维数组中的查找
 */
public class FindInArray {

    public static void main(String[] args) {
        int[][] arrays = new int[5][5];
        //初始化数组
        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 5 ; j++) {
                arrays[i][j] = i + j;
            }
        }
        //打印数组
        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 5 ; j++) {
                System.out.print(arrays[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 判断数组中是否包含该整数
     * @param arr
     * @param findNum
     * @return
     */
    public boolean findInArrar(int[][] arr , int findNum){
        boolean flag = false;


        return flag;
    }
}
