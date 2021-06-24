package SerializeIO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
       需求：前面我们已经知道可以将一个对象序列化，现在我们需要将多个对象进行序列化
       分析：把这多个对象存储到集合中(ArrayList)，对集合进行序列化即可。
*/
public class SerializePractice {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serializePerson();
        reserializePerson();
    }

    //反序列化多个对象
    private static void reserializePerson() throws IOException,ClassNotFoundException{
        ObjectInputStream ois=new ObjectInputStream(
                new FileInputStream("day09_BufferIO\\src\\SerializeIO\\personList.txt"));
        List<Person> list = (List<Person>)ois.readObject();//读到的是一个集合
        ois.close();

        for(Person p:list){
            System.out.println(p);
        }



    }

    //序列化多个对象
    private static void serializePerson() throws IOException{
        List<Person> list=new ArrayList<>();
        list.add(new Person("LHH",24));
        list.add(new Person("PP",25));
        list.add(new Person("BB",3));

        ObjectOutputStream oos=new ObjectOutputStream(
                new FileOutputStream("day09_BufferIO\\src\\SerializeIO\\personList.txt"));
        //序列化方法
        oos.writeObject(list);
        oos.close();
    }

}
