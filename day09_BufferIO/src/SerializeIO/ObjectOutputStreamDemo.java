package SerializeIO;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
       ObjectOutputStream extends OutputStream： 它是一个字节流
       把对象以流的形式写入到文件中保存，叫写对象，也叫对象的序列化。
       对象中包含的不仅仅是字符，所以是使用字节流
       构造方法：
                public ObjectOutputStream(OutputStream out)： 创建一个指定OutputStream的ObjectOutputStream。
       写出对象方法：
                public final void writeObject (Object obj): 将指定的对象写出。
*/
public class ObjectOutputStreamDemo {
    public static void main(String[] args) throws IOException{
        ObjectOutputStream oos=new ObjectOutputStream(
                new FileOutputStream("day09_BufferIO\\src\\SerializeIO\\person.txt"));

        //调用写出对象方法writeObject()
        oos.writeObject(new Person("梁浩宏",24));//person.txt里面的文件因为是二进制数据，所以我们看不懂，不要管它
        oos.close();
    }
}
