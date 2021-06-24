import entity.People;
import entity.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
        Collections: 集合的工具类，用来对集合进行操作
                    public static <T> boolean addAll(Collection<T> c, T... elements) :往集合中添加一些元素。
                    public static void shuffle(List<?> list) 打乱顺序 :打乱集合顺序。
                    public static <T> void sort(List<T> list) :将集合中元素按照默认规则排序(默认升序)。
                    public static <T> void sort(List<T> list，Comparator<? super T> ) :将集合中元素按照指定规则排序

                    注意：sort(List<T> list)使用的前提是:
                          被排序的集合里面的存储的元素，必须实现Comparable，重写接口中的方法
                          8大数据类型能直接用是因为它们的包装类都实现了Comparable接口，
                          而自定义的People必须也要实现Comparable接口，并且重写compareTo()
                          规则：
                                自己(this)-参数：升序
                                参数-自己：降序


                    Comparator和Comparable的区别
                          Comparable：自己(this)和别人(参数)比较，需要自己实现Comparable接口，重写比较规则compareTo()
                          Comparator: 相当于找一个第三方的裁判,规则定义和Comparable差不多
*/
public class MyCollections {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        //list.add(new entity.People("张三", 12));
        //...
        Collections.addAll(list, "a", "b", "c", "d");//如果我要添加很多个元素就不方便,就用它
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);

        Collections.sort(list);//默认升序
        System.out.println(list);

        ComparableSort();
        ComparatorSort();
        ComparatorSort1();
    }

    //此处People类必须实现Comparable接口中的compareTo()
    public static void ComparableSort() {
        List<People> listPeople = new ArrayList<>();
        listPeople.add(new People("张三", 12));
        listPeople.add(new People("李四", 18));
        listPeople.add(new People("王五", 9));
        System.out.println(listPeople);
        Collections.sort(listPeople);
        System.out.println(listPeople);
    }

    //sort(List<T> list，Comparator<? super T> )的使用：8大基本数据类型
    public static void ComparatorSort(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(20);
        list.add(12);
        list.add(24);
        System.out.println(list);
        Collections.sort(list, new Comparator<Integer>() {
            //重写比较的规则
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2; //升序排序
                // return o2-o1; //降序排序
            }
        });
        System.out.println(list);
    }

    //sort(List<T> list，Comparator<? super T> )的使用：自定义基本数据类型
    public static void ComparatorSort1(){
        List<Student> list=new ArrayList<>();
        list.add(new Student("a",18));
        list.add(new Student("b",15));
        list.add(new Student("c",24));
        list.add(new Student("d",18));
        //实现了组合排序
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //先按照年龄升序排序
                int result = o1.getAge() - o2.getAge();
                //如果年龄相同则按照姓名升序排序
                if (result==0){
                    result = o1.getName().charAt(0) - o2.getName().charAt(0);
                }
                return result;
            }
        });
        System.out.println(list);
    }
}
