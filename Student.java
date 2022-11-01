package thisdemo;

public class Student {
    private int age;
    public int getAge(int i) {
        return age;
    }
    public void setAge(int age) {
        if (age >= 0 && age <= 200) {
            this.age = age;
        } else {
            System.out.println("请检查年龄数值");
        }
    }
}

