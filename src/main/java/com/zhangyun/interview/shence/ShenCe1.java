package com.zhangyun.interview.shence;

import java.util.Scanner;

/**
 * description:
 *
 * @author: zhangyun
 * @date: 2022/8/19 19:54
 * @since: 1.0
 */
public class ShenCe1 {
    private static int[] nums = new int[7];

    public static void main(String[] args) {
        // 获取输入
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String ip = in.next();
            if (!check(ip)) {
                System.out.println(-1);
                continue;
            }
            long ipNum = 0;
            for (int i = 0; i < 7; i++) {
                ipNum += nums[i] * (long) Math.pow(256, 6 - i);
            }
            System.out.println(ipNum);
        }

    }

    public static boolean check(String ip) {
        String[] split = ip.split("\\.");
        if (split.length != 7) {
            return false;
        }
        if (split[0].isEmpty() || split[6].isEmpty() || Integer.parseInt(split[0]) == 0) {
            return false;
        }
        for (int i = 0; i < 7; i++) {
            if (split[i].isEmpty()) {
                nums[i] = 0;
            } else {
                try {
                    nums[i] = Integer.parseInt(split[i]);
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return true;
    }
}
