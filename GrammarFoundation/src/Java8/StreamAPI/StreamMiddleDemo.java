package Java8.StreamAPI;

import org.junit.Before;
import org.junit.Test;

import java.net.SocketTimeoutException;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/*
@author 黄佳豪
@create 2019-07-31-17:00
*/
public class StreamMiddleDemo {
    List<Employee1> list;

    @Before
    public void before() {
        list = EmployeeData.getEmployees();
    }

    @Test
    public void test1() {
        Stream<Employee1> stream = list.stream();
        //中间操作
       /* stream.filter(new Predicate<Employee1>() {
            @Override
            public boolean test(Employee1 employee1) {
                return employee1.getAge()>30;
            }
        });*/
        Stream<Employee1> filter = stream.filter(t -> t.getAge() > 30);
        filter.forEach(System.out::println);
    }

    @Test//筛选与切片
    public void test2() {
        //过滤年龄大于30&&性别为男&&工资大于2000
        list.stream().filter(t -> t.getAge() > 30).filter(t -> t.getSalary() > 2000).forEach(System.out::println);
    }

    @Test//测试排序
    public void test4() {
        Stream<Employee1> stream = list.stream();
        Stream<Employee1> sorted =
                stream.sorted(new Comparator<Employee1>() {
                    @Override
                    public int compare(Employee1 o1, Employee1 o2) {
                        return Double.compare(o1.getSalary(), o2.getSalary());
                    }

                    @Override
                    public boolean equals(Object obj) {
                        return false;
                    }
                });
        sorted.forEach(System.out::println);
    }

    //映射
    @Test
    public void test3() {
        Stream<Employee1> stream = list.stream();
       /* stream.map(new Function<Employee1, String >() {

            @Override
            public String apply(Employee1 employee1) {
                return employee1.getName();
            }
        });*/
        Stream<String> map = stream.map(Employee1::getName);
        map.forEach(System.out::println);
    }
}
