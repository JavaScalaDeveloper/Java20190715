package IOStream.File;

import Collection.CollectionUtils;
import org.junit.Test;

import java.io.File;

/*
@author 黄佳豪
@create 2019-07-27-15:13
*/
public class FileDemo1 {
    public static void main(String[] args) {
        File f1 = new File("file1.txt");
        System.out.println(f1.exists());
    }
    @Test
    public void test1() {
        File file = new File("D:\\");
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);

        }
//        CollectionUtils.Iterator(list);
    }
}
