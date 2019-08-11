package Object.Method;

/*
@author 黄佳豪
@create 2019-07-18-19:32
*/
public class MethodUtils {
    public static void main(String[] args) {
        MethodDemo1 m = new MethodDemo1();
        String[] arr = {"asgf", "djg", "这题呢"};
        m.printArr(arr);
        Animal a = new Animal();
        a.color = "white";
        m.judgeColor(a);
    }
}

class MethodDemo1 {
    public void printArr(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");

        }
    }

    public void judgeColor(Animal animal) {
        if (animal.color.equals("white")) {
            System.out.println("baise");

        } else if (animal.color.equals("yello")) {
            System.out.println("huangse");
        } else {
            System.out.println("caise");
        }
    }
}

class Animal {
    String color;
}