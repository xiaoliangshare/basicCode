package com.hh;

/*
        泛型：可以在类或方法中预支地使用未知的类型.
        使用泛型：Collection<String> list = new ArrayList<String>();
                  1、避免了类型强转的麻烦，没有指定泛型时，默认类型为Object类型。
                  2、将运行时期的ClassCastException，转移到了编译时期变成了编译失败。
                  记：使用泛型就是指定具体的数据类型

       不使用泛型：Collection coll = new ArrayList();
                   1、没有指定泛型时，默认类型为Object类型，可以存储任意类型的数据
                   2、不安全，容易在运行的时候发生ClassCastException，你存可以存，但是运行时报异常就GG了
*/

//定义一个泛型类
public class MyGeneric<E> {

    //1、定义泛型方法: 修饰符 <代表泛型的变量> 返回值类型 方法名(参数){ }
    public <M> void method(M m){
        System.out.println(m);
    }
    //2、定义含有泛型的静态方法
    public static <S> int method2(S s){
        System.out.println(s);
        return 100;
    }

    private E field; //field字段
    public E getField() {
        return field;
    }
    public void setField(E field) {
        this.field = field;
    }
    //...
    //还可以有其他field：private E field2;    只不过这个field都是E类型的
}
//测试类
class Test{
    public static void main(String[] args) {
        //不使用泛型
        MyGeneric gc=new MyGeneric();
        gc.setField(123);
        Object field = gc.getField();
        System.out.println(field);


        //使用泛型,在创建实例化对象的时候指定具体的数据类型，如下可以是String/Integer
        MyGeneric<String> gc2=new MyGeneric<>();
        gc2.setField("LHH");
        System.out.println(gc2.getField());
        System.out.println("=================");
        MyGeneric<Integer> gc3=new MyGeneric<>();
        gc3.setField(24);
        System.out.println(gc3.getField());


        //使用泛型类中的泛型方法: 传递什么类型，泛型就是什么类型
        gc.method(1);
        gc.method("LHH");

        //直接用泛型类名.泛型方法
        MyGeneric.method2(1);
        MyGeneric.method2("LHH");


    }
}