package Collection.ArrayListAPI;

import java.util.ArrayList;

/*
@author 黄佳豪
@create 2019-07-24-16:18
*/
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            list.add("zs " + i);
            System.out.println(list);
        }
        for (int i = 11; i <=20; i++) {
            list.add("ls " + i);
            System.out.println(list);
        }
    }
}
