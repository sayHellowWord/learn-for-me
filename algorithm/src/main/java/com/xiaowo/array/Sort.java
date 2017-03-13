package com.xiaowo.array;

import java.util.Random;

/**
 * 数据排序相关
 */
public class Sort {

    /**
     * 冒泡排序(从小到大) 可以优化>>>每次冒泡后有数组部分已经是有序的了，无须再重复排序
     * 优化后排序9999个数字 速度相差几乎一倍
     */
    public static void bubbleSort(Integer[] arr) {
        long time = System.currentTimeMillis();
        int length = arr.length;
      /*  for (int i = 0; i < length; i++) {
            /*//*****注意内圈的其实位置
         for (int j = 0; j < length; j++) {
         if (j + 1 < length && arr[j] > arr[j + 1]) {
         Integer tmp = arr[j];
         arr[j] = arr[j + 1];
         arr[j + 1] = tmp;
         }
         }
         }
         time = System.currentTimeMillis() - time;
         System.out.println("优化前" + time);
         time = System.currentTimeMillis();*/
        //优化后
        for (int i = length - 1; i > 1; i--) {
            for (int j = 0; j < length; j++) {
                if (j + 1 < length && arr[j] > arr[j + 1]) {
                    Integer tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        time = System.currentTimeMillis() - time;
        System.out.println("冒泡排序时间:" + time + "结果：" + printArr(arr));

    }

    /**
     * 选择排序(从小到大) 可以优化
     */
    public static void selectSort(Integer[] arr) {
        long time = System.currentTimeMillis();
        int length = arr.length;
        int index;
        for (int i = 0; i < length; i++) {
            Integer min = arr[i];
            index = i;
            //**********注意内圈的起始位置
            for (int j = i; j < length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            if (index != i) {
                Integer tmp = arr[i];
                arr[i] = min;
                arr[index] = tmp;
            }
        }
        time = System.currentTimeMillis() - time;
        System.out.println("选择排序时间:" + time + "结果：" + printArr(arr));
    }

    /**
     * 打印数组
     * 打印99999个数字 stringBuilder比stringBuffer快4~5秒，当然也存在相反的情况，但是极少
     * 1.如果要操作少量的数据用 = String
     * 2.单线程操作字符串缓冲区 下操作大量数据 = StringBuilder
     * 3.多线程操作字符串缓冲区 下操作大量数据 = StringBuffer
     *
     * @param arr
     * @return
     */
    public static String printArr(Integer[] arr) {
        long time = System.currentTimeMillis();
        int length = arr.length;
       /* StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++)
            stringBuffer.append(arr[i] + " ");
        time = System.currentTimeMillis() - time;
        System.out.println("打印时长stringBuffer:" + time);
        time = System.currentTimeMillis();*/
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++)
            stringBuilder.append(arr[i] + " ");
        time = System.currentTimeMillis() - time;
        System.out.println("打印时长stringBuilder:" + time);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        int length = 99999;
        length = 10;

        Integer[] arr = new Integer[length];

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(999999);
        }
        System.out.println("排序前：" + printArr(arr));
        //  bubbleSort(arr);
        // selectSort(arr);
    }

}
