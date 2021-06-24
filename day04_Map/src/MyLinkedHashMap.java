import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
        LinkedHashMap extends HashMap：基于HashMap+链表实现，就是为了保证存入和取出的数据顺序一致。

*/
public class MyLinkedHashMap {
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<>();
        map.put("bb",24);
        map.put("ww",24);
        map.put("it",24);
        map.put("dd",24);
        System.out.println(map);//{bb=24, ww=24, dd=24, it=24}

        Map<String,Integer> linked=new LinkedHashMap<>();
        linked.put("bb",24);
        linked.put("ww",24);
        linked.put("it",24);
        linked.put("dd",24);
        System.out.println(linked);//{bb=24, ww=24, it=24, dd=24} 保证了有序
    }
}
