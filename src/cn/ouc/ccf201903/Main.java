package cn.ouc.ccf201903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @description:
 * @author: Chuansheng Zhong
 * @create: 2019-12-09 20:25
 **/
public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokenizer = new StringTokenizer("");

    static String next() throws IOException {// 读取下一个字符串
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {// 读取下一个int型数值
        return Integer.parseInt(next());
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for (int i = 0; i < n; i++) {
            judge(next());
        }
//        System.out.println("加法：");
//        System.out.println(add("1"));//1
//        System.out.println(add("1+2"));//3
//        System.out.println(add("1+2+3"));//6
//        System.out.println(add("1+2+3+4"));//10
//
//        System.out.println("减法：");
//        System.out.println(add("1"));//1
//        System.out.println(add("1-2"));//-1
//        System.out.println(add("1-2-3"));//-4
//        System.out.println(add("1-2-3-4"));//-8
//
//        System.out.println("加减法混合：");
//        System.out.println(add("1+2-3"));//0
//        System.out.println(add("1-2+3"));//2
//        System.out.println(add("1+2-3+4"));//4
//        System.out.println(add("1-2+3-4"));//-2
//
//        System.out.println("乘法：");
//        System.out.println(add("1"));//1
//        System.out.println(add("1x2"));//2
//        System.out.println(add("1x2x3"));//6
//        System.out.println(add("1x2x3x4"));//24
//
//        System.out.println("除法：");
//        System.out.println(add("1"));//1
//        System.out.println(add("8/2"));//4
//        System.out.println(add("8/2/1"));//4
//        System.out.println(add("8/2/3/1"));//1
//
//        System.out.println("乘除法混合：");
//        System.out.println(add("1x4/2"));//2
//        System.out.println(add("4/2x2"));//4
//        System.out.println(add("1x4/2x2"));//4
//        System.out.println(add("4/2x2/2"));//2
//
//        System.out.println("乘加法混合：");
//        System.out.println(add("1x4+2"));//6
//        System.out.println(add("1+2x4"));//9
//        System.out.println(add("1x4+2x2"));//8
//        System.out.println(add("4+2x2+2"));//10
//
//        System.out.println("除加法混合：");
//        System.out.println(add("1/4+2"));//2
//        System.out.println(add("1+2/4"));//1
//        System.out.println(add("1/4+2/2"));//1
//        System.out.println(add("4+2/2+2"));//7
//
//        System.out.println("乘减法混合：");
//        System.out.println(add("1x4-2"));//2
//        System.out.println(add("1-2x4"));//-7
//        System.out.println(add("1x4-2x2"));//0
//        System.out.println(add("4-2x2-2"));//-2
//
//        System.out.println("除减法混合：");
//        System.out.println(add("1/4-2"));//-2
//        System.out.println(add("1-2/4"));//1
//        System.out.println(add("1/4-2/2"));//-1
//        System.out.println(add("4-2/2-2"));//1
//
        System.out.println("加减乘除混合：");
        System.out.println(add("1*2+3-4"));//1
        System.out.println(add("1/2+3-4"));//-1
        System.out.println(add("1*2+3/4"));//2
    }

    private static void judge(String str) {
        if(add(str)==24){
            System.out.println("Yes");
        }else
            System.out.println("No");
    }

    public static int add(String str) {
        char[] array = str.toCharArray();
        int length = array.length;
        if (length == 1)
            return array[0] - 48;

        if (str.contains("-")) {
            String[] split = str.split("\\+");
            int result = 0;
            for (int i = 0; i < split.length; i++) {
                result += sub(split[i]);
            }
            return result;
        } else if (str.contains("x")) {
            String[] split = str.split("\\+");
            int result = 0;
            for (int i = 0; i < split.length; i++) {
                result += time(split[i]);
            }
            return result;
        } else if (str.contains("/")) {
            String[] split = str.split("\\+");
            int result = 0;
            for (int i = 0; i < split.length; i++) {
                result += time(split[i]);
            }
            return result;
        } else {
            String s = String.copyValueOf(array, 2, length - 2);
            return (array[0] - 48) + add(s);
        }
    }

    public static int sub(String str) {
        char[] array = str.toCharArray();
        int length = array.length;
        if (length == 1)
            return array[0] - 48;
        if (str.contains("x")) {
            String[] split = str.split("\\-");
            int result = time(split[0]);
            for (int i = 1; i < split.length; i++) {
                result -= time(split[i]);
            }
            return result;
        } else if (str.contains("/")) {
            String[] split = str.split("\\-");
            int result = time(split[0]);
            for (int i = 1; i < split.length; i++) {
                result -= time(split[i]);
            }
            return result;
        } else {
            String s = String.copyValueOf(array, 0, length - 2);
            return sub(s) - (array[length - 1] - 48);
        }
    }

    public static int time(String str) {
        char[] array = str.toCharArray();
        int length = array.length;
        if (length == 1)
            return array[0] - 48;
        if (!str.contains("/")) {
            String s = String.copyValueOf(array, 2, length - 2);
            return (array[0] - 48) * time(s);
        } else {
            String[] split = str.split("x");
            int result = 1;
            for (int i = 0; i < split.length; i++) {
                result *= dev(split[i]);
            }
            return result;
        }

    }

    public static int dev(String str) {
        char[] array = str.toCharArray();
        int length = array.length;
        if (length == 1)
            return array[0] - 48;
        String s = String.copyValueOf(array, 0, length - 2);
        return dev(s) / (array[length - 1] - 48);
    }
}
