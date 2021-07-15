import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/7/13
 * @time: 8:56 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class Value<T> {

    /**
     * 直接在类里面写泛型方法
     */
    public <T> List<T> getValue(T key) {
        List<T> list = new ArrayList<>();
        list.add(key);
        return list;

        /*List<Integer> list = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>();
        Class strClass = list.getClass();
        Class intClass = list1.getClass();
        if (strClass.equals(intClass))
            System.out.println("我们发现虽然泛型实参不同，但是基本类型仍然是相同的");
         */
    }

    //Consumer接口的使用
    public static void create(String foodname, Consumer<String> consumer) {
        consumer.accept(foodname);

        //在main中调用这个方法
//        String foodname = "鸡腿";
//        create(foodname, new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });
    }

    public static WebResponse method(){
        return WebResponse.succ("返回成功");
    }

    //在使用泛型的时候如果你传入实参，就会根据泛型传入的实参做相应的限制，泛型才会起到本应起到的限制作用
    //这里你也可以不带泛型，但是不规范，可读性不高，就是如果我明知道需要返回的是一个user集合，我应该显示说明集合的类型
    //之所以使用泛型就是为了在编译期间就约束
    /**
     *  WebResponse<List<User>>中<>中的东西就是为了提高可读性
     */
    public static WebResponse<List<User>> method1(){
        //模拟findById()查询一个用户
        List<User> users=new ArrayList<>();
        User user=new User();
        user.setUsername("lhh");
        user.setAge(25);
        users.add(user);
        return WebResponse.succ(users);
    }
    public static void main(String[] args) {

        WebResponse webResponse = method1();
        System.out.println(webResponse.getData());

    }
}

/**
 * 总结：只要把泛型类，泛型方法，泛型接口的常用方法会使用就可以了，通配符，泛型的上下边界等了解即可
 *
 * */
