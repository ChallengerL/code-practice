package com.personal;

/**
 * @description:
 * @author: liuXiaoHan
 * @date: 2021-09-12 22:20
 **/
public class test_try_catch {

    public static void main(String[] args) {

        try {
            System.out.println("try");
            return;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
    }

}
