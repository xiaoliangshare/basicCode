import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 单向链表，练习阶段不用封装数据结构做
 * @author: lianghaohong
 * @date: 2021/8/29
 * @time: 4:51 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class Linked {

    // 假设缓存容量为100
    int maxCapacity = 5;
    int currentCapacity = 0;

    // 定义一个空壳头节点
    public Node head = null;

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


    // 方法1：在指定元素后面插入节点x
    public void insert(Node a, Node x) {
        if (a == null) { // 如果a为null，说明x节点就是第一个节点（head节点）
            x.next = null;
            head = x;
        } else {
            x.next = a.next;
            a.next = x;
        }
    }

    // 方法2：在指定节点后面移除节点x
    public void remove(Node a, Node x) {
        if (a == null) { // 说明x节点就是head节点, 删除头节点也可以直接用 head=null
            head = head.next;
        } else {
            a.next = x.next;
        }
    }

    public void remove(Linked linked, Node x) {
        if (x == null) return; // 判断所删节点是否为空
        if (linked.head == null) return;  //判断链表是否为空
        Node temp = linked.head;
        if (temp.data == x.data) {
            // x即为头节点, 删除头节点的方式就是：head=head.next; 不能直接head=null
            linked.head = null;
        }

    }

    //方法3：查找给定值value
    public Node find(int value) {
        Node temp = head;
        while (temp != null && temp.data != value) { //防止空壳头节点以及后续遍历到最后一个节点
            temp = temp.next;
        }
        return temp;
    }

    // 方法4：按链表顺序添加具体值的元素
    public void add(int value) {
        if (currentCapacity == maxCapacity) {
            System.out.println("需要扩容处理");
            return;
        }
        Node node = new Node(value);
        if (head == null) { // 如果此时头节点为null，则插入头节点
            node.next = null;
            head = node;
        } else { //如果头节点不为null
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        currentCapacity++;
    }

    // 方法5：打印链表
    public void printLinked(Linked linked) {
        if (linked.head == null) {
            return;
        } else {
            List<Integer> list = new ArrayList<>();
            Node temp = linked.head;
            while (temp != null) {
                list.add(temp.data);
                temp = temp.next;
            }
            System.out.println(list);
        }
    }

    // 方法6：删除给定值的节点,PS: 在单链表下找一个确定值的节点，必须先定一个temp节点记录当前节点，因为后续要用来判断是否为头节点
    public void remove(int value) {
        // 需要找到值=value的节点
        Node p = head;
        if (p == null) return;
        Node temp = null;
        while (p != null && p.data != value) { //p!=null 主要为了防止节点往后走的时候出现空指针异常
            temp = p;
            p = p.next;
        }
        if (p != null) { //说明找到了要删除的节点
            if (temp == null) { //说明要删除的节点是头节点
                head = p.next;
            } else {
                temp.next = p.next;
            }
        }
    }

    // 方法7：删除给定指针的节点, PS：对于单向链表仍然需要从头开始遍历节点，找到x的前驱节点，时间复杂度: O(n)
    public void remove(Node x) {
        if (x == null) return;
        Node temp = head;
        if (temp == null) return; //空壳头节点（空链表）直接返回
        if (temp == x) { //说明x为头节点
            head = temp.next;
            return;
        }
        while (temp.next != null && temp.next != x) {// 否则会报空指针异常
            temp = temp.next;
        }
        if (temp.next != null) { //这个判断的意义很大：说明在链表中间找到的x，否则的话整个链表都没有x
            temp.next = x.next;
        }
    }

    /**
     * 方法7：实现缓存淘汰算法---LRU（最近最少使用）
     * 思路：维护一个单链表，链表的尾部存放最早访问的节点，最新访问的节点放在头节点，这种方式的缓存访问时间复杂度为O(n),
     * <p>
     * 案例：现在访问了一个数据，先去链表中找
     * 1、如果找到了则将该数据放到头节点，并将该数据节点从原来的位置删除；
     * 2、如果没找到，再看缓存是否满了
     * 如果没满，直接将该数据插入到头节点
     * 如果满了，删除尾节点，再将x节点插入到头节点
     */
    public void LRU(Linked linked, Node x) { //x是需要访问的节点
        if (x == null) return; //判断传参节点是否为空
        Node temp = linked.head;
        if (temp == null) return; //判断链表是否为空
        if (temp.data == x.data) return;  // 如果头节点的值就是要访问的x节点，则直接返回
        // 去链表中找是否存在x节点
        Node p = null; //作用也类似于哨兵的作用，用来保存temp节点的前驱节点
        while (temp != null && temp.data != x.data) {
            p = temp;
            temp = temp.next;
        }
        if (temp == null) { // 说明链表中没有x节点
            if (currentCapacity < maxCapacity) { // 如果容量没满直接将x节点插入到头节点
                x.next = head;
                head = x;
                currentCapacity++;
            } else { // 如果容量满了，则删除尾节点，再将x节点插入到头节点
                /**
                 *  此处不能直接这样删除为节点p，一定要有关联的删除，得先找到p的前驱节点m, 再用m.next=null
                 */
                Node m = linked.head;
                while (m.next != p) {
                    m = m.next;
                }
                m.next = null; //因为p此时就是尾节点
                x.next = head;
                head = x;
            }
        } else { // 说明x节点存在链表中，删除x在原来的位置，再将x节点插入到头节点
            // 如果x节点在链表中，则temp就是x，p就是x的前驱
            p.next = temp.next;
            x.next = head;
            head = x;
        }
    }

    /**
     * 方法8：链表反转1（五星推荐解法）
     *
     * @return
     */
    public Node reverseLinked(Linked linked) {
        if (linked.head == null) return null;
        Node temp = linked.head;
        // 创建一个新的链表（新的空壳头节点）
        Node newHead = null;
        while (temp != null) { //temp主要用来遍历原始链表，将遍历取出来的节点赋值给x
            Node x = temp;
            temp = temp.next; // 上面Node x=temp执行之后x和temp是一样的，对x的任何操作，temp也会跟着变，所以让temp先走,然后再操作x
            if (newHead == null) {
                // 第一次插入的头节点其实是反转之后的尾节点
                x.next = null;
                newHead = x;
            } else {
                // 一条链接语句 + 一条归位语句
                x.next = newHead;
                newHead = x;
            }
        }
        return newHead;
    }

    /**
     * 思路2：通过栈的先进后出特性，遍历链表将节点添加进栈，然后再出栈即可
     */
    public Node reverseLinked2(Linked linked) {
        if (linked.head == null) return null;
        Stack<Node> stack = new Stack<>();
        Node temp = linked.head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }// 至此将链表都已经添加进栈
        List<Node> newLinked = new ArrayList<>();
        while (!stack.isEmpty()) {
            newLinked.add(stack.pop());
        }
        return newLinked.get(0);
    }

    /**
     * 方法9：有序链表合并, medium，10%正确
     */
    public void combiningLinked() {

    }
}
/**
 * 总结：1、对于链表操作，第一件事就是链表判空（判断是否是空壳头节点），如果为空直接return
 * 2、对传参节点进行判空,如果为空直接return
 * <p>
 * 删除头节点方式：
 * 1、单向链表：head = head.next
 * 2、双向链表：head = head.next;  head.prev = null; （设置后继节点，也要设置前驱节点）
 * 刷题过程中一般会给定头节点，但也需要判断是否为空壳头节点
 */
