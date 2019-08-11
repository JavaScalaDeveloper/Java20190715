package Collection.MapAPI;

import java.util.HashMap;

/*
@author 黄佳豪
@create 2019-07-25-14:34
*/
public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        for (int i = 1; i <= 12; i++) {
            map.put("mr" + i, i);
        }
        for (int i = 13; i <= 24; i++) {
            map.put("mj" + i, i);
        }
        System.out.println(map);
    }
}
