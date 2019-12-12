package cn.ouc.ccf201803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @description:
 * @author: Chuansheng Zhong
 * @create: 2019-12-12 15:31
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
        int L = nextInt();
        int t = nextInt();
        Ball[] balls = new Ball[n];
        for (int i = 0; i < n; i++) {
            balls[i] = new Ball(i, nextInt());
        }

        for (int i = 0; i < t; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (balls[j].hit(balls[k])) {
                        break;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                balls[j].move(L);
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(balls[i].pos + " ");
        }
    }

    static class Ball {
        int id;
        int pos;
        int speed = 1;

        public Ball(int id, int pos) {
            this.id = id;
            this.pos = pos;
        }

        /*
            判断当前小球和参数传递的小球是否相撞
         */
        public boolean hit(Ball ball) {
            if (this.pos == ball.pos) {
                this.speed = -this.speed;
                ball.speed = -ball.speed;
                return true;
            } else
                return false;
        }

        /*
            根据小球速度移动一秒小球
         */
        public void move(int L) {
            if (this.pos == 0 && this.speed == -1) {
                this.speed = 1;
                this.pos = 1;
            } else if (this.pos == L && this.speed == 1) {
                this.speed = -1;
                this.pos = L - 1;
            } else {
                this.pos += speed;
            }
        }
    }
}
