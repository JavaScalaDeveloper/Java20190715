package JavaCoreAPI.MathClass;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/*
@author 黄佳豪
@create 2019-07-23-16:30
*/
public class DateThirdDemo {
    @Test
    public void test1() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.getYear());
        System.out.println(now.getMonth()+"\t"+now.getMonthValue());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());
        System.out.println(now.getDayOfWeek());
    }

    @Test
    public void test2() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH小时mm分钟ss秒");//固定格式
        String format = dtf.format(now);
        System.out.println(format);
        //解析日期String->Date
        LocalDateTime parse = LocalDateTime.parse("2018年07月23日10小时46分钟47秒",dtf);
        System.out.println(parse);
    }

    @Test
    public void test3() {
        Instant i = Instant.now();
        Date d = Date.from(i);
        System.out.println(d);
    }
}
