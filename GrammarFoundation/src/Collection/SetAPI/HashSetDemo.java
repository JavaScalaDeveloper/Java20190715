package Collection.SetAPI;

import java.awt.print.Book;
import java.util.HashSet;

/*
@author 黄佳豪
@create 2019-07-24-21:17
*/
public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<Object> set = new HashSet<>();
        set.add("fdjga");
        set.add("gdgm");
        set.add("fgfsa");
        set.add("fdjga");
        System.out.println(set.add("fdjga"));//false,不能正常添加
    }
}
