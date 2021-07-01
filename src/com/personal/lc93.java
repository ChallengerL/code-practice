package com.personal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 复原IP地址
 * @author liuxiaohan1
 * @date 2021-07-01 4:35 下午
 */
public class lc93 {

    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        LinkedList<String> path = new LinkedList<>();
        backtrack(s, 0, path);
        return res;
    }
    public void backtrack(String s, int start, LinkedList<String> path) {
        // 终止条件，ip段最多4段，超过4段终止。如果等于4段但是不是一开始完整的字符串也终止。
        // 如果4段并且组合起来是一开始的字符串则添加到结果里面去。
        if (path.size() > 4) {
            return;
        }
        if (path.size() == 4 && start != s.length()) {
            return;
        }
        if (path.size() == 4) {
            res.add(String.join(".", path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            // 过滤条件：如果字符串在0-255之外，过滤。如果字符串存在01这种情况，过滤。
            String substring = s.substring(start, i + 1);
            if ((substring.length() > 1 && substring.startsWith("0")) || substring.length() > 3) {
                continue;
            }
            if (Integer.parseInt(substring) > 255 || Integer.parseInt(substring) < 0) {
                continue;
            }

            path.add(substring);
            backtrack(s, i + 1, path);
            path.removeLast();
        }
    }

}
