package cn.hjhstudy.Customer;

import java.util.Arrays;

/*
@author 黄佳豪
@create 2019-07-19-20:06
CustomerList为Customer对象的管理模块，内部用数组管理一组Customer对象
本类封装以下信息：
Customer[] customers：用来保存客户对象的数组
int total = 0                 ：记录已保存客户对象的数量
该类至少提供以下方法：
public CustomerList(int totalCustomer)
public boolean addCustomer(Customer customer)
public boolean replaceCustomer(int index, Customer cust)
public boolean deleteCustomer(int index)
public Customer[] getAllCustomers()
public Customer getCustomer(int index)

*/
public class CustomerList {
    //field初始化100个空值元素
    Customer[] customers = new Customer[10];
    int total = 1;//记录添加的位置

    /*
    用途：构造器，用来初始化customers数组
    参数：totalCustomer：指定customers数组的最大空间

     */
    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
        //赋值
        customers[0] = new Customer(1, "zs", '男', 20, "123455", "1234@qq.com");

    }

    /*
    用途：将参数customer添加组中最后一个客户对象记录之后
    参数：customer指定要添加的客户对象
    返回：添加成功返回true；false表示数组已满，无法添加
@param customer 添加客户
     */
    public boolean addCustomer(Customer customer) {
        if (total >= customers.length) {
            return false;
        }
//        customer.setId(total+1);
        customers[total++] = customer;
        customer.setId(total);
                return true;
    }

    /*
    用途：用参数customer替换数组中由index指定的对象
    参数：customer指定替换的新客户对象
                       index指定所替换对象在数组中的位置
    返回：替换成功返回true；false表示索引无效，无法替换

     */
    public boolean replaceCustomer(int index, Customer cust) {
        if (index < 0 || index > total) {
            return false;
        }
        customers[index]=cust;
        return true;
    }

    /*
    用途：从数组中删除参数index指定索引位置的客户对象记录
    参数： index指定所删除对象在数组中的索引位置
    返回：删除成功返回true；false表示索引无效，无法删除

     */
    public boolean deleteCustomer(int index) {
        if (index < 0 || index > total) {
            return false;
        }
        for (int i = index; i <total-1 ; i++) {
            customers[i] = customers[i + 1];
        }
        //最后一个元素空置
        customers[--total]=null;
        return true;
    }

    /*
    用途：返回数组中记录的所有客户对象
    返回： Customer[] 数组中包含了当前所有客户对象，该数组长度与对象个数相同。
@return 所有客户
     */
    public Customer[] getAllCustomers() {
        return Arrays.copyOf(this.customers, total);

    }

    /*
用途：返回参数index指定索引位置的客户对象记录
参数： index指定所要获取的客户对象在数组中的索引位置
返回：封装了客户信息的Customer对象

     */
    public Customer getCustomer(int index) {
        if (index < 0 || index >= total) {

            return null;
        }
        return customers[index];
    }
}
