package Object.StaticAndFinal;

/*+
@author 黄佳豪
@create 2019-07-20-17:09
*/
public class InitField {
    public static void main(String[] args) {
        InitDemo i = new InitDemo();
        System.out.println(i.toString());
    }
}

class InitDemo {
    static  {
        System.out.println("daimakuai");
    }
    public InitDemo() {
        System.out.println("cunstroctor");
    }

}
