import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
        Set接口继承自Collection接口
                1、不允许存储重复元素，允许存储一个Null
                2、没有索引，不能使用for循环遍历

        HashSet implements Set 接口：无序集合，底层基于哈希表结构(即HashMap：数组+链表/红黑树，查询的速度非常快),允许一个null值
        去重的原理：在调用add()方法的时候会调用hashCode()，如果hash值相同再调用equals(),如果还相同则说明是相同对象，则去重
                    如果不同，则将该对象挂到该hash值对应的链表下。（去重也是解决hash冲突的过程）
                    8大基本数据类型都重写了hashCode()和equals(),所以可以做到去重；

                    数组存的是hash值，链表存的就是对象；
*/
public class MySet_HashSet {
    public static void main(String[] args) {
        Set<Integer> set=new HashSet<>();
        set.add(1);
        set.add(3);
        set.add(2);
        set.add(1);
        set.add(null);
        set.add(null);
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()){
            Integer num = it.next();
            System.out.println(num); //1  2  3
        }
    }
}
