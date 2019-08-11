package Collection.ListAPI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
@author 黄佳豪
@create 2019-07-24-15:47
*/
public class ListTest {
    public static void main(String[] args) {
        List list=new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add("zs" + i);
        }
        list.add(1, "ls");
        System.out.println(list);
        System.out.println(list.get(3));
        list.remove(4);
        System.out.println(list);

    }
}
