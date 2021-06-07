package yun.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Yunjl
 * @create 2021-05-08 11:42
 */
public class DOM4jTest {
  @Test
  public void test1() throws DocumentException {
       // 创建一个SaxReader输入流，去读取 xml配置文件，生成Document对象
        SAXReader saxReader = new SAXReader();

        Document document = saxReader.read("src/books.xml");

        System.out.println(document);
  }

  /**
   * 读取books.xml文件，生成Book类
   */
  @Test
  public void test2() throws DocumentException {
    //1、利用流读取books.xml文件
    SAXReader reader = new SAXReader();
    Document document = reader.read("src/books.xml"); //在Junit测试中，相对路径是从模块名开始
    //2、通过Document对象获取根元素
    Element rootElement = document.getRootElement();
//    System.out.println(rootElement);
    //3、通过根元素获取book标签对象
    //elements()和element()都是通过标签名查找子元素
    List<Element> books = rootElement.elements("book");
    //4、遍历，处理每个book标签转换为Book类
    for (Element book:books) {
        //asXML()把标签对象转换为标签字符串
//      System.out.println(book.asXML());
      Element nameElement = book.element("name");
//      System.out.println(nameElement.asXML());
      //getText()可以获取标签对象中的文本内容
      String nameText = nameElement.getText();
//      System.out.println("书名为： " + nameText);

      //或者使用elementText()方法直接获取标签中的文本数据
      String priceText = book.elementText("price");
//      System.out.println("价格为： " + priceText);

      String authorText = book.elementText("author");
//      System.out.println("作者为： " + authorText);

      String snValue = book.attributeValue("sn");//获取属性值

      System.out.println(new Book(snValue,nameText,new BigDecimal(priceText),authorText));
    }
  }
}
