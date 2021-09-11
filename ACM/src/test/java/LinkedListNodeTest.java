import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/8/29
 * @time: 5:57 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class LinkedListNodeTest extends TestCase {

    /**
     * 向链表中插入元素
     */
    @Test
    public void testInsert() {
        Linked linked = new Linked();
        Linked.Node node1 = new Linked.Node(1);
        linked.insert(linked.head, node1);
        System.out.println(linked);
    }

    @Test
    public void testAdd() {
        Linked linked = new Linked();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        linked.add(5);
        linked.printLinked(linked);

    }

    @Test
    public void testRemove() {
        Linked linked = new Linked();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        linked.add(5);
        linked.printLinked(linked);
        linked.remove(linked, new Linked.Node(1));
        linked.printLinked(linked);
    }

    @Test
    public void testFind() {
    }

    @Test
    public void testLRU() {
        Linked linked = new Linked();
        System.out.println(linked.currentCapacity);
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        linked.add(5);
        System.out.println(linked.currentCapacity);
        linked.LRU(linked, new Linked.Node(6));
        linked.printLinked(linked);
    }

    /**
     * 链表反转
     */
    @Test
    public void testReverseLinked() {
        Linked linked = new Linked();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        linked.add(5);
        Linked.Node newHead = linked.reverseLinked(linked);
        //Linked.Node newHead=linked.reverseLinked2(linked);
        System.out.println(newHead.data);

        linked.printLinked(linked);//[1], 说明已经改变了原链表的结构


    }

    /**
     * 测试两个链表相加
     */
    @Test
    public void testAddTwoNumbers() {
        Linked linked1 = new Linked();
        linked1.add(1);
//        linked1.add(2);
//        linked1.add(4);
//        linked1.add(3);
        Linked linked2 = new Linked();
        linked2.add(9);
        linked2.add(9);
//        linked2.add(6);
//        linked2.add(4);

        Linked.Node node = Linked.addTwoNumbers(linked1.head, linked2.head);
        System.out.println(node.data);
    }

    @Test
    public void testRemoveTailNode(){
        Linked linked = new Linked();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        linked.add(5);
        linked.removeTailNode(linked);
        linked.printLinked(linked);
    }

    @Test
    public void testString2List(){
        String s="[{\"inv_org\":\"A66\",\"delaySeconds\":6}]";
    }
}