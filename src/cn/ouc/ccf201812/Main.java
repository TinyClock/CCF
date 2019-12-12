package cn.ouc.ccf201812;

import java.util.Scanner;

/**
 * @description:
 * @author: Chuansheng Zhong
 * @create: 2019-12-11 09:20
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int y = sc.nextInt();
        int g = sc.nextInt();
        int n = sc.nextInt();
        int time = 0;
        int[] array;
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            int t = sc.nextInt();
            array = fun(k, t, time, r, y, g);
            k = array[0];
            t = array[1];
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

    /**
     * 输入之前观测的灯、倒计时
     * 返回到达该处时的灯、倒计时
     *
     * @return 返回当前灯的状态和，倒计时
     */
    public static int[] fun(int a, int b, int time, int r, int y, int g) {
        int[] array = new int[2];
        time %= (r + y + g);
        switch (a) {
            case 0:
                array[0] = a;
                array[1] = b;
                break;
            case 1:
                if (time < b) {
                    array[0] = 1;
                    array[1] = b - time;
                } else if (b < time && time < b + g) {
                    array[0] = 3;
                    array[1] = b + g - time;
                } else if (b + g < time && time < b + g + y) {
                    array[0] = 2;
                    array[1] = b + g + y - time;
                } else if (b + g + y < time && time < r + g + y) {
                    array[0] = 1;
                    array[1] = b + r + g + y - time;
                }
                break;
            case 2:
                if (time < b) {
                    array[0] = 2;
                    array[1] = b - time;
                } else if (b < time && time < b + r) {
                    array[0] = 1;
                    array[1] = b + r - time;
                } else if (b + r < time && time < b + r + g) {
                    array[0] = 3;
                    array[1] = b + r + g - time;
                } else if (b + r + g < time && time < r + g + y) {
                    array[0] = 2;
                    array[1] = b + r + g + y - time;
                }
                break;
            case 3:
                if (time < b) {
                    array[0] = 3;
                    array[1] = b - time;
                } else if (b < time && time < b + y) {
                    array[0] = 2;
                    array[1] = b + y - time;
                } else if (b + y < time && time < b + y + r) {
                    array[0] = 1;
                    array[1] = b + y + r - time;
                } else if (b + y + r < time && time < r + g + y) {
                    array[0] = 3;
                    array[1] = b + r + g + y - time;
                }
                break;
            default:
                break;
        }
        return array;
    }
}
