import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

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
        BigDecimal bigDecimal=null;
        bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP);

        // 所以运行maven需要先安装jdk
    }

}
