package Collection.SetAPI;

import Collection.CollectionUtils;

import java.util.HashSet;
import java.util.TreeSet;

/*
@author 黄佳豪
@create 2019-07-24-21:55
*/
public class TreeSetDemo {
    public static void main(String[] args) {
        HashSet<Object> hs = new HashSet<>();
        hs.add("23");
        hs.add("45");
        hs.add("24");
        hs.add("-14");
        CollectionUtils.forEach(hs);
        System.out.println("treeSet进行了排序");
        TreeSet ts=new TreeSet();
        ts.add("23");
        ts.add("45");
        ts.add("24");
        ts.add("-14");
        CollectionUtils.forEach(ts);
    }
}
