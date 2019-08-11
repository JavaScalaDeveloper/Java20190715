package Object.StaticAndFinal;

/*
@author 黄佳豪
@create 2019-07-20-14:24
*/
public class FinalDemo {

}

/*class Sub extends B {

}*/

final class B {
    final String name="final";
    public final void method() {
        final int i;
        System.out.println("method");
    }
}
