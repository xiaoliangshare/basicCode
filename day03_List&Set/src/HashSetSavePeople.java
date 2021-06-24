import entity.People;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*
        HashSet存储自定义类型元素：
                由于我们使用的8大数据类型(String,Integer...)，他们都重写了hashCode()和equals()，可以去重

        要求：自定义People类，同名同年龄的人视为同一个人，只能存储一次
             必须重写hashCode()和equals()才能做到
*/
public class HashSetSavePeople {
    public static void main(String[] args) {
        Set<People> set=new HashSet<>();
        People p=new People("LHH",24);
        People p2=new People("LHH",24);
        People p3=new People("PP",25);
        set.add(p);
        set.add(p2);
        set.add(p3);
        System.out.println(p.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(Objects.equals(p,p2));
        System.out.println(set);
    }
}
