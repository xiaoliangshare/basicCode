import com.sun.xml.internal.ws.commons.xmlutil.Converter;
import junit.framework.TestCase;
import lombok.SneakyThrows;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/7/16
 * @time: 7:32 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class xintexingTest extends TestCase {
    @Test
    public void testxintexing1() {
        Formula.method();
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return a * 100;
            }
        };
        System.out.println(formula.sqrt(16));
    }

    //java8新特性2：Lambda表达式
    @Test
    public void testlambdaDemo() {
        //Arrays.asList()方法没有add()和remove()方法
        List<String> strings = Arrays.asList("peter", "anna", "mike", "xenia");
        String[] s = new String[]{"peter", "anna", "mike", "xenia"};
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3));//如果想要有增删的方法可以用new ArrayList包一下
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.charAt(0) - o2.charAt(0);
                //return o1.compareTo(o2);
            }
        });
        //使用Lambda表达式
        Arrays.sort(s, (a, b) -> a.compareTo(b));
        for (String str : s) {
            System.out.println(str);
        }
    }

    @Test
    public void testFunctionInterface() {
        List<Integer> list = new ArrayList<>();
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

    }

    @Test
    public void testFilter() {
        List<String> list = new ArrayList<>();
        list.add("LHH");
        list.add("LHH2");
        list.add("LHH3");
        String name = "LHH";
        List<String> nameList = list.stream().filter(item -> item.equals("LHH")).collect(Collectors.toList());
        System.out.println(nameList);
    }


    @Test
    public void testJoin() throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "正在执行");
                try {
                    // 模拟执行5s钟
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程执行结束");
            }
        }).start();

        System.out.println("主线程开始执行");
        System.out.println("当前执行线程名称：" + Thread.currentThread().getName());
        /**
         * t.join() 的作用是等待t线程结束，谁在等？在哪个线程里使用这句话，哪个线程就等待（main）
         * 也就是只要子线程是活的，主线程就不停的等待
         *
         * 原理是：主线程获取线程对象t的锁，调用该对象t的wait方法，类似于主-子线程直接的通信，main线程开始等待，
         *       等到t线程执行完毕退出后才会释放t锁，通知main线程可以执行了
         *
         *
         * 这句话的含义：Thread.currentThread()为main线程，里面的isAlive方法会判断main线程是否存活
         * 如果存活，则会一直等待，相当于自己等自己，永远不会停止。
         */
        Thread.currentThread().join();


        System.out.println("主线程执行结束");

    }

    @Test
    public void testDeamon() throws InterruptedException {
        Object o = new Object();
        Thread t1 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                while (true) {
                    System.out.println("守护线程开始执行");
                    System.out.println("子线程执行结束");
                }
            }
        });
        t1.setDaemon(true);
        t1.start();

        System.out.println("主线程执行开始");
        Thread.sleep(5000);
        System.out.println("主线程执行结束");

    }

    @Test
    public void testThreadPool() {

    }
}