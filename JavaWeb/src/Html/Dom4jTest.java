package Html;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * @author 黄佳豪
 * @create 2019-08-06-14:46
 */
public class Dom4jTest {
    public static void main(String[] args) throws DocumentException {
        //创建解析对象
      SAXReader r=  new SAXReader();
      //解析xml得到document对象
        Document read = r.read("D:\\Workspaces\\Java20190715\\JavaWeb\\src\\Html\\student.xml");
        //获取根标签
        Element rootElement = read.getRootElement();
        //获取所有student标签
        List<Element> stus = rootElement.elements();
        //遍历得到每一个student标签
        for (Element e : stus) {
            //获取id
            String id = e.attributeValue("id");
            System.out.println(id);
            String name = e.elementText("name");
            System.out.println(name);
            String gender = e.elementText("gender");
            System.out.println(gender);
            String adress = e.elementText("adress");
            System.out.println(adress);

        }
    }
}
