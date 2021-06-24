import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/*
        Hashtable implements Map<K,V>
            Hashtable的底层是 数组+链表，是一个线程安全的集合，意味着是单线程，速度慢
            HashMap的底层是 数组+链表/红黑树，是一个线程不安全的集合，意味着是多线程，速度快

            Hashtable和Vector一样，JDK 1.2后分别被HashMap和ArrayList取代了
            Hashtable的子类Properties集合是一个唯一和IO流相结合的集合
*/
public class MyHashtable {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        map.put(null,"a");
        map.put("b",null);
        map.put(null,null);
        System.out.println(map);//{null=null, b=null}


        Map<String,String> table=new Hashtable<>();
        table.put(null,"a");
        System.out.println(table);//NullPointerException
    }
}
