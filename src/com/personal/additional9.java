package com.personal;

/**
 * @author liuxiaohan1
 * @date 2021-08-03 3:02 下午
 */
public class additional9 {

    public char getChar(int n)
    {
        if (n <= 9)
            return (char) (n + '0');
        else
            return (char) (n - 10 + 'a');
    }
    public int getInt(char ch)
    {
        if ('0' <= ch && ch <= '9')
            return ch - '0';
        else
            return ch - 'a' + 10;
    }
    public String add36Strings(String num1, String num2)
    {
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        int x, y;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            x = i >= 0 ? getInt(num1.charAt(i)) : 0;
            y = j >= 0 ? getInt(num2.charAt(i)) : 0;
            int temp = x + y + carry;
            res.append(getChar(temp % 36));
            carry = temp / 36;
            i--;
            j--;
        }
        res.reverse();
        return res.toString();
    }

    public static void main(String[] args) {
        String a = "1b", b = "2x";
        additional9 additional9 = new additional9();
        String s = additional9.add36Strings(a, b);
        System.out.println(s);
    }

}
