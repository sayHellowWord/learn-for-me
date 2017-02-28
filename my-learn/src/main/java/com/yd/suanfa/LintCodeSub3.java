package com.yd.suanfa;

/**
 * Created by Administrator on 2017/2/27.
 */
public class LintCodeSub3 {

    public static void main(String[] args) {
        System.out.println(LintCodeSub3.digitCounts(1, 12));
    }

    /*
 * param k : As description.
 * param n : As description.
 * return: An integer denote the count of digit k in 1..n
 */
    public static int digitCounts(int k, int n) {
        // write your code here
        int num = 0;
        if (n < 10) {
            if (k <= n) {
                return 1;
            }
        }
        int tmp = n / (k * 10);
        if (tmp > 1) {
            num = tmp;
        }
        if (tmp > k) {
            num += 10;
        }
        if (tmp == k) {
            int current = k * 10;
            while (n - current >= 0) {
                num++;
                current++;
            }
        }
        return num;
    }

}
