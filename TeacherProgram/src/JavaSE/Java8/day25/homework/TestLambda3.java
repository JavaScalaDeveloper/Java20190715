package JavaSE.Java8.day25.homework;

import java.util.ArrayList;
import java.util.List;

import JavaSE.Java8.day25.bean.Employee;
import org.junit.Before;
import org.junit.Test;


/**
 * 定义好Employee类，包含姓名、年龄、工资、性别属性，并封装 定义一个List类，添加多个员工
 * 
 * 问题：针对定义好的员工的集合数据，有如下的一些需求，我们考虑如何完成？ 需求1：获取当前公司中员工年龄大于30的员工信息 需求2：获取公司中工资大于
 * 5000 的员工信息 需求3：获取性别为男的员工信息
 * 
 * 提示：是否可以使用Lambda表达式
 * 
 * @author liyuting
 *
 */
public class TestLambda3 {
	List<JavaSE.Java8.day25.bean.Employee> list;
	@Before
	public void before(){
		list= JavaSE.Java8.day25.bean.EmployeeData.getEmployees();
		
	}
	//进阶1：
	@Test
	public void test1() {
		
		
		List<JavaSE.Java8.day25.bean.Employee> employeeByAge = getEmployeeByAge(list);
		
		for (JavaSE.Java8.day25.bean.Employee employee : employeeByAge) {
			System.out.println(employee);
		}
		
		

	}

	// 需求1：获取当前公司中员工年龄大于30的员工信息
	public List<JavaSE.Java8.day25.bean.Employee> getEmployeeByAge(List<JavaSE.Java8.day25.bean.Employee> list) {

		List<JavaSE.Java8.day25.bean.Employee> datas = new ArrayList<>();// 用于保存过滤好的员工信息

		for (Employee employee : list) {
			if (employee.getAge() > 30) {
				datas.add(employee);
			}
		}
		return datas;

	}

	// 需求2：获取公司中工资大于 100000 的员工信息
	public List<JavaSE.Java8.day25.bean.Employee> getEmployeeBySalary(List<JavaSE.Java8.day25.bean.Employee> list) {

		List<JavaSE.Java8.day25.bean.Employee> datas = new ArrayList<>();// 用于保存过滤好的员工信息

		for (JavaSE.Java8.day25.bean.Employee employee : list) {
			if (employee.getSalary() > 100000) {
				datas.add(employee);
			}
		}
		return datas;

	}

	// 需求3：获取性别为男的员工信息

	public List<JavaSE.Java8.day25.bean.Employee> getEmployeeBySex(List<JavaSE.Java8.day25.bean.Employee> list) {

		List<JavaSE.Java8.day25.bean.Employee> datas = new ArrayList<>();// 用于保存过滤好的员工信息

		for (JavaSE.Java8.day25.bean.Employee employee : list) {
			if (employee.getSex() == '男') {
				datas.add(employee);
			}
		}
		return datas;

	}
	
	//-----------------------------------------------------------------------------
	
	//进阶2：
	
	@Test
	public void test2() {

//		需求1：获取当前公司中员工年龄大于30的员工信息
		
		List<JavaSE.Java8.day25.bean.Employee> emps1 = filterEmployees(list, t->t.getAge()>30);
//		需求2：获取公司中工资大于 100000 的员工信息
		List<JavaSE.Java8.day25.bean.Employee> emps2 = filterEmployees(list, t->t.getSalary()>100000);
//		需求3：获取性别为男的员工信息
		List<JavaSE.Java8.day25.bean.Employee> emps3 = filterEmployees(list, t->t.getSex()=='男');

	}
	
	public List<JavaSE.Java8.day25.bean.Employee> filterEmployees(List<JavaSE.Java8.day25.bean.Employee> list, MyPredicate<JavaSE.Java8.day25.bean.Employee> p){
		List<JavaSE.Java8.day25.bean.Employee> datas = new ArrayList<>();// 用于保存过滤好的员工信息

		for (JavaSE.Java8.day25.bean.Employee employee : list) {
			if (p.test(employee)) {
				datas.add(employee);
			}
		}
		return datas;
		
		
	}
}

interface MyPredicate<T>{
	boolean test(T t);
}
