package Object.Extend;

/*
@author 黄佳豪
@create 2019-07-19-15:15
*/
public class AnimalsDemo {
    public static void main(String[] args) {
        Tidy t1 = new Tidy();
        t1.setName("t1");
        t1.setAge(2);
        t1.setBite("human");
        t1.setSay("dog lang...");
        System.out.println(t1.toString());
    }
}


class Animal {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Dog extends Animal{
    private String bite;

    public String getBite() {
        return bite;
    }

    public void setBite(String bite) {
        this.bite = bite;
    }
}

class Tidy extends Dog{
private String say;

    public String getSay() {
        return say;
    }

    public void setSay(String say) {
        this.say = say;
    }

    @Override
    public String toString() {
        return "Tidy " +
                "say='" + say + '\'' +getBite()+getAge()+getName()+
                '.';
    }
}