package cn.ouc.ccf201903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @description:
 * @author: Chuansheng Zhong
 * @create: 2019-12-10 12:39
 **/
public class Calculate {
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
    }

    private static void judge(String str) {
        if (calculate(str) == 24) {
            System.out.println("Yes");
        } else
            System.out.println("No");
    }

    private static int calculate(String str) {
        char[] array = str.toCharArray();
        int result = 0;
        if (array[1] == 'x') {
        }
        return 0;
    }


}
