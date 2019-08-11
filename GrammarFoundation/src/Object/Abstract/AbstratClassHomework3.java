package Object.Abstract;

/*
@author 黄佳豪
@create 2019-07-21-8:59
一、定义一个接口用来实现两个对象的比较。
interface CompareObject{
public int compareTo(Object o);   //若返回值是 0 , 代表相等; 若为正数，代表当前对象大；负数代表当前对象小
}
定义矩形类Rectangle和ComparableRectangle类，在ComparableRectangle类中给出compareTo方法的实现，比较两个矩形的面积大小。
义

*/
public class AbstratClassHomework3  {

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(2, 4);
        Rectangle r2 = new Rectangle(5, 8);
        ComparableRectangle c = new ComparableRectangle();
        int i = c.compareTo(r2);
        if (r1.sum() > i) {
            System.out.println("r1对象大。");
        } else if (r1.sum() == i) {
            System.out.println("r1与r2相等");
        } else {
            System.out.println("r1对象小。");
        }
    }
}

interface CompareObject {
    public int compareTo(Object o);
}

class ComparableRectangle implements CompareObject{

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
class Rectangle {
   private int l;//长
   private int w;//宽

    public Rectangle() {
    }

    public Rectangle(int l, int w) {
        this.l = l;
        this.w = w;

    }

    public int sum() {
        return l*w;
    }

}
