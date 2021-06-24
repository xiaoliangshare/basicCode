import java.io.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

/*
     java.util.Properties extends Hashtable，来表示一个持久的属性集。它使用键值结构存储数据，每个键及其对应值都是一个字符串。
     该类也被许多Java类使用，比如获取系统属性时，System.getProperties 方法就是返回一个 Properties 对象。

     基本的存储方法：
              public Object setProperty(String key, String value) ： 保存一对属性。
              public String getProperty(String key) ：使用此属性列表中指定的键搜索属性值。
              public Set<String> stringPropertyNames() ：所有键的名称的集合。
     与流相关的方法：
              1、public void load(InputStream inStream) ： 从字节输入流中读取键值对。
                  文本数据格式：
                        filename=a.txt
                        length=209385038
                        location=D:\a.txt
               2、store()可以把集合中的临时数据，持久化写入到硬盘中存储
                  public void store(OutputStream out,String comments)
                  public void store(Writer writer,String comments)
                       参数：
                            OutputStream out：字节输出流，不能写人中文
                            Writer writer：字符输出流，可以写中文
                            String comments：注释，用来解释说明保存的文件是做什么用的，注释不能使用中文，会产生乱码，一般使用""空串


*/
public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        Scanner input=new Scanner(System.in);
        //propertiesLoad();
        propertiesStore();
    }

    private static void propertiesStore() throws IOException {
        Properties properties=new Properties();
        properties.setProperty("a","1");
        properties.setProperty("b","2");
        properties.setProperty("梁浩宏","3");
        //把上面的数据写出到store.txt文件, 上述有中文，会出现乱码，得用字符流
        /*FileOutputStream fos=new FileOutputStream("day08_IO\\src\\store.txt");
        properties.store(fos,"save data");
        fos.close();*/

        FileWriter fw=new FileWriter("day08_IO\\src\\store.txt");
        properties.store(fw,"save data");
        fw.close();

    }

    private static void propertiesLoad() throws IOException {
        Properties properties=new Properties();
        properties.setProperty("LHH","宜春");
        properties.put("PP","NMG");//也可以用
        System.out.println(properties.getProperty("LHH"));
        properties.load(new FileInputStream("day08_IO\\src\\Properties.txt"));
        System.out.println(properties);
        Set<String> keys = properties.stringPropertyNames();
        for(String key:keys){
            System.out.println(key+"---"+properties.get(key));//这个 Object get(Object o) 也可以用
        }
    }
}
