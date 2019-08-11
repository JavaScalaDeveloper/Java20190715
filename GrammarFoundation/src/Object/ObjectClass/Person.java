package Object.ObjectClass;

/*
@author 黄佳豪
@create 2019-07-20-10:08
*/
public class Person {
    public static void main(String[] args) {
        Finalize a=new Finalize();
        a=null;
        System.gc();//垃圾回收器
        System.out.println(a);
    }
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            return false;
        } else {
            return true;
        }
    }
}

class Finalize {
    public void finalize() throws Throwable{
        System.out.println("被回收了");
    }
}