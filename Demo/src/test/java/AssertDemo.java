import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/7/18
 * @time: 10:24 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */

public class AssertDemo {
    @Test
    public void testAdd() {
        Calculate calculate = new Calculate();
        int result = calculate.add(1, 2);
        Assert.assertEquals("计算错误", 3, result);
    }

    @Test
    public void testBool() {
        boolean bool = false;
        Assert.assertTrue("您传入的值为false", bool);
        System.out.println("校验通过");
    }

    @Test
    public void testNotNull() {
        //User user = new User();
        User user = null;
        Assert.assertNotNull("您传入的对象为空", user);
        System.out.println("校验通过");
    }

    @Test
    public void testStreamMap() {
        String str = "lhh";

        List<String> strings = Arrays.asList("g", "g","g");//假设我选了三个库存组织，结果有一个为空

        Set<String> set = strings.stream().map(
                s -> {
                    String period=getPeriod(s);
                    if (Objects.isNull(period)){
                        throw new RuntimeException("库存组织期间编码不一致");
                    }
                    return period;
                }
        ).collect(Collectors.toSet());
        if (set.size()>1)
            throw new RuntimeException("库存组织期间编码不一致");
        Object o = set.toArray()[0];
        String s =set.toArray()[0].toString();
        System.out.println(s);


        //Objects.requireNonNull(strings2,"strings为空");
        //这句话的意思是我允许你为empty，但是不允许你为null，为null就会出异常
//        Optional.ofNullable(strings).orElseThrow(()->new RuntimeException("空"));
//        strings1.forEach(
//                s->System.out.println(s.charAt(0))
//        );
        //Optional.ofNullable(str).ifPresent();
        //strings.stream().map(s-> s+"lhh");
    }

    @Test
    public void testTryCatch(){
        int i=5;
        try {
            i--;
            System.out.println("i:"+i);
        }catch (Exception e){
            //log.error("msg",e);
            e.printStackTrace();
            System.exit(1);
        }finally {
            add(i);
            System.out.println("finally执行了");
        }
    }
    private int add(int a){
        return a+1;
    }
    private String getPeriod(String s) {
        return s;
    }
}
/**
 * 最终结论：任何执行try 或者catch中的return语句之前，都会先执行finally语句，如果finally存在的话。
 *         如果finally中有return语句，那么程序就return了，所以finally中的return是一定会被return的，
 *         编译器把finally中的return实现为一个warning。
 */
