package cn.ouc.ccf201909;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokenizer = new StringTokenizer("");
    static String nextLine() throws IOException{// 读取下一行字符串
        return reader.readLine();
    }
    static String next() throws IOException {// 读取下一个字符串
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {// 读取下一个int型数值
        return Integer.parseInt(next());
    }

    static double nextDouble() throws IOException {// 读取下一个double型数值
        return Double.parseDouble(next());
    }

    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        int m, n;
        m = nextInt();
        n = nextInt();

        List<Commodity> commodityList = new ArrayList<>();//存储所有商品
        int id, score;
        for (int i = 0; i < n; i++) {
            id = nextInt();
            score = nextInt();
            for (int j = 0; j < m; j++) {
                commodityList.add(new Commodity(j, id, score));
            }
        }

        int opNum = nextInt();//操作总数
        int[][] opArrays = new int[opNum][];
        int flag = 0;
        for (int i = 0; i < opArrays.length; i++) {
            flag = nextInt();//获取第一个数字，判断是什么操作
            switch (flag) {
                case 1:
                    opArrays[i] = new int[4];
                    opArrays[i][0] = flag;
                    opArrays[i][1] = nextInt();
                    opArrays[i][2] = nextInt();
                    opArrays[i][3] = nextInt();
                    fun1(commodityList, opArrays[i][1], opArrays[i][2], opArrays[i][3]);
                    break;
                case 2:
                    opArrays[i] = new int[3];
                    opArrays[i][0] = flag;
                    opArrays[i][1] = nextInt();
                    opArrays[i][2] = nextInt();
                    fun2(commodityList, opArrays[i][1], opArrays[i][2]);
                    break;
                case 3:
                    opArrays[i] = new int[m + 2];
                    opArrays[i][0] = flag;
                    for (int j = 1; j < m + 2; j++) {
                        opArrays[i][j] = nextInt();
                    }
                    fun3(commodityList, opArrays[i], m);
                    break;
                default:
                    break;
            }
        }
    }

    public static void fun1(List<Commodity> list, int type, int commodity, int score) {
        Commodity com = new Commodity(type, commodity, score);
        list.add(com);
        //排序
        Collections.sort(list, new Comparator<Commodity>() {
            @Override
            public int compare(Commodity o1, Commodity o2) {
                if (o1.score != o2.score) {
                    return o2.score - o1.score;
                } else if (o1.type != o2.type) {
                    return o1.type - o2.type;
                } else
                    return o1.id - o2.id;
            }
        });
    }

    public static void fun2(List<Commodity> list, int type, int commodity) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).type == type && list.get(i).id == commodity) {
                list.remove(i);
            }
        }
    }

    public static void fun3(List<Commodity> list, int[] array, int m) {
        int max = array[1];//选出的最大数量，不超过即可
        int total = 0;
        boolean biggerThanMax = false;

        for (int i = 2; i < array.length; i++) {
            total += array[i];
        }
        biggerThanMax = total > max ? true : false;

        if (!biggerThanMax) {
            int number = 0;
            for (int i = 0; i < m; i++) {
                int k_m = array[i + 2];
                number = 0;
                for (Commodity commodity : list) {
                    if (number >= k_m)
                        break;
                    if (commodity.type == i) {
                        System.out.print(commodity.id);
                        System.out.print(" ");
                        number++;
                    }
                }
                System.out.println();
            }
        } else {
            Commodity[] comArray = new Commodity[max];
            for (int i = 0, j = 0; i < max; i++) {
                Commodity commodity = list.get(j++);
                if (array[commodity.type + 2] > 0) {
                    array[commodity.type + 2]--;
                    comArray[i] = commodity;
                } else {
                    i--;
                }
            }
            for (int i = 0; i < m; i++) {
                boolean isFind = false;
                for (int j = 0; j < comArray.length; j++) {
                    if (comArray[j].type == i) {
                        System.out.print(comArray[j].id);
                        System.out.print(" ");
                        isFind = true;
                    }
                }
                if (!isFind) {
                    System.out.print(-1);
                }
                System.out.println();
            }
        }
    }

    static class Commodity {
        public int type;//商品种类的id
        public int id;//商品id
        public int score;//商品得分

        public Commodity(int type, int id, int score) {
            this.type = type;
            this.id = id;
            this.score = score;
        }
    }
}
