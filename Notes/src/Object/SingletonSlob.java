package Object;

/*单例模式懒汉式
@author 黄佳豪
@create 2019-07-20-15:05
*/
public class SingletonSlob {

}

class Single {
    //    ①构造器私有化
    private Single() {
    }

    //    ②本类内部声明引用
    private static Single single;

    //    ③提供一个公共的静态方法供外部使用
    public static Single getInstance() {
        if (single == null) {
            single = new Single();
        }
        return single;
    }
}