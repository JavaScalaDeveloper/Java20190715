package IOStream.Homework;

import Collection.CollectionUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/*
将nums.txt文件中的内容读取出来存到集合，并排序后打印
nums.txt的格式如下

100
89
13
999
32
54
@author 黄佳豪
@create 2019-07-27-9:04
*/
public class Homework3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("GrammarFoundation\\\\src\\\\IOStream\\\\File\\1.txt"));
        String line;
        ArrayList<Integer> list = new ArrayList<>();
        while ((line = bf.readLine()) != null) {
            list.add(Integer.parseInt(line));
        }
        Collections.sort(list);
        CollectionUtils.forEach(list);
    }
}
