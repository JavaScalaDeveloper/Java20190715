package JavaCoreAPI.MathClass;

import org.junit.Test;

import java.awt.image.DataBufferByte;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
@author 黄佳豪
@create 2019-07-23-15:55
*/
public class DateFirst {
    @Test
    public void test1() {
        Date d1=new Date();
        System.out.println(d1);
        System.out.println(d1.getTime());

    }

    @Test//测试自定义格式
    public void DateFormat() throws ParseException {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat();
        String fm = sdf.format(d);//format date
        System.out.println(fm);//19-7-23 下午4:09
        String s = "19-7-23 下午4:09";
        Date pars = sdf.parse(s);
        System.out.println(pars);//Tue Jul 23 16:09:00 CST 2019

    }

    @Test
    public void test2() throws ParseException {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日hh小时mm分钟ss秒");
        String fm = sdf.format(d);//format date
        System.out.println(fm);//2019年07月23日04小时14分钟08秒
        String s = "2019年07月23日04小时13分钟41秒";
        Date pars = sdf.parse(s);
        System.out.println(pars);//Tue Jul 23 04:13:41 CST 2019
    }
}


