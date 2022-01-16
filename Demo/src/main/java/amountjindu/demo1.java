package amountjindu;

import java.math.BigDecimal;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/12/9
 * @time: 7:50 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class demo1 {
    public static void main(String[] args) {
//        BigDecimal bigDecimal = new BigDecimal(0.53753454353);
//        BigDecimal bigDecimal2 = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
//        System.out.println(bigDecimal2);
//
//        System.out.println(0.1+0.2);


        String s = "han"+"\""+"ping";
        System.out.println(s);
        System.out.println(s.contains("\'") || s.contains("\""));
        System.out.println(s.replaceAll("\'",""));
    }
}
