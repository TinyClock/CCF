package cn.ouc.ccf201909;

import java.util.*;

/**
 * @description:
 * @author: Chuansheng Zhong
 * @create: 2019-12-09 10:04
 **/
@SuppressWarnings("all")
public class RecommdSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        m = sc.nextInt();
        n = sc.nextInt();

        List<Commodity> commodityList = new ArrayList<>();//存储所有商品
        int id, score;
        for (int i = 0; i < n; i++) {
            id = sc.nextInt();
            score = sc.nextInt();
            for (int j = 0; j < m; j++) {
                commodityList.add(new Commodity(j, id, score));
            }
        }

        int opNum = sc.nextInt();//操作总数
        int[][] opArrays = new int[opNum][];
        int flag = 0;
        for (int i = 0; i < opArrays.length; i++) {
            flag = sc.nextInt();//获取第一个数字，判断是什么操作
            switch (flag) {
                case 1:
                    opArrays[i] = new int[4];
                    opArrays[i][0] = flag;
                    opArrays[i][1] = sc.nextInt();
                    opArrays[i][2] = sc.nextInt();
                    opArrays[i][3] = sc.nextInt();
                    break;
                case 2:
                    opArrays[i] = new int[3];
                    opArrays[i][0] = flag;
                    opArrays[i][1] = sc.nextInt();
                    opArrays[i][2] = sc.nextInt();
                    break;
                case 3:
                    opArrays[i] = new int[m + 2];
                    opArrays[i][0] = flag;
                    for (int j = 1; j < m + 2; j++) {
                        opArrays[i][j] = sc.nextInt();
                    }
                    break;
                default:
                    break;
            }
        }

        for (int i = 0; i < opArrays.length; i++) {
            flag = opArrays[i][0];
            switch (flag) {
                case 1:
                    fun1(commodityList, opArrays[i][1], opArrays[i][2], opArrays[i][3]);
                    break;
                case 2:
                    fun2(commodityList, opArrays[i][1], opArrays[i][2]);
                    break;
                case 3:
                    fun3(commodityList, opArrays[i], m);
                    break;
                default:
                    break;
            }
        }

//        System.out.println("操作如下：");
//        print(opArrays);
//        System.out.println("结果如下：");
//        commodityList.stream().forEach(System.out::println);
    }

    public static void print(int[][] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                System.out.print(arrays[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 方法1，在type类商品中添加编号为commodity的商品，该商品的分数为score
     *
     * @param list
     * @param type
     * @param commodity
     * @param score
     */
    public static void fun1(List<Commodity> list, int type, int commodity, int score) {
        Commodity com = new Commodity(type, commodity, score);
        list.add(com);
    }

    /**
     * 方法2，在type类商品中删除编号为commodity的商品
     *
     * @param list
     * @param type
     * @param commodity
     */
    public static void fun2(List<Commodity> list, int type, int commodity) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).type == type && list.get(i).id == commodity) {
                list.remove(i);
            }
        }
    }

    /**
     * @param list  商品集合
     * @param array 查询操作的数组 3 k k_0 k_1 ... k_{m-1}
     * @param m     商品种类[0,m-1]
     * @return
     */
    public static void fun3(List<Commodity> list, int[] array, int m) {
        int max = array[1];//选出的最大数量，不超过即可
        int total = 0;
        boolean biggerThanMax = false;
        //排序
//        Collections.sort(list, (o1, o2) -> {
//            if (o1.score != o2.score) {
//                return o2.score - o1.score;
//            } else if (o1.type != o2.type) {
//                return o1.type - o2.type;
//            } else
//                return o1.id - o2.id;
//        });

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
                        System.out.print(commodity.id + " ");
                        number++;
                    }
                }
                System.out.println();
            }
        } else {
            int totalNumber = 0;
            int number = 0;
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
                        System.out.print(comArray[j].id + " ");
                        isFind = true;
                    }
                }
                if(!isFind){
                    System.out.print(-1);
                }
                System.out.println();
            }
        }
    }
}
