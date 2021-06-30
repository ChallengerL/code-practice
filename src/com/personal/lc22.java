package com.personal;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * @author liuxiaohan1
 * @date 2021-06-30 4:27 下午
 */
public class lc22 {

    ArrayList<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs("", n, n);
        return res;
    }
    public void dfs(String cur, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(cur);
            return;
        }
        if (left > 0) {
            dfs(cur + "(", left - 1, right);
        }
        if (right > left) {
            dfs(cur + ")", left, right - 1);
        }
    }

}
