package Collection.CollectionsAPI;

import Collection.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
@author 黄佳豪
@create 2019-07-25-16:43
*/
@SuppressWarnings("all")
public class CollectionsDemo1 {
    List list;

    @Before
    public void before() {
        list = new ArrayList();
        list.add("jack");
        list.add("wangwu");
        list.add("lisi");
        list.add("zhang");
    }

    @Test
    public void test1() {
        Collections.reverse(list);//翻转方法
        CollectionUtils.forEach(list);
        Collections.shuffle(list);//随机打乱
        CollectionUtils.forEach(list);
        Collections.sort(list);//排序
        CollectionUtils.forEach(list);
        Collections.swap(list,3,1);//交换
        CollectionUtils.forEach(list);
        System.out.println();


    }

    @Test
    public void test2() {
        Collections.sort(list, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                String s1=(String)o1;
                String s2=(String)o2;

                return s1.compareTo(s2);
//                return -s1.compareTo(s2);//倒序
            }
        });
        CollectionUtils.Iterator(list);
    }

    @Test
    public void test3() {
        Object max = Collections.max(list, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                String s1 = (String) o1;
                String s2 = (String) o2;

                return s1.compareTo(s2);
            }
        });//求最大值
        System.out.println(max+"\t"+max.hashCode());
    }
}
