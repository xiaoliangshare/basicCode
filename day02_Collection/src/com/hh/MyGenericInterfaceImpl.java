package com.hh;
/*
*   实现泛型接口的第一种方式：直接指定具体数据类型，指定之后就和普通类没什么区别了
* */
public class MyGenericInterfaceImpl implements MyGenericInterface<String>{
    @Override
    public void method(String s) {
        System.out.println(s);
    }
}
class Demo{
    public static void main(String[] args) {
        MyGenericInterfaceImpl imp=new MyGenericInterfaceImpl();
        imp.method("LHH");
    }

}