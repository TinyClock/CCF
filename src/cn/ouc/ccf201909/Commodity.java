package cn.ouc.ccf201909;

/**
 * @description:
 * @author: Chuansheng Zhong
 * @create: 2019-12-09 10:34
 **/
public class Commodity {
    public int type;//商品种类的id
    public int id;//商品id
    public int score;//商品得分

    public Commodity(int type, int id, int score) {
        this.type = type;
        this.id = id;
        this.score = score;
    }

    public Commodity() {
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "type=" + type +
                ", id=" + id +
                ", score=" + score +
                '}';
    }
}
