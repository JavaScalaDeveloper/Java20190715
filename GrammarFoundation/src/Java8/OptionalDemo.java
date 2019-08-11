package Java8;

import Object.Abstract.EmployeeDemo;

import java.util.Optional;

/*
@author 黄佳豪
@create 2019-07-31-18:46
*/
public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> of = Optional.ofNullable("zs");
        of.orElse("ls");
        System.out.println(of);
    }
}
