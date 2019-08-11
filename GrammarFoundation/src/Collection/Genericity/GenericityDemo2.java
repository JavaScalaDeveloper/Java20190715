package Collection.Genericity;

/*
@author 黄佳豪
@create 2019-07-25-19:24
*/
public class GenericityDemo2<A> {
    public GenericityDemo2(A name) {
        this.name = name;
    }

    public GenericityDemo2() {

    }

    public A getName() {
        return name;
    }

    public void setName(A name) {
        this.name = name;
    }

    private A name;

    @Override
    public String toString() {
        return "GenericityDemo2{" +
                "name=" + name +
                '}';
    }

    public static void main(String[] args) {
        GenericityDemo2<String> aa = new GenericityDemo2("zs");
        System.out.println(aa.getClass());
    }
}
