/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/7/26
 * @time: 10:11 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class TryCatchDemo {
    public static void main(String[] args) {
        System.out.println(fun(-1));
        System.out.println(fun(100));
    }

    public static int fun(int num){
        int a=num;
        try{
            if (a<0){
                a++;
                return a;
            }else {
                a--;
                return a;
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
            a+=10;
            return a;
            //如果finally没有return语句，则对值的修改是无效的
        }
        //return 0; finally中的return和这里的return具有排斥性
    }

}
