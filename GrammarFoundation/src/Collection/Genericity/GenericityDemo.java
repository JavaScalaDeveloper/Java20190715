package Collection.Genericity;

import Collection.CollectionUtils;
import com.sun.javafx.collections.ListListenerHelper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
@author 黄佳豪
@create 2019-07-25-17:51
*/
public class GenericityDemo {
    @Test
    public void test1() {
        List<Object> list = new ArrayList();
        list.add("lucy");//不能添加非int型
        list.add(123);
        list.add(456);
        CollectionUtils.forEach(list);
        List<Object> l = new ArrayList<>();
        CollectionUtils.forEach(l);

        Collections.copy(l, list);
        CollectionUtils.Iterator(l);
//        while ()
    }
}
