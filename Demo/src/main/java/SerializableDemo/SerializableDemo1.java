package SerializableDemo;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public static void xuliehua() throws Exception {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Demo/src/main/java/SerializableDemo/person.txt"));
//        Person person = new Person("LHH", 25, new Date(), new Chinaese());
        Person person = new Person("LHH", 25, new Date());

        //将文件序列化到 person.txt文件
        objectOutputStream.writeObject(person);
    }

    public static void main(String[] args) throws Exception {
//        xuliehua();
//        fanxulie();
//
//       List<Person> personList=new ArrayList<>();
//       personList.add(new Person("LHH", 25, new Date()));
//       personList.add(new Person("LHH1", 25, new Date()));
//       personList.add(new Person("LHH2", 25, new Date()));
//        System.out.println(String.format("%s====",personList.toString()));

//        System.out.println(personList.subList(0,19));

        int i = 3;
        switch (i) {
            case 1:
                System.out.println("1");
                break;
            default:
                System.out.println("default!");
            case 2:
                System.out.println("2");
                break;
//            default:
//                System.out.println("default!");
        }


    }
}
