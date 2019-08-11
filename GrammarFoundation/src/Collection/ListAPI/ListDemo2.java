package Collection.ListAPI;

import org.junit.Before;
import org.junit.Test;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

/*
@author 黄佳豪
@create 2019-07-24-15:50
使用List的实现类添加三本图书，并遍历，打印如下效果
 
名称：xx	价格：xx	作者：xx
名称：xx	价格：xx	作者：xx
并要求按价格排序

*/
public class ListDemo2 {
    List list;
    public void before() {

    }
    @Before
    public void test2() {
        list=new ArrayList();
        list.add(new Book1("西域记", 12.4, "合肥市"));
        list.add(new Book1("昂对外", 482.1, "电风扇"));
        list.add(new Book1("恩人挺帅的", 644.1, "沃尔沃"));
        list.add(new Book1("的科技公司", 1.2, "广撒网"));
        for (Object o : list) {
            System.out.println(o);
        }
    }

    @Test
    //按照价格进行排序
    public void colSort() {
        System.out.println("排序后...");
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = 0; j < list.size()-1; j++) {
                Book1 b1 = (Book1) list.get(j);
                Book1 b2 = (Book1) list.get(j+1);
                if (b1.getPrice() > b2.getPrice()) {
                    list.set(j, b2);
                    list.set(j+1, b1);
                }
            }
        }
        test3();
    }

    @Test
    public void test3() {
        //普通for循环
        for (int i = 0; i < list.size(); i++) {
            Object o = list.get(i);
            System.out.println(o);
        }
    }
}

class Book1 {
    private String name;
    private double price;
    private String author;

    @Override
    public String toString() {
        return String.format("名称：%s  价格：%.2f  作者：%s",name,price,author );
    }

    public Book1(String name, double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public Book1() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}