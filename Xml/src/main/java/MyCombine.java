import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/11/23
 * @time: 6:08 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class MyCombine {
    //public static Stack<String> stack = new Stack<>();

    public static void main(String[] args) {
//        String[] a = {"1", "2", "3", "4", "5", "6", "7"};
//        String[] b = {"1", "2", "3"};
//        System.out.println(combine(b,2));

        //String[] dataArray = {"A", "B", "C"};
//        List<String> dataList=new ArrayList<>();
//        dataList.add("A");
//        dataList.add("B");
//        dataList.add("C");
//        int selectNum = 2;
//        List<String> result = new ArrayList<>();
//        List<List<String>> combine = Combine(dataList, selectNum, result, 0);
//        System.out.println(combine);

        //String[] data = {"A", "B", "C"};
        List<String> dataList=new ArrayList<>();
        dataList.add("A");
        dataList.add("B");
        dataList.add("C");
        Stack<String> stack = new Stack<>();
        combination(dataList, stack, 1, 0, 0);// 从这个数组4个数中选择三个
        //System.out.println(combination(data, stack, 1, 0, 0));
    }

    /**
     * @param data   元素
     * @param stack
     * @param target 要选多少个元素
     * @param has    当前有多少个元素
     * @param cur    当前选到的下标
     *               <p>
     * @return
     */
    private static void combination(String[] data, Stack<String> stack, int target, int has, int cur) {
        List<String> result =new LinkedList<>();
        if (has == target) {
            saveIn(new LinkedList<>(stack));
        }

        for (int i = cur; i < data.length; i++) {
            if (!stack.contains(data[i])) {
                stack.add(data[i]);
                combination(data, stack, target, has + 1, i);
                stack.pop();
            }
        }
    }

    private static void combination(List<String> data, Stack<String> stack, int target, int has, int cur) {
        if (has == target) {
            saveIn(new LinkedList<>(stack));
        }

        for (int i = cur; i < data.size(); i++) {
            if (!stack.contains(data.get(i))) {
                stack.add(data.get(i));
                combination(data, stack, target, has + 1, i);
                stack.pop();
            }
        }
    }
    private static void saveIn(LinkedList<String> list) {
        System.out.println(list);
    }


    private static List<List<String>> Combine(List<String> dataList, int selectNum, List<String> result, int low) {
        List<List<String>> temp = new ArrayList<>();
        if (selectNum == 0) {
            temp.add(result);
            System.out.print(result);
        } else {
            for (int i = low; i < dataList.size(); i++) {
                //b += a[i];
                result.add(dataList.get(i));
                Combine(dataList, selectNum - 1, result, i + 1);
                result = result.subList(0, result.size() - 1);
            }
        }
        return temp;
    }


    /**
     * 实现的算法
     *
     * @param a   数据数组
     * @param num M选N中 N的个数
     * @return
     */

    public static List<List<String>> combine(String[] a, int num) {
        List<List<String>> list = new ArrayList();

        StringBuffer sb = new StringBuffer();
        List<String> zuhe = new ArrayList<>();

        String[] b = new String[a.length];

        for (int i = 0; i < b.length; i++) {
            if (i < num) {
                b[i] = "1";
            } else
                b[i] = "0";
        }

        int point = 0;

        int nextPoint = 0;

        int count = 0;

        int sum = 0;

        String temp = "1";

        while (true) {
            // 判断是否全部移位完毕
            for (int i = b.length - 1; i >= b.length - num; i--) {
                if (b[i].equals("1"))
                    sum += 1;
            }
            // 根据移位生成数据
            for (int i = 0; i < b.length; i++) {
                if (b[i].equals("1")) {
                    point = i;
                    //sb.append(a[point]);
                    //sb.append(" ");
                    zuhe.add(a[point]);
                    count++;
                    if (count == num)
                        break;
                }
            }
            // 往返回值列表添加数据
            list.add(zuhe);

            // 当数组的最后num位全部为1 退出
            if (sum == num) {
                break;
            }
            sum = 0;

            // 修改从左往右第一个10变成01
            for (int i = 0; i < b.length - 1; i++) {
                if (b[i].equals("1") && b[i + 1].equals("0")) {
                    point = i;
                    nextPoint = i + 1;
                    b[point] = "0";
                    b[nextPoint] = "1";
                    break;
                }
            }

            // 将 i-point个元素的1往前移动 0往后移动
            for (int i = 0; i < point - 1; i++)

                for (int j = i; j < point - 1; j++) {
                    if (b[i].equals("0")) {
                        temp = b[i];

                        b[i] = b[j + 1];

                        b[j + 1] = temp;
                    }
                }
            // 清空 StringBuffer
            //sb.setLength(0);
            zuhe.clear();
            count = 0;
        }
        System.out.println("数据长度 " + list.size());
        return list;
    }
}
