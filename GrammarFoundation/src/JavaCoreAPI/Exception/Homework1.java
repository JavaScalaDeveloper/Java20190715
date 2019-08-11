package JavaCoreAPI.Exception;



import java.util.Scanner;

/*
@author 黄佳豪
@create 2019-07-22-17:30
实现注册信息验证

要求用户名的长度必须是3位或2位
要求密码的长度必须是6位
要求年龄必须>18并且<60

如果满足条件，则提示注册成功！否则提示异常信息

*/
@Deprecated
public class Homework1 {
    public static void main(String[] args) throws LoginException {
        Scanner input = new Scanner(System.in);
        String username;
        int password;
        int age;
        while (true) {//用户名判断
            System.out.print("username:");
            username = input.nextLine();
            if (username.length() == 2||username.length() == 3) {
                break;
            }
            //随便写的英语，勿喷
            LoginException loginException = new LoginException("username's lenght must 2 or 3!");
            System.out.println(loginException.getMessage());

        }while (true) {//密码长度判断
            System.out.print("password:");
            password = input.nextInt();
            //将int类型转换成可识别长度的string型
            if (String.valueOf(password).length()== 6) {
                break;
            }
            LoginException loginException = new LoginException("password's length must 6!");
            System.out.println(loginException.getMessage());
        }
        while (true) {//年龄判断
            System.out.print("age:");
            age = input.nextInt();
            if (age > 0 && age <= 120) {
                break;
            }
            LoginException loginException = new LoginException("age length must 0-120 years-old!");
            System.out.println(loginException.getMessage());

        }
        //输出username、password、age到控制台，实际项目中无需该操作
        System.out.println(new LoginVerivication(username,password,age));
    }

}

class LoginVerivication{
    String username;//为简化暂不进行封装
    int password;
    int age;

    public LoginVerivication(String username, int password, int age) {
        this.username = username;
        this.password = password;
        this.age = age;

    }

    @Override
    public String toString() {
        return "LoginVerivication{" +
                "username='" + username + '\'' +
                ", password=" + password +
                ", age=" + age +
                '}';
    }
}
//自定义异常
class LoginException extends Exception {
    //此处省略serialVersionUID
    public LoginException(String message) {
        super(message);
    }
}