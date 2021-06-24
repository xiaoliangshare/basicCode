package com.hh;


//以后定义一个entity类需要定义4个东西：字段，有参和无参构造方法，get和set方法，toString()/equals() & hashCode()
public class Person {
    private String name;
    private int age;

    //有参和无参构造方法
    Person(){}
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    //重写toString()
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //重写equals()
    @Override
    public boolean equals(Object obj) {
        if(obj==null || this.getClass()!=obj.getClass()) return false;//如果对象为空或者对象不是同一个类型
        if (this==obj) return true;//如果是同一个对象

        //如果obj与this是同一种对象类型
        Person pObj=(Person) obj;
        return this.name.equals(pObj.name) && age==pObj.age;
    }
    //重写hashCode()
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }
}
