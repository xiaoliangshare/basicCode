package SerializableDemo;

import java.io.*;
import java.util.Date;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/11/18
 * @time: 7:40 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class SerializableDemo1 {

    //反序列化
    public static void fanxulie() throws Exception {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Demo/src/main/java/SerializableDemo/person.txt"));
        Person person = (Person) objectInputStream.readObject();
        System.out.println(person);

    }

    // 序列化
    public static void xuliehua() throws Exception{
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Demo/src/main/java/SerializableDemo/person.txt"));
        Person person = new Person("LHH", 25, new Date(),new Chinaese());

        //将文件序列化到 person.txt文件
        objectOutputStream.writeObject(person);
    }
    public static void main(String[] args) throws Exception {
        //xuliehua();
        fanxulie();



    }
}
