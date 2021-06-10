package com.personal;

import java.util.Random;

/**
 * 用 Rand7() 实现 Rand10()
 *
 * @author liuxiaohan1
 * @date 2021-06-10 18:53
 */
public class lc470 {

    public int _rand10() {
        while (true) {
            int num =  (rand7() - 1) * 7 + rand7(); // 等概率生成[1,49]范围的随机数
            if (num <= 40) return num % 10 + 1; // 拒绝采样，并返回[1,10]范围的随机数
        }
    }

    private int rand7() {
        Random random = new Random();
        return random.nextInt(7);
    }

    public int rand10() {
        while (true) {
            int a = rand7();
            int b = rand7();
            int num = (a - 1) * 7 + b; // rand 49
            if (num <= 40) return num % 10 + 1; // 拒绝采样

            a = num - 40; // rand 9
            b = rand7();
            num = (a - 1) * 7 + b; // rand 63
            if (num <= 60) return num % 10 + 1;

            a = num - 60; // rand 3
            b = rand7();
            num = (a - 1) * 7 + b; // rand 21
            if (num <= 20) return num % 10 + 1;
        }
    }

}
