package cn.ouc.ccf201812;

import java.util.Scanner;

/**
 * @description:
 * @author: Chuansheng Zhong
 * @create: 2019-12-10 21:06
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int y = sc.nextInt();
        int g = sc.nextInt();
        int n = sc.nextInt();
        int time = 0;//所花总时间
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            int t = sc.nextInt();
            switch (k) {
                case 0:
                    time += t;
                    break;
                case 1:
                    time += t;
                    break;
                case 2:
                    time = time + t + r;
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        }
        System.out.println(time);
    }
}
