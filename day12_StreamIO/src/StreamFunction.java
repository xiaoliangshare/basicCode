import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/*
       Stream流的常用方法：
            1、void forEach(Consumer<? super T> action); 用来遍历流中的数据，是一个终结方法
                 方法的参数是一个函数式接口Consumer
            2、Stream<T> filter(Predicate<? super T> predicate); 用于对Stream流中的数据进行过滤，是一个延迟方法
                 方法的参数是一个函数式接口Predicate
*/
public class StreamFunction {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("faa", "gawb", "cgear", "dfff", "fffe", "fgggg");
        stream.forEach(name-> System.out.println(name));

        //因为filter方法依然返回一条流水线，所以一般需要配合forEach方法
        Stream<String> stream1 = stream.filter(name -> name.startsWith("f"));
        stream1.forEach(name-> System.out.println(name));
        //注意每个stream只能调用一次方法，下面在用stream就不行了，因为stream在第16行已经使用过了：stream has already been operated upon or closed
        stream.forEach(name-> System.out.println(name));
    }
}
