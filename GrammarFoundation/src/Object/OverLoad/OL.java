package Object.OverLoad;

/*
@author 黄佳豪
@create 2019-07-18-20:22
*/
public class OL {
    public static void main(String[] args) {
        OLDemo o1 = new OLDemo();
        o1.mOL(2);
        o1.mOL(2,4);
        o1.mOL(2,3.234);

    }
}

class OLDemo {
    public void mOL(int a) {
        System.out.println(Math.pow(a,2));
    }public void mOL(int a,int b) {
        System.out.println(Math.pow(a,b));
    }public void mOL(int a,double b) {
        System.out.println(Math.pow(a,b));
    }
}
