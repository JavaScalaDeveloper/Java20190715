package Collection.Genericity;

import java.util.ArrayList;
import java.util.Collection;

/*泛型通配符
@author 黄佳豪
@create 2019-07-26-11:10
*/
public class GenericDemo3 {
    public static void main(String[] args) {
        ArrayList<Object> col1 = new ArrayList<>();
        ArrayList<String > col2 = new ArrayList<>();
        printCollection(col1);
        printCollection(col2);//泛型不具备继承性
    }
    public static void printCollection(Collection<?> col) {
        for (Object o : col) {
            System.out.println(o.toString());

        }
    }
}
