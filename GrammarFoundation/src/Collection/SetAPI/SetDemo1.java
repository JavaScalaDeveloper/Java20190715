package Collection.SetAPI;

import Collection.CollectionUtils;

import java.util.HashSet;
import java.util.Set;

/*
@author 黄佳豪
@create 2019-07-24-18:13
*/
public class SetDemo1 {
    public static void main(String[] args) {
        Set set = new HashSet<>();
        //添加
        set.add("lucy");
        set.add(123);
        set.add("lucy");
        set.add("cherry");
        set.add("lucy");
        set.add(null);//treeset不能添加null
        System.out.println(set);
        CollectionUtils.forEach(set);

    }
}
