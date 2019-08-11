package Collection;

import java.util.Collection;
import java.util.Iterator;

/*
@author 黄佳豪
@create 2019-07-24-18:17
*/
public class CollectionUtils {
    //Iterator
    public static void Iterator(Collection col) {
        Iterator iterator = col.iterator();
        while (iterator.hasNext()) {
            Object i = iterator.next();
            System.out.println(i+"\t");
        }
    }

    //foreach
    public static void forEach(Collection col2) {
        for (Object o : col2) {
            System.out.print(o+"\t");

        }
    }
}
