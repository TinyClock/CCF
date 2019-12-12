package cn.ouc.ccf201809;

import java.util.Scanner;

/**
 * @description:
 * @author: Chuansheng Zhong
 * @create: 2019-12-11 10:39
 **/
public class BuyVegetables {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arrayH = new int[n][2];
        int[][] arrayW = new int[n][2];
        for (int i = 0; i < n; i++) {
            arrayH[i] = new int[2];
            arrayH[i][0] = sc.nextInt();
            arrayH[i][1] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            arrayW[i] = new int[2];
            arrayW[i][0] = sc.nextInt();
            arrayW[i][1] = sc.nextInt();
        }

        int time = 0;
        int ai, bi, cj, dj;
        boolean flag = false;
        for (int i = 0; i < arrayH.length; i++) {
            ai = arrayH[i][0];
            bi = arrayH[i][1];
            flag = false;
            for (int j = 0; j < arrayW.length; j++) {
                if (flag)
                    break;
                cj = arrayW[j][0];
                dj = arrayW[j][1];
                if (cj <= ai && ai <= dj && dj <= bi) {
                    time += (dj - ai);
                    flag = true;
                } else if (cj <= ai && bi <= dj) {
                    time += (bi - ai);
                    flag = true;
                } else if (ai <= cj && cj <= bi && dj <= bi) {
                    time += (dj - cj);
                    flag = true;
                } else if (ai <= cj && cj <= bi && bi <= dj) {
                    time += (bi - cj);
                    flag = true;
                }
            }
        }
        System.out.print(time);
    }

    public static void print(int[][] array) {
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
