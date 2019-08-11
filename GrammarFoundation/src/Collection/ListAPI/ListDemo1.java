package Collection.ListAPI;

import java.util.ArrayList;
import java.util.List;

/*
@author 黄佳豪
@create 2019-07-24-15:33
*/
public class ListDemo1 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("johe");
        list.add("lucy");
        list.add(null);
        list.add("johe");//可重复
        list.add("jeck");
        System.out.println(list);
        list.add(1, "张益达");
//        list.add(10, "张益达");//IndexOutOfBoundsException: Index: 10, Size: 6
        System.out.println(list);
        list.remove(3);
        System.out.println(list);
        list.set(2, 123);
        System.out.println(list);
        System.out.println(list.indexOf(123));
    }
}
