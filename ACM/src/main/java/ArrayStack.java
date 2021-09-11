import java.util.Arrays;

/**
 * @description: 基于动态扩容的数组实现栈（也可以用链表实现栈），栈的操作比较受限，只能在栈顶push和pop元素
 * @author: lianghaohong
 * @date: 2021/9/9
 * @time: 9:51 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class ArrayStack {
    /**
     * 实现栈的数组
     */
    private String[] array;

    /**
     * 栈的当前容量
     */
    private int currentCapacity;

    /**
     * 实现栈数组的长度
     */
    private int n;

    public ArrayStack(int n) {
        this.array = new String[n];
        this.currentCapacity = 0;
        this.n = n;
    }

    /**
     * 在栈顶添加元素,需要判断是否需要扩容
     */
    public boolean push(String value) {
        // 当数组的当前容量=数组最大容量
        if (currentCapacity == n) {
            String[] newArray = Arrays.copyOf(array, 2 * currentCapacity);
            array = newArray;
        }
        array[currentCapacity] = value;
        currentCapacity++;
        return true;
    }

    /**
     * 在栈顶删除元素,返回被删除的元素
     */
    public String pop() {
        // 如果栈为空，直接返回null
        if (currentCapacity == 0) return null;
        currentCapacity--;
        return array[currentCapacity - 1];
    }

    /**
     * 打印栈
     */
    public void printStack() {
        String stack = "[";
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) { // 最后一个元素
                stack += array[i] + "]";
            } else {
                stack += array[i] + ",";
            }
        }
        System.out.println(stack);
    }

}
