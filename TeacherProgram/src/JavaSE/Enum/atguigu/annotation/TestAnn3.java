package Enum.atguigu.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author liyuting
	Retention:����ָ�������ε�ע����Ա����೤
				RententionPolicy:SOURCE  CLASS  RUNTIME
	Target������ָ�������ε�ע���������������Щ����
				ElementType:TYPE LOCAL_VARIABLE FIELD METHOD��
	Documented���ܷ������ɵİ����ĵ�����ʾ
	Inherited��ע���Ƿ�߱��̳���
 * 					
 * 
 */
@MyAnn3
public class TestAnn3 {
	@MyAnn3
	String color;
	@MyAnn3
	public static void main(String[] args) {
		
	}

}

@Documented
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnn3{
	
	
}