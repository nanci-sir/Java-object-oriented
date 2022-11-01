package thisdemo;

public class test {
    public static void main(String[] args) {
        Car c = new Car("奔驰",32);
        System.out.println(c.name);
        System.out.println(c.price);
        System.out.println("***************");
        System.out.println(c);
        c.goWith("宝马");
    }
}
