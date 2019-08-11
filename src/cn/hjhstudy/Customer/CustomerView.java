package cn.hjhstudy.Customer;



/*
@author 黄佳豪
@create 2019-07-19-20:06
public void enterMainMenu()
用途：显示主菜单，响应用户输入，根据用户操作分别调用其他相应的成员方法（如addNewCustomer），以完成客户信息处理。

private void addNewCustomer()
	private void modifyCustomer()
	private void deleteCustomer()
	private void listAllCustomers()
用途：这四个方法分别完成“添加客户”、“修改客户”、“删除客户”和“客户列表”等各菜单功能。
	这四个方法仅供enterMainMenu()方法调用。

public static void main(String[] args)
用途：创建CustomerView实例，并调用 enterMainMenu()方法以执行程序。

*/
public class CustomerView {
    CustomerList list=new CustomerList(100);
    public static void main(String[] args) {
        CustomerView v = new CustomerView();
        v.enterMainMenu();
    }
    //主菜单
    public void enterMainMenu() {
        boolean flag=true;
        do {
            System.out.println("-------------------客户信息管理软件---------------------");
            System.out.println("                     1.添加客户");
            System.out.println("                     2.修改客户");
            System.out.println("                     3.删除客户");
            System.out.println("                     4.客户列表");
            System.out.println("                     5.退出");
            System.out.print("请选择：1-5:");
            //接收键盘输入的菜单
            char key = CMUtility.readMenuSelection();

            switch (key) {
                case '1':
                    add();break;
                case '2':
                    update();break;
                case '3':
                    delete();break;
                case '4':
                    showAllCustomer();break;
                case '5':
                    exit();
                    flag=false;
                    break;
            }
        } while (flag);
    }
//添加
    public void add() {
        System.out.print("=========修改客户===========\n");
        System.out.print("姓名：");
        String name = CMUtility.readString(8);
        System.out.print("性别：");
        char gender=CMUtility.readChar();
        System.out.print("年龄：");
        int age = CMUtility.readInt(11);
        System.out.print("电话：");
        String phone = CMUtility.readString(11);
        System.out.print("邮箱：");
        String email = CMUtility.readString(20);
        //封装Customer对象
        Customer newCustomer=new Customer(name,gender,age,phone,email);

        boolean addCustomer = list.addCustomer(newCustomer);
        if (addCustomer) {
            System.out.println("success");
        } else {
            System.out.println("false");
        }

    }
//修改
    public void update() {
        Customer customer=null;

        int no=0;
        for (; ; ) {

            System.out.print("=========修改客户===========\n请输入待修改客户编号（1-5）：");
            no = CMUtility.readInt();
            //判断客户编号是否存在

            customer = list.getCustomer(no - 1);
            if (customer != null) {
                break;
            }
            System.out.println("无法找到指定客户！");
        }
        System.out.print("姓名（"+customer.getName()+"):");
        String name = CMUtility.readString(9, customer.getName());
        System.out.print("性别（"+customer.getGender()+"）:");
        char gender=CMUtility.readChar(customer.getGender());
        System.out.print("年龄（" + customer.getAge() + "):");
        int age = CMUtility.readInt(customer.getAge());
        System.out.print("电话（" + customer.getName() + "):");
        String phone = CMUtility.readString(11, customer.getPhone());
        System.out.print("邮箱（" + customer.getName() + "):");
        String email = CMUtility.readString(11, customer.getEmail());
        //修改
        Customer newCustomer=new Customer(no,name,gender,age,phone,email);
        boolean replaceCustomer = list.replaceCustomer(no - 1, newCustomer);
        if (replaceCustomer) {
            System.out.println("修改完成");
        } else {
            System.out.println("修改失败");
        }
    }
//删除
    public void delete() {
//        System.out.println();
        int no;//待删除编号
        Customer customer;//待删除客户对象
        for (; ; ) {

            System.out.print("=========修改客户===========\n请输入待修改客户编号（1-5）：");
            no = CMUtility.readInt();
            //判断客户编号是否存在

            customer = list.getCustomer(no - 1);
            if (customer != null) {
                break;
            }
            System.out.println("无法找到指定客户！");
        }
        System.out.println("确定删除？y/n:");
        char key=CMUtility.readConfirmSelection();
        if (key == 'Y') {
            boolean deleteCustomer = list.deleteCustomer(no - 1);
            if (deleteCustomer) {
                System.out.println("success");
            } else {
                System.out.println("false");
            }
        }
    }

//显示所有
    public void showAllCustomer() {
        Customer[] allCustomers = list.getAllCustomers();
        for (int i = 0; i < allCustomers.length; i++) {
            System.out.println(allCustomers[i].toString());
        }
    }

    public boolean exit() {
        System.out.println("确认是否退出？y/n:");
        char key = CMUtility.readConfirmSelection();
        /*if (key == 'Y') {
            return false;
        } else {
            return true;
        }*/
        return (key != 'Y');
    }

}
