import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2022/4/8
 * @time: 2:29 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class TestDemo {

    public static class User{
        private String name;

        public void validName(){
            if (this.name==null){
                this.name="";
            }else{
                this.name=this.name.trim();
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {

        BigDecimal bigDecimal = new BigDecimal("1.23456");
        String[] split = bigDecimal.toString().split("\\.");
        System.out.println(split[1]);

        User user = new User();
        user.setName("   xxx  ");
        System.out.println("之前："+user.getName()+user.getName().length());
        user.validName();
        System.out.println("之后："+user.getName()+user.getName().length());
    }
}
