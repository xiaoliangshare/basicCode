import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2022/5/30
 * @time: 7:39 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class ListDemo {
    public static void main(String[] args) {
        List<String> ss=new ArrayList<>();
        ss.add("aa");
        ss.add("bb");
        ss.add("cc");

        List<String> ss1=new ArrayList<>();


        List<String> retList=new ArrayList<>();
        retList.addAll(ss);
        retList.addAll(ss1);

        System.out.println(retList);

    }
}
