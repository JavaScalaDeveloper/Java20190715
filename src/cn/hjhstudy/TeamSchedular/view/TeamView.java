package cn.hjhstudy.TeamSchedular.view;

import cn.hjhstudy.TeamSchedular.domain.Employee;
import cn.hjhstudy.TeamSchedular.domain.Programmer;
import cn.hjhstudy.TeamSchedular.service.NameListService;
import cn.hjhstudy.TeamSchedular.service.TeamService;
import org.junit.Test;

import static cn.hjhstudy.TeamSchedular.utils.TSUtility.*;

/*
负责界面的输入输出
@author 黄佳豪
@create 2019-07-24-14:37
*/
public class TeamView {
    NameListService nls = new NameListService();
    TeamService ts = new TeamService();

    public static void main(String[] args) {
        new TeamView().enterMainMenu();
    }

    //显示公司所有的员工
    @Test
    public void showAllEmps() {
        System.out.println("--------------开发团队调度软件----------------");
        System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备\t\t\t\t");
        //调用getAllEmployees所有员工
        Employee[] employees = nls.getAllEmployee();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("-------------------------------------------");
    }

    @Test
    //主菜单
    public void enterMainMenu() {
        boolean loop = true;
        do {
            showAllEmps();
//显示菜单
            System.out.println("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择（1-4）： ");
            char key = readMenuSelection();
            switch (key) {
                case '1':
                    showAllTeam();
                    break;
                case '2':
                    add();
                    break;
                case '3':
                    delete();
                    break;
                case '4':
                    loop = exit();
                    break;
            }
        } while (loop);
    }

    //增加员工
    public void add() {
        System.out.println("--------------添加成员---------------");
        System.out.print("请输入要添加的员工ID：");
        int id = readInt();
        //根据员工id获取一个具体的员工对象
        try {
            Employee employee = nls.getEmployee(id);
            //将指定的Employee对象添加到团队
            ts.addMember(employee);
            System.out.println("添加成功！");
        } catch (Exception e) {
            System.out.println("添加失败："+e.getMessage());
        }finally {
            readReturn();
        }
    }

    //删除员工
    public void delete() {
        System.out.println("--------------添加成员---------------");
        System.out.println("请输入要删除员工的TID：");
        int tid=readInt();
        System.out.println("确定是否删除？y/n:");
        char key = readConfirmSelection();
        if (key == 'N') {
            readReturn();
        } else {
            try {
                ts.removeMember(tid);
                System.out.println("删除成功！");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }finally {
                readReturn();
            }
        }
    }

    //显示团队
    public void showAllTeam() {
        System.out.println("--------------添加成员---------------");
        System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票\t\t");
        Programmer[] team = ts.getTeam();
        for (Programmer programmer : team) {
            System.out.println(programmer.getDetails());
        }
        System.out.println("--------------------");
    }

    //退出软件
    public boolean exit() {
        System.out.println("确定要退出？Y/N:");
        char key = readConfirmSelection();

        return key != 'Y';
    }
}
