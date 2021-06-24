import entity.People;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
/*
       1. Map
                1.1 特点：以键值对的形式添加元素，key不能重复，value值可以重复
                          它没有继承Collection接口
                1.2 遍历
                    1.2.1 先取出保存所有键的Set,再遍历Set即可(2种)
                    1.2.2 先取出保存所有Entry的Set,再遍历此Set即可
       2. HashMap与Hashtable之间的区别
               HashMap非同步,线程不安全 / Hashtable同步 线程安全  同步既排队（同步就意味着单线程）
               HashMap初始化默认大小16，自增为2n / HashTable默认初始值为11，加载因子为0.75，自增为2n+1
               HashMap只允许一条记录的键为null
               TreeMap不允许键为null
               HashTable不允许键为null，put进的键值只要有一个null，直接抛出NullPointerException。

        Map接口的三大实现类：
                1. HashMap：无序集合，数据存入顺序和取出顺序不一致
                          JDK 1.8之前(~JDK 1.7)：底层基于  数组+链表实现
                          JDK 1.8之后：底层基于  数组+链表/红黑树实现

                          1.1：LinkedHashMap extends HashMap：有序集合，数据存入顺序和取出顺序一致
                                  底层基于 数组+链表/红黑树+链表(保证迭代顺序)，记：就是多了一条链表保证有序
                2. Hashtable: 底层基于 数组+链表实现，但没有转红黑树减少搜索时间这种机制
                3. ConcurrentHashMap：相比HashMap多了线程安全，底层也是基于  数组+链表/红黑树实现
                          JDK 1.8之前：Segment分段锁实现线程安全
                          JDK 1.8之后：取消了Segment分段锁，采用CAS和synchronized来保证并发安全

         HashMap的常用方法：
                public V put(K key, V value): 把指定的键与指定的值添加到Map集合中。
                public V remove(Object key): 把指定的键所对应的键值对元素在Map集合中删除，返回被删除元素的值。
                public V get(Object key)： 根据指定的键，在Map集合中获取对应的值。
                public boolean containsKey(Object key): 判断集合中是否包含指定的键
                public Set<K> keySet(): 获取Map集合中所有的键，存储到Set集合中。
                public Set<Map.Entry<K,V>> entrySet(): 获取到Map集合中所有的键值对对象的集合(Set集合)。

*/
public class MyMap {
    public static void main(String[] args) {
        /*
          HashMap在put键值对的时候
              如果key不重复，返回值V是null
              如果key重复，会使用新的value替换被重复的value，并返回被替换的value值
              但是一般put操作不用接收返回值。
         */
        Map<String,Integer> map=new HashMap<>();
        Integer a = map.put("a", 10);
        System.out.println(a);//null

        map.put("b",20);
        Integer c = map.put("a", 20);
        System.out.println(c);//10
        System.out.println(map);//{a=20, b=20}

        boolean b = map.containsKey("a");
        boolean b1 = map.containsValue(12);
        System.out.println(b);
        System.out.println(b1);

        //遍历map对象的方式：keySet()和entrySet()，再用增强for和Iterator来遍历
        Set<String> key = map.keySet();
        Iterator<String> it = key.iterator();
        for(String k:key){
            Integer i = map.get(k);
            System.out.println(i);
        }
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry:entries){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }

        savePeople();
        savePeople1();
    }

    /*
        用HashMap存储自定义类型，由于Map集合必须保证键唯一，所以作为key的元素必须重写hashCode()和equals()
        <String,People>
    */
    public static void savePeople(){
        Map<String, People> map=new HashMap<String,People>();
        map.put("北京",new People("a",20));
        map.put("上海",new People("b",12));
        map.put("广州",new People("c",15));
        map.put("北京",new People("d",8));

        for(String key:map.keySet()){
            People people = map.get(key);
            System.out.println(key+"="+people);
        }
    }

    //<People,String> People类必须重写hashCode()和equals()保证Map集合的键唯一
    public static void savePeople1(){
        Map<People,String> map=new HashMap<>();
        map.put(new People("a",19),"北京");
        map.put(new People("b",19),"上海");
        map.put(new People("c",19),"广州");
        map.put(new People("a",19),"深圳");//去重
        for(Map.Entry<People,String> entry:map.entrySet()){
            System.out.println(entry.getKey()+"=="+entry.getValue());
        }
    }
}
