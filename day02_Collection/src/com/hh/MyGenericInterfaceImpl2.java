package com.hh;
/*
      （推荐）实现泛型接口的第二种方式：接口使用什么泛型，实现类就使用什么泛型，类跟着接口走，相当于定义了一个含有泛型的类
                类似于: public interface List<E>{
                            boolean add(E e);
                            E get(int index);
                        }
                        public class ArrayList<E> implements List<E>{
                            boolean add(E e){}
                            E get(int index){}
                        }
*/
public class MyGenericInterfaceImpl2<I> implements MyGenericInterface<I> {
    @Override
    public void method(I i) {
        System.out.println(i);
    }
}

class Demo2{
    public static void main(String[] args) {
        //String
        MyGenericInterfaceImpl2<String> gi=new MyGenericInterfaceImpl2<>();
        gi.method("LHH");

        //Integer
        MyGenericInterfaceImpl2<Integer> gi2=new MyGenericInterfaceImpl2<>();
        gi2.method(24);

    }
}
