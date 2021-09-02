import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.LinkedList;

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
    public void testReverseLinked(){
        Linked linked = new Linked();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        linked.add(5);
        Linked.Node newHead=linked.reverseLinked(linked);
        //Linked.Node newHead=linked.reverseLinked2(linked);
        System.out.println(newHead.data);

    }
}