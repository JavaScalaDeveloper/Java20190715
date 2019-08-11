package Collection.SetAPI;//改下包名

import java.util.HashSet;

/*经典 面试题


@author 黄佳豪
@create 2019-07-26-9:39
*/
public class Homework2 {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        Person p1 = new Person(1001, "AA");
        Person p2 = new Person(1002, "BB");

        set.add(p1);
        set.add(p2);
        p1.name = "CC";
        set.remove(p1);//先将待删除的元素的哈希值（p1：1001 cc的值发生了变化，索引也发生了变化）
        System.out.println(set); //[Person id=1002, name='BB, Person id=1001, name='CC]
        set.add(new Person(1001, "CC"));//将待添加元素1001CC的哈希值获取，不一定与p1相同，添加成功
        System.out.println(set);//[Person id=1002, name='BB, Person id=1001, name='CC, Person id=1001, name='CC]
        set.add(new Person(1001, "AA"));//也能添加上
        System.out.println(set);//[Person id=1002, name='BB, Person id=1001, name='CC, Person id=1001, name='CC, Person id=1001, name='AA]

    }
}

class Person {
    int id;
    String name;

    @Override
    public String toString() {
        return "Person " +
                "id=" + id +
                ", name='" + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        return name != null ? name.equals(person.name) : person.name == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);



        return result;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}