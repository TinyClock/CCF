package cn.ouc.ccf201903;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.math.BigDecimal;
        import java.math.RoundingMode;
        import java.util.StringTokenizer;

/**
 * 小中大
 *
 * @description:
 * @author: Chuansheng Zhong
 * @create: 2019-12-09 19:27
 **/
public class Test1 {

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
        StringBuilder builder = new StringBuilder();
        int n = nextInt();
        int max, min;
        double mid;
        int midInt;
        int k = 0;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        max = array[0];
        min = array[n - 1];

        //1个数，或都相等
        if (max == min) {
            System.out.println(builder.append(max).append(" ").append(max).append(" ").append(max));
        } else if (max > min) {
            if (n % 2 == 0) {
                k = (int) ((array[n / 2 - 1] + array[n / 2]) % 2);
                mid = formatDouble((array[n / 2 - 1] + array[n / 2]) / 2.0);
                midInt = (array[n / 2 - 1] + array[n / 2]) / 2;
                if (k == 0) {
                    System.out.println(builder.append(max).append(" ").append(midInt).append(" ").append(min));
                } else
                    System.out.println(builder.append(max).append(" ").append(mid).append(" ").append(min));

            } else {
                System.out.println(builder.append(max).append(" ").append(array[n / 2]).append(" ").append(min));
            }
        } else {
            if (n % 2 == 0) {
                k = (int) ((array[n / 2 - 1] + array[n / 2]) % 2);
                mid = formatDouble((array[n / 2 - 1] + array[n / 2]) / 2);
                midInt = (array[n / 2 - 1] + array[n / 2]) / 2;
                if (k == 0) {
                    System.out.println(builder.append(min).append(" ").append(midInt).append(" ").append(max));
                } else
                    System.out.println(builder.append(min).append(" ").append(mid).append(" ").append(max));

            } else {
                System.out.println(builder.append(min).append(" ").append(array[n / 2]).append(" ").append(max));
            }
        }
    }

    public static double formatDouble(double d) {
        BigDecimal bg = new BigDecimal(d).setScale(1, RoundingMode.UP);
        return bg.doubleValue();
    }
}
