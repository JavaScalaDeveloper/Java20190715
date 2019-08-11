package Object.Enum;

/*使用enum关键字定义枚举类
@author 黄佳豪
@create 2019-07-21-15:39
*/
public class EnumDemo2 {
    public static void main(String[] args) {
        System.out.println(Gender2.BOY + "\t" + Gender2.GIRL);
        //实例二
        System.out.println(Season3.SUMMER);
        System.out.println(Color.red);
        System.out.println(Color.red.name());
        Color[] values = Color.values();//返回所有color的对象


        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
        System.out.println("---------");
//        Color c_r = Color.valueOf("red");
        System.out.println(Color.valueOf("red"));//将一个有效的字符串转换成枚举对象
    }
}//空参构造器

enum Color {
    red(255, 0, 0), bule(0, 0, 255), black(0, 0, 0), yellow(255, 255, 0), green(0, 255, 0);
    public int redV;
    public int greenV;

    public int blueV;

    Color(int redV, int greenV, int blueV) {
        this.redV = redV;
        this.greenV = greenV;
        this.blueV = blueV;
    }

    @Override
    public String toString() {
        return "Color{" +
                "redV=" + redV +
                ", greenV=" + greenV +
                ", blueV=" + blueV +
                '}';
    }
}

enum Season3 {
    SPRING("spring", "green"),
    SUMMER("summer", "blue"),
    AUTUMN("autumn", "yellow"),
    WINTER("winter", "white");

    private String name;
    private String dsc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    Season3(String name, String dsc) {
        this.name = name;
        this.dsc = dsc;
    }
}

enum Gender2 {

    //枚举常量
    BOY, GIRL;

    public void print() {

    }


}