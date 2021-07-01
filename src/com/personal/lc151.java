package com.personal;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 翻转字符串里的单词
 * @author liuxiaohan1
 * @date 2021-07-01 10:43 上午
 */
public class lc151 {

    public String reverseWords(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ') {
                word.append(c);
            } else if ((word.length() != 0) && (c == ' ')) {
                // 将单词放入栈
                stack.offerFirst(word.toString());
                word.setLength(0);
            }
            left++;
        }
        // 把最后一个word放进去
        stack.offerFirst(word.toString());
        return String.join(" ", stack);
    }

}
