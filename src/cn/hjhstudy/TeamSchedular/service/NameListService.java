package cn.hjhstudy.TeamSchedular.service;

import cn.hjhstudy.TeamSchedular.domain.*;
import cn.hjhstudy.TeamSchedular.utils.Data;



/*用于管理公司所有的员工
@author 黄佳豪
@create 2019-07-24-10:20
*/
public class NameListService {
    public static void main(String[] args) {
        NameListService nls = new NameListService();
        for (int i = 0; i < nls.emps.length; i++) {
            System.out.println(nls.emps[i]);
        }
        //测试查找
        try {
            nls.getEmployee(13);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    Employee[] emps;//①声明

    //初始化emps数组
    public NameListService(){
        //数组使用步骤2：开辟空间
        emps = new Employee[Data.EMPLOYEES.length];


        //数组使用步骤3：初始化
        for (int i = 0; i < emps.length; i++) {

            //判断emps[i]的员工类型，根据员工类型，创建对应类型的员工对象！
            String type = Data.EMPLOYEES[i][0];
            int iD = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);
            Equipment equipment;
            switch (type) {
                case "10":
                    //创建Employee类的对象

                    emps[i] = new Employee(iD, name, age, salary);

                    break;
                case "11":
                    //创建Programmer类的对象

                    equipment  = getEquipment(i);
                    emps[i] = new Programmer(iD, name, age, salary, equipment);
                    break;
                case "12":
                    //创建Designer类的对象
                    equipment = getEquipment(i);
                    double bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    emps[i] = new Designer(iD, name, age, salary, equipment, bonus);
                    break;
                case "13":

                    //创建Architect类的对象
                    equipment = getEquipment(i);
                    double bonus2 = Double.parseDouble(Data.EMPLOYEES[i][5]);

                    double stock = Double.parseDouble(Data.EMPLOYEES[i][6]);
                    emps[i] = new Architect(iD, name, age, salary, equipment, bonus2, stock);
                    break;
            }

        }

    }

    //返回所有员工
    public Employee[] getAllEmployee() {
        return emps;
    }

    //返回员工对象
    public Employee getEmployee(int id) {
        for (int i = 0; i < emps.length; i++) {
            if (emps[i].getID() == id) {
                return emps[i];
            }
        }
        throw new TeamException("员工不存在");

    }
    private Equipment getEquipment(int i) {

        //1.获取对应设备的类型
        String type = Data.EQIPMENTS[i][0];
        switch (type) {
            case "21"://PC
                String modal = Data.EQIPMENTS[i][1];
                String display = Data.EQIPMENTS[i][2];
                return new PC(modal , display);

            case "22"://NoteBook
                String modal2 = Data.EQIPMENTS[i][1];
                double price = Double.parseDouble(Data.EQIPMENTS[i][2]);
                return new NoteBook(modal2, price);
            case "23"://Printer
                String t = Data.EQIPMENTS[i][1];
                String name = Data.EQIPMENTS[i][2];
                return new Printer(t,name);
        }
        return null;
    }
}
