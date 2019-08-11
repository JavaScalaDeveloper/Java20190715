package Object.ObjectArray;

/*
@author 黄佳豪
@create 2019-07-19-10:53
*/
public class ObjArrDemo {
    public static void main(String[] args) {
        Animals[] animals = new Animals[3];
        animals[0] = new Animals();
        animals[0].setName("zs");
        animals[0].setAge(12);
        animals[0].setWeight(13);
        animals[1] = new Animals();
        animals[1].setName("ls");
        animals[1].setAge(12);
        animals[1].setWeight(13);
        animals[2] = new Animals();
        animals[2].setName("ww");
        animals[2].setAge(12);
        animals[2].setWeight(13);
        for (int i = 0; i < animals.length; i++) {
            animals[i].show();
            animals[i].showGet();
        }
    }
}

class Animals {
    private String name;
    private int age;
    private int Weight;

    public void show() {
        System.out.print(name + "\t" + age + "\t" + Weight + "\t\t");

    }

    public void showGet() {
        System.out.println(getName() + "\t" + getAge() + "\t" + getWeight());
    }

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

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }
}