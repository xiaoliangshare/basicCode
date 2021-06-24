import java.util.ArrayList;
import java.util.List;

/*
      java.util.stream.Stream<T>是一个普通接口（不是函数式接口）：public interface Stream<T>
      记：Stream流就是用来简化集合和数组的操作, 我们可以把集合或数组转化为Stream流，再使用Stream流中的方法进行操作可以简便很多。
          Stream流和IO流完全是两个概念，IO流主要是用来读写

      使用传统的方式，遍历集合，对集合中的数据进行过滤
      使用Stream流的方式，遍历集合，对集合中的数据进行过滤
      Stream流是JDK 1.8之后出现的，关注的是做什么，而不是怎么做
*/
public class StreamDemo {
    //传统方法遍历集合
    public static void traditionFun(){
        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("za");
        list.add("lllla");
        list.add("za");

        //以"z"开头
        List<String> zhang=new ArrayList<>();
        for (String s:list){
            if(s.startsWith("z")){
                zhang.add(s);
            }
        }
        //长度大于3
        List<String> upThree=new ArrayList<>();
        //以"a"结尾的，再循环一遍list
        //其他要求，再循环一遍list
        // ...
    }


    //使用Stream流的方式
    public static void StreamFun(){
        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("za");
        list.add("zlllla");
        list.add("za");
        list.stream().forEach(
                item->{
                    System.out.println(item);
                }
        );

        list.stream().filter(name->{
            return name.startsWith("x");
        });

        list.stream()
                .filter(name->name.startsWith("z"))
                .filter(name->name.length()>3)
                .forEach(name-> System.out.println(name));
    }
    public static void main(String[] args) {
        //traditionFun();
        StreamFun();
    }
}
/**
 @Test
 void beanLoads(){
 List<String> list = new ArrayList<>();
 list.add("china");
 list.add("japan");
 list.add("love");
 list.add("hate");
 list.add("handsome");
 list.add("cry");
 String result = list.stream().filter(word->word.startsWith("c"))//这里过滤是和List类型有关系的
 .map(record->{
 return "<"+record+">";//过滤后加入<>
 })
 .collect(Collectors.joining(","));//以逗号分隔
 System.out.println(result);
 }
 输出结果：
 <china>,<cry>

 */