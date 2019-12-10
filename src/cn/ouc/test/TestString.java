package cn.ouc.test;

import java.util.Date;

/**
 * @description:
 * @author: Chuansheng Zhong
 * @create: 2019-12-09 16:57
 **/
public class TestString {
    public static void main(String[] args) {
        long start, end;
        long times = 100000000;
        start = new Date().getTime();
        String str = "123";
        String str1 = "456";
        String temp;
        for (int i = 0; i < times; i++) {
            temp = str+str1;
        }
        end = new Date().getTime();
        System.out.println("String所花时间： " + (end - start) + "ms");

        start = new Date().getTime();
        String str2 = "123";
        String str3 = "456";
        String temp1;
        StringBuilder builder = new StringBuilder(str2);
        for (int i = 0; i < times; i++) {
            builder.append("str3");
        }
        end = new Date().getTime();
        System.out.println("StringBuilder所花时间： " + (end - start) + "ms");
    }
}
