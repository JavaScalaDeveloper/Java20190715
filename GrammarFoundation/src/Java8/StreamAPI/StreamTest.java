package Java8.StreamAPI;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

/*
@author 黄佳豪
@create 2019-07-31-17:45
*/
public class StreamTest {
    List<Employee1> list;

    @Before
    public void before() {
        list=EmployeeData.getEmployees();
    }
    //筛选工资大于5000切工资逆序后的第三-四条
    @Test
    public void test1() {
        list.stream().filter(e->e.getSalary()>2000);
    }
}
