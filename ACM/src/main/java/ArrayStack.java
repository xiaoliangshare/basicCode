
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

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

    /**
     * 指定容量的构造栈
     *
     * @param n
     */
    public ArrayStack(int n) {
        this.array = new String[n];
        this.currentCapacity = 0;
        this.n = n;
    }

    /**
     * 默认容量构造栈
     */
    public ArrayStack() {
        this.array = new String[1000];
        this.currentCapacity = 0;
        this.n = array.length;
    }

    /**
     * 在栈顶添加元素,需要判断是否需要扩容
     */
    public boolean push(String value) {
        // 当数组的当前容量=数组最大容量，两倍的扩容
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
        String temp = array[currentCapacity - 1];
        currentCapacity--;
        return temp;
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

    /**
     * 练习1：表达式求值
     * 思路：定义两个栈，一个存操作数子，一个存操作符
     */
    public static String expressionCalculation(String expression) {
        // 1、参数校验
        if (expression == null || expression.trim().equals("")) return null;
        // 先定义两个栈，一个栈保存数字，一个栈保存操作符号
        ArrayStack num = new ArrayStack();
        ArrayStack symbol = new ArrayStack();

        // 开始遍历表达式
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) { //如果是数字,肯定直接入栈
                num.push(String.valueOf(c));
            } else {
                String curOperation = String.valueOf(c); // 将char-->String
                // 如果是操作符先比较优先级，再看要不要入栈
                if (symbol.currentCapacity == 0) { //如果栈为空就直接入栈
                    symbol.push(curOperation);
                } else {
                    // 如果当前符号是 ")"  必须取出符号来进行运算,一直pop到 "(" 才停止运算
                    if (curOperation.equals(OperationEnum.parentheses_right.getName())) {
                        String popOperation = symbol.pop();
                        if (popOperation == null) {
                            throw new RuntimeException("计算异常");
                        }
                        while (!popOperation.equals(OperationEnum.parentheses_left.getName())) {
                            String num1 = num.pop(); //上面元素
                            String num2 = num.pop(); //下面元素
                            String result = calculate(num1, num2, popOperation);
                            if (result != null) {
                                num.push(result);
                            }
                            popOperation = symbol.pop();
                        }
                        continue;
                    }
                    // 从符号栈中取栈顶的一个元素来比
                    String popOperation = symbol.pop();
                    // 如果权重<=栈顶操作符，需要取数进行运算
                    while (Objects.nonNull(popOperation) && OperationEnum.getWeightByName(curOperation) <= OperationEnum.getWeightByName(popOperation)) {
                        String num1 = num.pop(); //上面元素
                        String num2 = num.pop(); //下面元素
                        String result = calculate(num1, num2, popOperation);
                        if (result != null) {
                            num.push(result);
                        }
                        popOperation = symbol.pop();
                    }
                    // 如果权重>栈顶操作符,直接
                    if (popOperation != null) {
                        symbol.push(popOperation); //因为刚才pop出来了，现在得push回去
                    }
                    symbol.push(curOperation);
                }
            }
        }
        // 遍历完整个表达式之后需要清空两个栈，此时只会有一个操作符号在
        if (symbol.currentCapacity == 1) {
            String popOperation = symbol.pop();
            String num1 = num.pop(); //上面元素
            String num2 = num.pop(); //下面元素
            String result = calculate(num1, num2, popOperation);
            if (result != null) {
                num.push(result); //这里存的最后一个值就是表达式的结果
            }

        }
        return num.pop();
    }

    /**
     * 判断表达式是否合法，此处只判断括号是否合法
     * 判断条件有：
     * 1，左括号与右括号个数相同
     * 2，两个运算符不可以相邻
     * 3，两个数字不可以相邻
     * 4，运算符的左边不可以是左括号，右边不可以是右括号。【如： （+ 或 +）】
     * 5，右括号不可以在第一个位置，左括号不可以在最后一个位置。【如：）x（】
     * 6，一对括号中间不能为空且必须为合法的表达式【如：（）】
     *
     * @param expression
     * @return
     */
    public static boolean isLegal(String expression) {
        // String expression="([{}])";
        if (expression == null || expression.trim().equals("")) return true;
        ArrayStack stack = new ArrayStack();
        for (int i = 0; i < expression.length(); i++) {
            // 拿到这个表达式之后
            String s = expression.substring(i, i + 1);
            Integer code = KuohaoEnum.getCodeByName(s);
            // 是左括号
            if (code != null && code < 5) {
                stack.push(s);
                // 如果是右括号则将栈顶元素pop出来
            } else if (code != null && code > 5) {
                String pop = stack.pop();
                if (pop != null) {
                    if (KuohaoEnum.getCodeByName(pop) + KuohaoEnum.getCodeByName(s) == 10) {
                        // 说明此时是合法的，然后继续遍历下一个元素
                        continue;
                    } else {
                        // 此时即可认为不合法
                        return false;
                    }
                }
            }
        }
        // 遍历完成之后，如果合法则栈内没有元素，否则不合法
        if (stack.currentCapacity == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 计算两个操作数的结果
     *
     * @param num1      上面
     * @param num2      下面
     * @param operation 操作符号
     * @return
     */
    public static String calculate(String num1, String num2, String operation) {
        if (num1 == null || num2 == null || operation == null) return null;
        switch (operation) {
            case "+":
                return String.valueOf(new BigDecimal(num2).add(new BigDecimal(num1)).setScale(2, BigDecimal.ROUND_HALF_UP));
            case "-":
                return String.valueOf(new BigDecimal(num2).subtract(new BigDecimal(num1)).setScale(2, BigDecimal.ROUND_HALF_UP));
            case "*":
                return String.valueOf(new BigDecimal(num2).multiply(new BigDecimal(num1)).setScale(2, BigDecimal.ROUND_HALF_UP));
            case "/":
                return String.valueOf(new BigDecimal(num2).setScale(2, BigDecimal.ROUND_HALF_UP).divide(new BigDecimal(num1), BigDecimal.ROUND_HALF_UP));
            default:
                System.out.println("未知的操作符,请验证表达式中操作符的正确性！");
                return null;
        }
    }

}
