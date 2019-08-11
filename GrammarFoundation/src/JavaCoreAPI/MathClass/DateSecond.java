package JavaCoreAPI.MathClass;

import java.util.Calendar;

/*第二代日期类
@author 黄佳豪
@create 2019-07-23-16:16
*/
public class DateSecond {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c.toString());
        System.out.println("year:"+c.get(Calendar.YEAR));
        System.out.println("year:"+c.get(Calendar.MONTH+1));
        System.out.println("year:"+c.get(Calendar.DAY_OF_MONTH));
        System.out.println("year:"+c.get(Calendar.HOUR));
        System.out.println("year:"+c.get(Calendar.MINUTE));
        System.out.println("year:"+c.get(Calendar.SECOND));
    }
}
