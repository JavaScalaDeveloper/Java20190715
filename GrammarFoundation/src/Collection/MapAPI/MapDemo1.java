package Collection.MapAPI;

import Collection.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.util.*;

/*
@author 黄佳豪
@create 2019-07-25-11:31
*/
@SuppressWarnings("all")
public class MapDemo1 {
    public static void main(String[] args) {
        Map m = new HashMap<>();
        m.put(1, "zs");
        m.put(2, "ls");
        m.put(3, "ww");
        m.put(4, "zl");
        m.put(5, "wq");
        m.put(6, "lk");
        m.put(1, "zs");//重复
        m.put(7, null);
        m.put(null, "wbq");
        System.out.println(m);
        CollectionUtils.forEach(m.entrySet());
        System.out.println(m.get(3));
        System.out.println(m.keySet());//键的视图
        System.out.println(m.size());//键值对个数
        Map t = new Hashtable();
        t.put(1, "zs");
        t.put(2, "ls");
        t.put(3, "ww");
        t.put(4, "zl");
        t.put(5, "wq");
        t.put(6, "lk");
        t.put(1, "zs");//重复
//        t.put(7, null);//NullPointerException
//        t.put(null, "wbq");//NullPointerException
        System.out.println(t);
    }

    Map m;

    @Before
    public void berfore() {
        m = new HashMap();
        m.put(1, "zs");
        m.put(2, "ls");
        m.put(3, "ww");
        m.put(4, "zl");
        m.put(5, "wq");
        m.put(6, "lk");
        m.put(1, "zs");//重复
        m.put(7, null);
        m.put(null, "wbq");
    }

    @Test
    public void test1() {
        Set set = m.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.print(entry.getKey()+"\t"+entry.getValue()+"\n");
        }
    }

    @Test
    public void test2() {
        Set keySet = m.keySet();
        for (Object o : keySet) {
            System.out.println(o+"\t"+m.values());
        }
    }
}
