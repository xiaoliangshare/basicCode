import javax.security.auth.callback.ConfirmationCallback;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/7/16
 * @time: 7:29 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class xintexing<F, T> {
    private F fData;
    private T tData;

    public void convertMethod(Converter<F, T> converter) {
        T tData = converter.convert(fData);
        System.out.println(tData);
    }

    public static void main(String[] args) {
//        xintexing<String, Integer> xintexing = new xintexing<>();
//        xintexing.convertMethod(Integer::new);
//        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
//        List<Integer> list2 = Arrays.asList(5,7,8);
//        List<Integer> temp = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
//
//        list1=temp;
//        System.out.println(list1);

        long startTime = System.nanoTime();
        System.out.println(startTime);
        for (int i = 0; i < 10000; i++) {
            System.out.println("i=" + i);
        }
        System.out.println("打印10000花费的时间为：" + (System.nanoTime() - startTime));



    }

}
/**
 * 返回正在运行的Java虚拟机的高分辨率时间源的当前值，以纳秒计。
 *
 * 该方法可能仅仅用于测量已经逝去的时间，并且与任何其它系统或者挂钟时间概念无关。该返回值表示从某个固定但任意的原点时间（可能在未来，所以值可能是负数）开始的纳秒数。在一个java虚拟机实例中，所有该方法的调用都使用相同的原点；其它虚拟机实例很可能使用不同的源头。
 *
 * 该方法提供了纳秒级别的精度，但是不一定是纳秒级分辨率（也就是该值改变的频率）———— 除非这个分辨率至少和currentTimeMillis()一样好，否则将不会做任何保证。
 *
 * 在跨越大于292年（2的63次方纳秒）左右的连续调用中，这个差值将不能正确地计算已经过去的时间，因为数字溢出。
 *
 * 仅仅只有当在同一java虚拟机实例中获取的两个值之间的差值被计算时，返回值才有意义。
 *
 * 例如，去测量某代码执行花费了多长时间：
 *  long startTime = System.nanoTime();
 *  //...被测量的代码...
 *  long estimatedTime = System.nanoTime() - startTime;
 *
 * 要比较两个nanoTime的值：
 *  long t0 = System.nanoTime();
 *  ...
 *  long t1 = System.nanoTime()。
 * 因为数字溢出的可能性，您应该使用"t1 - t0 < 0"，而不是"t1 < t0"（来判断它们的大小，笔者注）。
 * @return 当前正在运行的java虚拟机的高精度时间资源值，以纳秒为单位。
 * @since 1.5
 */
