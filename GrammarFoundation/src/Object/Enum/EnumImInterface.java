package Object.Enum;

/*
@author 黄佳豪
@create 2019-07-21-17:15
*/
public class EnumImInterface {
    public static void main(String[] args) {
        Color3[] s=Color3.values();
        for (int i = 0; i < s.length; i++) {

            System.out.println(s[i]);
        }

//        Show s1=Color3.red;
        Color3 s1 = Color3.red;
        System.out.println("\n"+s1);
        Color3.red.display();
    }
}

interface Show {
    void display();
}
enum Color3 implements Show{
    red(255, 0, 0){
        public void display() {
            System.out.println("I'm red");
        }
    }, bule(0, 0, 255), black(0, 0, 0), yellow(255, 255, 0), green(0, 255, 0);
    public int redV;
    public int greenV;

    public int blueV;

    Color3(int redV, int greenV, int blueV) {
        this.redV = redV;
        this.greenV = greenV;
        this.blueV = blueV;
    }

    @Override
    public String toString() {
        return "Color{" +
                "redV=" + redV +
                ", greenV=" + greenV +
                ", blueV=" + blueV +
                '}';
    }

    @Override
    public void display() {
        System.out.println("I'm color is:"+greenV+blueV+redV);
    }
}