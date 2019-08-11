package Object.StaticAndFinal;

import javax.sound.midi.Soundbank;
import java.security.PublicKey;

/*
@author 黄佳豪
@create 2019-07-20-17:38
*/
public class TeacherDemo {
    public static void main(String[] args) {
        new TeacherDemo("john");
    }

    String name;

    public TeacherDemo(String string) {
        this.name = string;
        System.out.println("构造器" + name);//3,6
    }

    static {
        System.out.println("嘿嘿");//1
    }

    static TeacherDemo t = new TeacherDemo("zhangsan");
{
        System.out.println("haha" + name);//2,5
    }

    static
    {
        System.out.println("hehe");//4
    }
}
