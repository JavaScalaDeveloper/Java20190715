package Object.Enum;

import java.sql.SQLOutput;

/*
@author 黄佳豪
@create 2019-07-21-15:19
*/
public class EnnmDemo1 {
    public static void main(String[] args) {
        Gender g1 = Gender.BOY;
        System.out.println(g1);
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.WINTER);
    }
}

//提供简单示例：提供有参构造
class Season {
    private String name;
    private String des;

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", des='" + des + '\'' +
                '}';
    }

    public static final Season SPRING = new Season("spring", "green");
    public static final Season SUMMER = new Season("summer", "blue");
    public static final Season AUTUMN = new Season("autumn", "yellow");
    public static final Season WINTER = new Season("winter", "white");

    private Season(String name, String des) {
        this.name = name;
        this.des = des;
    }

    public String getName() {
        return name;
    }



    public String getDes() {
        return des;
    }


}

class Gender {
    //构造器私有化
    private Gender() {

    }

    public static final Gender BOY = new Gender();
    public static final Gender GIRL = new Gender();

    public void print() {

    }

    @Override
    public String toString() {
        return "Gender{}";
    }
}