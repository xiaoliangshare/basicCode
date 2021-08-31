import org.w3c.dom.Node;

/**
 * @description: 双向链表
 * @author: lianghaohong
 * @date: 2021/8/29
 * @time: 10:11 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class DoublyLinked {
    // 空壳头节点
    public Node head = null;

    // 节点类
    public class Node {
        public Node prev;
        public Node next;
        public int data;

        public Node(int data) {
            this.data = data;
        }
    }

    // 方法1：删除指定value的节点, PS:判断双向链表的头节点和尾节点
    public void remove(int value) {
        Node temp = head;
        if (temp == null) return;
        while (temp != null && temp.data != value) {
            temp = temp.next;
        }
        if (temp.prev == null) { //判断是否为头节点
            // 双向链表删除头节点的方式，既要设定next，也要设定prev
            head = temp.next;
            head.prev = null;
        } else if (temp.next == null) { //判断是否为尾节点
            temp.prev.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    // 方法2：指定节点删除，时间复杂度: O(n)
    public void remove(Node x) {
        //1、对x判空
        if (x == null) return;
        //2、对链表判断空,空链表=空壳头节点
        Node temp = head;
        if (temp == null) {
            return;
        } else if (x.prev == null) { //头节点不为空,且头节点就是x节点
            head = temp.next;
            return;
        }
        // 如果x不是头节点,这就是双向链表的好处，因为不用去找前驱节点，可以直接删除
        x.prev.next = x.next;
    }
}
