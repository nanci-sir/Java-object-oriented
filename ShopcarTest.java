package demo;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class ShopcarTest {
    public static void main(String[] args) {
        //1.定义商品类
        //2.定义购物车对象，使用数组；
        Goods[]shopcar = new Goods[100];
        //3.搭建操作架构；
        while (true) {
            System.out.println("请您选则以下命令进行操作 ：");
            System.out.println("添加商品到购物车 ：add");
            System.out.println("查询商品到购物车 ：query");
            System.out.println("修改商品购买数量 ：update");
            System.out.println(" 结算购买商品金额：pay");
            Scanner sc = new Scanner(System.in);
            String command = sc.next();//接受命令
            switch (command){
                case "add":
                      //添加商品到购物车
                       addGoods(shopcar , sc);
                    break;
                case "query":
                       //查询商品到购物车
                       qureyDoods(shopcar);

                    break;
                    case "update":
                        //修改商品购买数量
                        updateDoods(shopcar,sc);

                        break;
                    case "pay":
                        //结算购买商品金额
                        payDoods(shopcar);
                        break;
                default:
                    System.out.println("没有该功能！");
            }
        }
    }
      //结算金额方法
    private static void payDoods(Goods[] shopcar) {
        qureyDoods(shopcar);
        //1.定义求和
        double money = 0;
        //2.遍历全部商品，累加单价*数量；
        for (int i = 0; i < shopcar.length; i++) {
           Goods g = shopcar[i];
           if(g !=null){
               money +=(g.getPrice() *g.getBuyNumber());
           }else{
               break;
           }
        }
        System.out.println("订单总金额：" + money);
    }
   //修改商品数量方法
    private static void updateDoods(Goods[] shopcar,Scanner sc) {
        //输入修改id;
        //根据id查询修改商品对象
        while (true) {
            System.out.println("请输入修改商品的id： ");
            int id = sc.nextInt();
            Goods g =  getGoodsById(shopcar,id);
            if(g == null){
                //没有该商品
                System.out.println("没有购买该商品");
            }else{
                System.out.println("请您输入" + g.getName() + "最新购买数量");
                int buyNumber = sc.nextInt();
                g.setBuyNumber(buyNumber);
                System.out.println("修改完成！");
                qureyDoods(shopcar);
                break;
            }
        }
    }
   // 根据id查询修改方法
    public  static Goods getGoodsById(Goods[] shopcar,int id){
        for (int i = 0; i < shopcar.length; i++) {
            Goods g = shopcar[i];
            if(g != null){
                //判断是否是我们找的商品编号地址
                if(g.getId() == id){
                    return g;

                }else{
                    return null;
                }
            }
        }
        return  null;
    }
    //查询商品方法
    private static void qureyDoods(Goods[] shopcar) {
        System.out.println("*********查询购物车信息如下**********");
        System.out.println("编号\t\t名称\t\t\t价格\t\t\t购买数量");

        for (int i = 0; i <shopcar.length ; i++) {
           Goods g = shopcar[i] ;
           if(g !=null){
               //展示商品
               System.out.println(g.getId() + "\t\t" + g.getName() + "\t\t\t" + g.getPrice() +"\t\t\t" +g.getBuyNumber());
           }else{
               //遍历结束
               break;
           }

        }
    }

    //添加商品方法
    private static void addGoods(Goods[] shopcar,Scanner sc) {
        //1.录入商品信息
        System.out.println("请您输入商品编号: ");
        int id = sc.nextInt();
        System.out.println("请您输入商品名称: ");
        String name = sc.next();
        System.out.println("请您输入商品数量: ");
        int buyNumber = sc.nextInt();
        System.out.println("请您输入商品价格: ");
        double price = sc.nextDouble();
        //2.把购买商品信息封装成对象
        Goods g = new Goods();
        g.setId(id);
        g.setName(name);
        g.setBuyNumber(buyNumber);
        g.setPrice(price);
        //3.把商品对象添加到数组，遍历数组
        for (int i = 0; i < shopcar.length; i++) {
            shopcar[i] = g;
            break;
        }
        System.out.println("您的商品："+g.getName()+"添加成功");
    }
}
