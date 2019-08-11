package Object.Annoatation;

import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

/*
@author 黄佳豪
@create 2019-07-21-20:12
*/
@SuppressWarnings("all")//用于抑制编译警告
public class AnnotationDemo1 {
}

//自定义注解
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
//元注解
@interface MyAnnotation {
    //   String default "hjh";
    String value() default "zs";

}

@MyAnnotation("zs")
enum Gender {

}