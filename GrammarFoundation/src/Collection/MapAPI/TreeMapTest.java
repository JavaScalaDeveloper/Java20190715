package Collection.MapAPI;

import org.junit.Test;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
@author 黄佳豪
@create 2019-07-25-16:16
使用HashMap添加几个员工对象，要求键：员工
值：员工工资

并遍历显示工资>18000的员工

员工类：姓名、工资、编号
要求：姓名和编号一样的员工为同一个员工！！

*/
public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<Object, Object> tm = new TreeMap<>();
        tm.put(new Employee("zs", 1000),1234);
        tm.put(new Employee("ls", 1230),1250);
        tm.put(new Employee("ww", 1234),2010);
        tm.put(new Employee("zl", 1314),1937);
        tm.put(new Employee("wq", 2019),1110);
        tm.put(new Employee("zs", 1000),1024);
        Set<Map.Entry<Object, Object>> entries = tm.entrySet();
        //遍历
        for (Object Object : entries) {
            Map.Entry entry = (Map.Entry) Object;
            System.out.println(entry.getKey().toString()+"\tsalary is "+entry.getValue());
        }


    }
}

class Employee implements Comparable{
    private String name;
    private int id;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public Employee(String name, int salary) {
        this.name = name;
        this.id = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public int compareTo(Object o) {//根据id排序
        Employee e= (Employee)o;
        if (this.id > e.id) {
            return 1;
        } else if (this.id < e.id) {
            return -1;
        }
        return Double.compare(this.id,e.id);
    }
}