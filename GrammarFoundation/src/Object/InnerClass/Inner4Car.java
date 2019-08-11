package Object.InnerClass;

/*
@author 黄佳豪
@create 2019-07-21-20:46
有一个Car类，有属性temperature（温度），车内有Air（空调）类，
 * 有吹风的功能flow，Air会监视车内的温度，如果温度超过40度则吹冷气。如果温度低于0度则吹暖气，如果在这之间则关掉空调。
 * 实例化具有不同温度的Car对象，调用空调的flow方法，测试空调吹的风是否正确
*/
public class Inner4Car {
    public static void main(String[] args) {

        Car.Air.flow(12);
        Car.Air.flow(56);
        Car.Air.flow(-4);
    }
}

class Car {
    int temperature;

    static class Air {
        public static void flow(int temperature) {
            if (temperature > 40) {
                System.out.println("leng");
            } else if (temperature >= 0) {
                System.out.println("close");
            } else {
                System.out.println("nuan");
            }
        }
    }
}

