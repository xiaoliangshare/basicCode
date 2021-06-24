package SerializeIO;

import java.io.Serializable;
/*
    1、一个对象要想序列化，必须满足两个条件:
            该类必须实现 java.io.Serializable 接口， Serializable是一个标记接口，里面没有任何抽象方法，不实现此接口
            的类将不会使任何状态序列化或反序列化，会抛出 NotSerializableException。
            该类的所有属性必须是可序列化的。如果有一个属性不需要可序列化的，则该属性必须注明是瞬态的，使用transient
            关键字修饰。
    2、注意：
            被static修饰的成员变量不能被序列化
            被transient修饰的成员变量不能被序列化
            序列化操作是oos.writeObject(new Person("梁浩宏",24));
            正常被反序列化的效果就是：Person{name='梁浩宏', age=24}
            不能被反序列化的效果就是：Person{name='梁浩宏', age=0}


*/
public class Person implements Serializable{
    //以后都手动添加这个东西，就是固定的不用去改变这句话，防止反序列化发生异常
    private static final long serialVersionUID = 1L;
    private String name;
    //private transient /*static*/ int age;
    private int age;

    public void show(){
        System.out.println("======");
        System.out.println("我是在序列化之后，反序列化之前添加的方法");
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(){}
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
