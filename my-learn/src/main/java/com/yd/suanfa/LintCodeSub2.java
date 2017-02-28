package com.yd.suanfa;

/**
 * Created by Administrator on 2017/2/27.
 */
public class LintCodeSub2 {

    public static void main(String[] args) {
      /*  int n = 11;
        int temp = 1;
        for (int i = 1; i <= n; i++) {
            temp = temp * i;
        }
        int num = 0;
        while (temp % 10 == 0) {
            num++;
            temp = temp / 10;
        }
        System.out.println(num);*/

       // System.out.println(trailingZeros(105));
        System.out.println("=========================");
        System.out.println(trailingZeros2(105));

    }

    public static long trailingZeros(long n) {
        if (n < 5) {
            return 0;
        }
        int tmp = 5;
        int num = 0;
        while (tmp < n) {
            num++;
            tmp += 5;
            System.out.print(" ** " + tmp);
        }
        System.out.println("----------------------------");
        return num;
    }

    public static long trailingZeros2(long n) {
        System.out.println(n);
        return n == 0 ? 0 : n / 5 + trailingZeros2(n / 5);
    }
}
