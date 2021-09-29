import java.util.HashMap;
import java.util.Map;

/**
 * @description: 数据结构三大操作：排序，递归，二分查找-----递归
 * 递归问题的解法:
 * 1、明确数据规模n
 * 2、从最小的数据规模开始递推，即当n=1/n=2开始寻找递推公式，此时也相当于在找终止条件，递推公式
 * 3、翻译为递归代码
 * @author: lianghaohong
 * @date: 2021/9/29
 * @time: 3:45 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class Recursion {

    /**
     * 青蛙跳台阶问题，青蛙一次只能跳1步/2步，跳上n阶台阶有多少种跳法
     * <p>
     * 解决1方法
     *
     * @param n 台阶的阶数：即数据规模的大小
     * @return 青蛙跳上n阶台阶的部署
     */
    public static int maxDepth = 1000;
    public static int jumped(int n) {
        maxDepth++;
        if (maxDepth > 1000)
            throw new RuntimeException("递归深度太大,不适合用递归");
        // 第一步：写循环的推出条件
        if (n == 1) return 1;
        if (n == 2) return 2;

        // 第二步：根据递推公式返回结果
        return jumped(n - 1) + jumped(n - 2);
    }

    /**
     * 青蛙跳台阶问题，解决2方法
     *
     * @param n
     * @return
     */
    // key: n, value: f(n)
    public static Map<Integer, Integer> map = new HashMap<>(); // 必须要放在外面，如果放在里面，每次递归都会new一个map，容易出错
    public static int jumped2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        // 递归之前先检查有没有在备忘录里，如果在直接返回
        if (map.containsKey(n)) {
            return map.get(n);
        }
        // 如果不在，则进行递归，并把递归的结果存进备忘录
        int fn = jumped2(n - 1) + jumped2(n - 2);
        map.put(n, fn);
        return fn;
    }

    public static void main(String[] args) {
        System.out.println(String.format("青蛙跳上[%s]阶台阶有%s种跳法", 30, jumped2(30)));
        /**
         * 问题：如果递归的深度太深，可能出现StackOverflowError问题，这是系统级错误，非常严重
         * 解决1：通过设置递归的最大深度来限制递归，例如我设置当递归深度为1000就直接抛出异常，不再进行递归了
         * 解决2：可以使用备忘录的方式，即：hashMap
         * 解决3：动态规划，未完待续。。。
         */

    }
}
