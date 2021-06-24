import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/*
        LinkedHashSet extends HashSet：
                底层基于hashMap+链表，多了一条链表(记录元素的存储顺序)，保证元素有序

*/
public class MyLinkedHashSet {
    public static void main(String[] args) {
        Set<String> set=new HashSet<>();
        set.add("www");
        set.add("abc");
        set.add("abc");
        set.add("LHH");
        System.out.println(set);//[abc, www, LHH] 无序，不允许重复

        Set<String> linkedSet=new LinkedHashSet<>();
        linkedSet.add("www");
        linkedSet.add("abc");
        linkedSet.add("abc");
        linkedSet.add("LHH");
        System.out.println(linkedSet);//[www, abc, LHH] 有序，不允许重复

    }
}
