import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
         List接口的特点：
                        1、有序集合
                        2、允许存储重复元素,允许多个Null
                        3、有索引，包含了一些带索引的方法，同样它也包含Collection的那8大方法，所以操作索引的时候一定要注意防止越界异常
                          (记：增加了4大带索引的增删改查方法)
                          void add(int index, E element): 将指定的元素，添加到该集合中的指定位置上。
                          E remove(int index): 移除列表中指定位置的元素, 返回的是被移除的元素。
                          E set(int index, E element):用指定元素替换集合中指定位置的元素,返回值的更新前的元素。
                          E get(int index):返回集合中指定位置的元素。
*/
public class MyList_ArrayList {
    public static void main(String[] args) {
        //JDK 1.7版本之前，创建的集合对象必须把前后的泛型都写上，List<String> list=new ArrayList<String>();
        //JDK 1.7版本之后，=后面的泛型可以省略，因为后面的泛型可以根据前面的泛型推导出来
        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add(null);
        list.add(null);
        list.add(null);

        list.add(2,"LHH"); //2号位置就是LHH，原先的2号及2号以后的元素往后移
        System.out.println(list);
        list.remove("d");
        list.remove(0);
        System.out.println(list);

    }
}
