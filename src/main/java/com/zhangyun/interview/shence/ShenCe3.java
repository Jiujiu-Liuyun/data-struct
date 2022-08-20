package com.zhangyun.interview.shence;

import java.util.Scanner;

/**
 * description:
 *
 * @author: zhangyun
 * @date: 2022/8/19 19:54
 * @since: 1.0
 */
public class ShenCe3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n == 1) {
            return;
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int[] dp = new int[n];
        dp[1] = nums[1] + nums[0] - 1;
        int max = dp[1];
        int last = 0;
        for (int i = 2; i < n; i++) {
            int newVal = nums[i] + nums[i - 1] - 1;
            int old = nums[i] + nums[last] - (i - last);
            dp[i] = Math.max(newVal, old);
            last = newVal >= old ? i - 1 : last;
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

}
