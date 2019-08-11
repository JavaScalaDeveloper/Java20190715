package Object.StaticAndFinal;


/*
@author 黄佳豪
@create 2019-07-21-10:33
*/
public class Interface4Jdk8 {
    public static void main(String[] args) {
        AA.method(1, 4);

        class AAA {
            class AAAA {
                class AAAAA {
                    public void method() {
                        System.out.println("内部类");
                    }
                }
            }
        }
    }
}

interface AA {

    static String method(int a, int b) {

        System.out.println("Interface static");
        return a + "\t" + b;
    }

    default void method2(String string) {
        System.out.println("defalt" + string);

    }
//内部类


}


