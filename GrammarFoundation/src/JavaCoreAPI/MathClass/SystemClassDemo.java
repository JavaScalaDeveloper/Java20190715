package JavaCoreAPI.MathClass;

import org.junit.Test;

/*
@author 黄佳豪
@create 2019-07-23-15:35
*/
public class SystemClassDemo {
    @Test
    public void test1() {
        //ArrayCopy
        int[] src = new int[]{1, 3, 5, 3, 7};
        int[] dest = new int[src.length];
        System.arraycopy(src,0,dest,0, src.length);
        for (int i = 0; i < dest.length; i++) {
            System.out.print(dest[i]+"\t");

        }
        System.out.println();
        //exit退出
        System.exit(0);
    }
}
