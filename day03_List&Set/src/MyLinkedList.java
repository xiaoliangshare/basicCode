import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
       LinkedList：基于双向链表实现，查询慢，增删快，包含了大量操作首尾元素的方法,无索引
                   (注意：使用它里面特有的方法，不能使用多态)
                   public void addFirst(E e) :将指定元素插入此列表的开头。
                   public void addLast(E e) :将指定元素添加到此列表的结尾。    该方法等效于add()
                   public E getFirst() :返回此列表的第一个元素。
                   public E getLast() :返回此列表的最后一个元素。
                   public E removeFirst() :移除并返回此列表的第一个元素。
                   public E removeLast() :移除并返回此列表的最后一个元素。
                   public E pop() :从此列表所表示的堆栈处弹出一个元素。        该方法等效于removeFirst()
                   public void push(E e) :将元素推入此列表所表示的堆栈。       该方法等效于addFirst()
                   public boolean isEmpty() ：如果列表不包含元素，则返回true。
*/
public class MyLinkedList {
    public static void main(String[] args) {
        LinkedList<String> linked=new LinkedList<>();
        List<String> linked2=new LinkedList<>();
        //linked2.addFirst("s");
        linked.add("a");
        linked.add("b");
        linked.add("c");
        linked.add("d");
        linked.addFirst("LHH");
        linked.push("WWW");
        System.out.println(linked);

        //遍历LinkedList，用增强for或者迭代器
        for(String s:linked){
            System.out.println(s);
        }
        Iterator<String> it = linked.iterator();

    }
}
