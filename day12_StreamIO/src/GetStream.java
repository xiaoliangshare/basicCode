import java.util.*;
import java.util.stream.Stream;

/*
       获取流
        java.util.stream.Stream<T>（这并不是一个函数式接口。） 获取一个流非常简单，有以下几种常用的方式：
        1、所有的 Collection 集合都可以通过 stream 默认方法获取流；
        2、Stream 接口的静态方法 of 可以获取数组对应的流。
*/
public class GetStream {
    public static void main(String[] args) {
        //把List集合转换为Stream流
        List<String> list=new ArrayList<>();
        Stream<String> stream = list.stream();

        //把Set集合转换为Stream流
        Set<String>  set=new HashSet<>();
        Stream<String> stream1 = set.stream();

        //把Map集合转换为Stream流(间接转换)
        Map<String,String> map=new HashMap<>();
        Set<String> keySet = map.keySet();
        Stream<String> stream2 = keySet.stream();
        Collection<String> values = map.values();
        Stream<String> stream3 = values.stream();
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Stream<Map.Entry<String, String>> stream4 = entries.stream();

        //把数组转换为Stream流
        String[] array = { "张无忌", "张翠山", "张三丰", "张一元" };
        //int[] array1={11,2,3,4,5}; 不能是int，必须是Integer[] array1={11,2,3,4,5};
        Stream<String> stream5 = Stream.of(array);

    }
}
