package Object.OverLoad;


/*
@author 黄佳豪
@create 2019-07-18-20:27
*/
public class VarArgs {
    public static void main(String[] args) {
        GetSum s = new GetSum();
        int sum = s.sum(1, 3, 5,4,5,3,4,5);
        System.out.println(sum);
    }
}

class GetSum {
    public int sum(int... a) {//jdk5新特性，等价于int[],可变形参必须放后面
        //将可变参数当数组使用
        int sum=1;
        for (int i = 0; i < a.length; i++) {
            sum *= a[i];
        }
        return sum;
    }
}
