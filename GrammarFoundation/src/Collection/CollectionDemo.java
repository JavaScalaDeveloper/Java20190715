package Collection;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
@author 黄佳豪
@create 2019-07-23-20:48
*/
public class CollectionDemo {
    public static void main(String[] args) {
        Collection col= new ArrayList();
        col.add(new String("dr"));
        col.add(new String("derqwe"));
        col.add("战斗法师");
        Iterator i = col.iterator();
        for (Object o : col) {
            System.out.print(o);
        }
        while (true) {

            if (i.hasNext()) {
                System.out.println(i.next());
            }
        }

    }
    @Test
    public  void test(){
        String[] str = new String[5];
        for(String myStr : str){
            myStr = "atguigu";
            System.out.println(myStr);
        }
        for(int i = 0;i < str.length;i++){
            System.out.println(str[i]);
        }
    }

}
 class TestFor {

}
