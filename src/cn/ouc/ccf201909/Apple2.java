package cn.ouc.ccf201909;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @description:
 * @author: Chuansheng Zhong
 * @create: 2019-12-12 14:26
 **/
public class Apple2 {

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
        Scanner sc = new Scanner(System.in);
        int T = 0;
        int D = 0;
        int E = 0;
        int n = nextInt();
        int[][] arrays = new int[n][];
        boolean[] flagArray = new boolean[n];
        for (int i = 0; i < n; i++) {
            int m = nextInt();
            arrays[i] = new int[m];
            for (int j = 0; j < m; j++) {
                arrays[i][j] = nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            int sumRow = 0;
            int sumRow1 = arrays[i][0];
            for (int j = arrays[i].length - 1; j >= 0; j--) {
                sumRow += arrays[i][j];
                if (arrays[i][j] > 0) {
                    break;
                }
            }
            T += sumRow;

            for (int j = 1; j < arrays[i].length; j++) {
                if (arrays[i][j] > 0 && arrays[i][j] < sumRow1) {
                    D++;
                    flagArray[i] = true;
                    break;
                }
                if (arrays[i][j] > 0 && arrays[i][j] == sumRow1) {
                    continue;
                }
                sumRow1 += arrays[i][j];
            }
        }
        for (int i = 0; i < flagArray.length; i++) {
            if (flagArray[i] && flagArray[(i + 1) % n] && flagArray[(i + 2) % n]) {
                E++;
            }
        }
        System.out.println(T + " " + D + " " + E);
    }
}
