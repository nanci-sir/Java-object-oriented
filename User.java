package thisdemo;

public class User {
    //成员变量私有
    private String getName;
    private double salary;
    private  double height;
    //无参构造器
    public User() {
    }

    //有参构造器

     //成套getGetName
    public String getGetName() {
        return getName;
    }

    public void setGetName(String getName) {
        this.getName = getName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

