import com.sun.xml.internal.ws.commons.xmlutil.Converter;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/7/16
 * @time: 7:32 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class xintexingTest extends TestCase {
    @Test
    public void testxintexing1(){
        Formula.method();
        Formula formula=new Formula() {
            @Override
            public double calculate(int a) {
                return a*100;
            }
        };
        System.out.println(formula.sqrt(16));
    }

    //java8新特性2：Lambda表达式
    @Test
    public void testlambdaDemo(){
        //Arrays.asList()方法没有add()和remove()方法
        List<String> strings = Arrays.asList("peter", "anna", "mike", "xenia");
        String[] s=new String[]{"peter", "anna", "mike", "xenia"};
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3));//如果想要有增删的方法可以用new ArrayList包一下
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.charAt(0)-o2.charAt(0);
                //return o1.compareTo(o2);
            }
        });
        //使用Lambda表达式
        Arrays.sort(s,(a,b)->a.compareTo(b));
        for (String str:s){
            System.out.println(str);
        }
    }

    @Test
    public void testFunctionInterface(){
        List<Integer> list = new ArrayList<>();
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

    }

}