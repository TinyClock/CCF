package cn.ouc.ccf201809;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: Chuansheng Zhong
 * @create: 2019-12-11 10:29
 **/
public class SaleVegetables {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        int[] resultArray = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        resultArray[0] = (array[0] + array[1]) / 2;
        resultArray[n - 1] = (array[n - 2] + array[n - 1]) / 2;

        for (int i = 1; i < n - 1; i++) {
            resultArray[i] = (array[i - 1] + array[i] + array[i + 1]) / 3;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(resultArray[i] + " ");
        }
    }
}
