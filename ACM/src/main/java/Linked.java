import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 定义一个单向链表
 * @author: lianghaohong
 * @date: 2021/8/29
 * @time: 4:51 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class Linked {

    // 定义一个空壳头节点
    public Node head = null;

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
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
        Node node = new Node(value);
        if (head == null) { // 如果此时头节点为null，则插入头节点
            head = node;
            node.next = null;
        } else { //如果头节点不为null
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
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
}
