package reflex;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/7/18
 * @time: 11:36 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class ClassDemo {
    public static void main(String[] args) throws Exception {

        //获取对象的3种方式，分别对应三种阶段
        //1、Class.forName("全类名"):将字节码文件加载进内存，返回Class对象
        Class pClass = Class.forName("reflex.Person");
        System.out.println(pClass);

        //2、类名.class：通过类名的属性class获取
        Class<Person> pClass2 = Person.class;
        System.out.println(pClass2);
        //3、对象.getClass():getClass()方法在Object类中定义着
        Person person = new Person();
        Class<? extends Person> pClass3 = person.getClass();
        System.out.println(pClass3);


        System.out.println(pClass==pClass2); //true
        System.out.println(pClass==pClass3); //true
        /**
         * 结论：同一个字节码文件在一次程序运行时，只会被加载一次，上面三种3种方式获取的Class对象都是同一个
         */


        /**
         * Class对象的功能
         *      1、获取成员变量们
         *      2、获取构造方法们
         *      3、获取成员方法们
         */
        Field[] fields = pClass.getFields();
        for(Field field:fields){//只能获取public类型的成员变量
            System.out.println("===");
            System.out.println(field);
        }

        //不能用getField()获取name属性，因为name属性是private的,getField()只能获取public的属性
        //Field name1 = pClass.getField("name");
        //System.out.println("name1"+name1);


        //不管是否私有
        Field[] declaredFields = pClass.getDeclaredFields();
        Field name = pClass.getDeclaredField("name");
        System.out.println(name);
        //获取成员变量你想干嘛呢？肯定是set和get值，获取是能获取，但是想要使用private属性的get/set之前得先暴力反射
        name.setAccessible(true);//暴力反射
        name.set(person,"lhh");
        Object o = name.get(person);
        System.out.println(o);


        Constructor constructor = pClass.getConstructor();
        Person o1 = (Person) constructor.newInstance();
        System.out.println(o1);
        Constructor constructor1 = pClass.getConstructor(String.class, Integer.class, Date.class);
        Person o2 = (Person) constructor1.newInstance("abc", 100, new Date());
        System.out.println(o2);
        //如果使用空参数获取对象，则可以跳过构造器直接newInstance
        Person person1 = (Person) pClass.newInstance();


        //拿到eat方法之后你想干嘛？肯定是想执行方法,执行无参方法
        Method eat = pClass.getMethod("eat");
        //eat.setAccessible(true);
        eat.invoke(person);
        //执行有参方法
        Method eat1 = pClass.getMethod("eat", String.class);
        eat1.invoke(person,"鸡腿");
        Method[] methods = pClass.getMethods();
        for (Method method:methods){
            //System.out.println(method);
            if (method.getName().equals("eat"))
                System.out.println(method);
                //public void reflex.Person.eat()
                //public void reflex.Person.eat(java.lang.String)
        }
/**
 * 注意，没带getDeclaredxxx()都只能获取public类型的字段，构造器，方法
 */
    }
}
