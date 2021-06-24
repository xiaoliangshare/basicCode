package SerializeIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/*
        ObjectInputStream extends InputStream: 对象的反序列化流
        使用前提：
                 1、实体类必须实现Serializable接口
                 2、必须存在类对应的class文件

        构造方法：
                public ObjectInputStream(InputStream in) ： 创建一个指定InputStream的ObjectInputStream。

        反序列化操作1：如果能找到一个对象的class文件，我们可以进行反序列化操作，调用 ObjectInputStream 读取对象的方法：
                       public final Object readObject () : 读取一个对象。
        反序列化操作2：另外，当JVM反序列化对象时，能找到class文件，但是class文件在序列化对象之后发生了修改，那么反序列化
                       操作也会失败，抛出一个 InvalidClassException 异常。
                       发生这个异常的原因如下：
                          1、该类的序列版本号与从流中读取的类描述符的版本号不匹配
                          2、该类包含未知数据类型
                          3、该类没有可访问的无参数构造方法
                       解决方案是：
                            你这个实体类在序列化之后就别再去改它了，哪怕是把age属性改成public都不行。
                            (★★★★★)可以改实体类，但是得手动加上一个序列号：private static final long serialVersionUID = 1L;


        Serializable 接口给需要序列化的类，提供了一个序列号。 serialVersionUID 该版本号的目的在于验证序列化的对象和对应类是否版本匹配。
*/
public class ObjectInputStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(
                new FileInputStream("day09_BufferIO\\src\\SerializeIO\\person.txt"));
        //反序列化方法,会多抛出一个ClassNotFoundException异常
        //Object o=ois.readObject();
        Person p=(Person) ois.readObject();
        ois.close();
        System.out.println(p);
    }
}
