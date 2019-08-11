package Object.Abstract;

/*
@author 黄佳豪
@create 2019-07-20-21:27
*/
public class InterfaceTransform {
    public static void main(String[] args) {
        Computer com=new Computer();
        com.work(new Flah());
        com.work(new Printer());
        //多态数组
        USB[] usbs = new USB[3];
        usbs[0]=new Flah();
        usbs[1]=new Printer();
        usbs[2]=new Flah();
        for (int i = 0; i < usbs.length; i++) {
            usbs[i].start();
            usbs[i].stop();
        }
    }
}

interface USB {
    void start();

    void stop();
}

class Computer {
    public void work(USB usb) {
        usb.start();
        usb.stop();
    }
}
class Flah implements USB {
    @Override
    public void start() {
        System.out.println("Flash start");
    }

    @Override
    public void stop() {
        System.out.println("Flash stop");
    }
}

class Printer implements USB {
    @Override
    public void start() {
        System.out.println("printer start");
    }

    @Override
    public void stop() {
        System.out.println("printer stop");
    }
}