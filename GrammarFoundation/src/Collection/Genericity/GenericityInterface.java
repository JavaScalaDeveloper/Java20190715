package Collection.Genericity;

/*
@author 黄佳豪
@create 2019-07-25-19:32
*/
public interface GenericityInterface<T,U,M> {
    void method1(T t, U u, M m);

    M method2();

    U method3(T t1, T t2);
}

interface Sub extends GenericityInterface {
}

abstract class Sub2 implements Sub {
    @Override
    public void method1(Object o, Object o2, Object o3) {

    }
}
class GenericityTest implements Sub {
    @Override
    public void method1(Object o, Object o2, Object o3) {

    }

    @Override
    public Object method2() {
        return null;
    }

    @Override
    public Object method3(Object t1, Object t2) {
        return null;
    }
}
