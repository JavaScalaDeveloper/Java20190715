package JavaCoreAPI.MathClass;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/*
@author 黄佳豪
@create 2019-07-23-15:45
BigInteger保存数值范围更大的整数
BigDecimal保存精度更高的浮点型
*/
public class BigIntegerAndBigDecimal {
    @Test
    public void test1() {
        BigInteger b1 = new BigInteger("1243254325423");
        BigInteger b2 = new BigInteger("1243254325423");
        System.out.println(b1.add(b2));
        System.out.println(b1.subtract(b2));
        System.out.println(b1.multiply(b2));
        System.out.println(b1.divide(b2)+"\n------------------\n");
        BigDecimal c1 = new BigDecimal("1243254325423");
        BigDecimal c2 = new BigDecimal("1243254325422");
        System.out.println(c1.add(c2));
        System.out.println(c1.subtract(c2));
        System.out.println(c1.multiply(c2));
        System.out.println(c1.divide(c2,BigDecimal.ROUND_UP));//除不尽异常
    }
}
