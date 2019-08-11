package cn.hjhstudy.TeamSchedular.service;

import cn.hjhstudy.TeamSchedular.domain.*;

import java.util.Arrays;

/*
@author 黄佳豪
@create 2019-07-24-10:20
*/
public class TeamService {
    public static void main(String[] args) {


        NameListService nls = new NameListService();
        TeamService ts = new TeamService();


        try {
            ts.addMember(nls.getEmployee(1));
        } catch (Exception e) {
            System.out.println("错误原因："+e.getMessage());
        }

    }

    //属性
    private static final int MAX_MEMBERS=5;
    Programmer[] team = new Programmer[MAX_MEMBERS];
    int total=0;//实际成员个数
    private static  int counter = 1;//添加的成员的新ID


    //方法
    /**
     * 功能：返回团队中所有成员
     * @return
     */
    public Programmer[] getTeam(){
        return Arrays.copyOf(team, total);
    }
    /**
     * 功能：删除团队开发人员
     * @param tid 待删除的开发人员的TID
     */
    public void removeMember(int tid){
        //1、根据tid查找待删除的开发人员的所在位置（索引）
        int index = find(tid);
        if(index==-1)
            throw new TeamException("没有你要删除的开发人员！");

        //2、循环前移
        team[index].setState(Status.FREE);
        for(int i=index;i<total-1;i++){
            team[i] = team[i+1];
        }
        //3、最后一个实际元素置空
        team[--total] = null;
    }

    /**
     * 功能：添加员工
     * @param e 待添加的员工对象，如果添加失败，则抛出异常
     */
    public void addMember(Employee e){
//		失败信息包含以下几种：
//		–	成员已满，无法添加
        if(total>=MAX_MEMBERS)
            throw new TeamException("成员已满，无法添加");

//		–	该成员不是开发人员，无法添加
        if(!(e instanceof Programmer))
            throw new TeamException("该成员不是开发人员，无法添加");

        Programmer p = (Programmer) e;
//		–	该员已是团队成员
        if(isExists(p))
            throw new TeamException("该员已是团队成员 ，无法添加");
//		–	该员正在休假，无法添加

        if(p.getState()==Status.VOCATION)
            throw new TeamException("该员正在休假，无法添加 ");
//		–	该员工已是其他团队成员

        if(p.getState()==Status.BUSY)
            throw new TeamException("该员已是其他团队成员，无法添加 ");
        //统计现有的架构师、设计师、程序员的个数
        int as = 0;//架构师的个数
        int ds = 0;//设计师的个数
        int ps = 0;//程序员的个数
        for (int i = 0; i < total; i++) {
            if(team[i] instanceof Architect)
                as++;
            else if(team[i] instanceof Designer)
                ds++;
            else
                ps++;
        }


//		–	团队中只能有一名架构师
        if(p instanceof Architect){//如果参数是架构师
            if(as>=1){
                throw new TeamException("团队中只能有一名架构师");
            }
        }

//		–	团队中只能有两名设计师
        else if(p instanceof Designer){
            if(ds>=2){
                throw new TeamException("团队中只能有两名设计师");
            }
        }
//		–	团队中只能有三名程序员
        else if(p instanceof Programmer){
            if(ps>=3){
                throw new TeamException("团队中只能有三名程序员 ");
            }
        }


        //-------------正常添加------------

        team[total++]=p;//将新元素赋值到数组的第一个空位上
        p.setState(Status.BUSY);//修改新元素的状态
        p.setTid(counter++);//为新元素赋予TID


    }

    public int find(int tid){
        for (int i = 0; i < total; i++) {
            if(tid == team[i].getTid())
                return i;
        }
        return -1;
    }
    /**
     * 功能：查找某开发人员是否已经存在
     * @param e
     * @return
     */

    public boolean isExists(Programmer e){

        int index = find(e.getTid());
        return index!=-1;



//		for (int i = 0; i < total; i++) {
//			if(e.equals(team[i]))
//				return true;
//		}
//		return false;
    }
}
