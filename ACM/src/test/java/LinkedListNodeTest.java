import junit.framework.TestCase;
import org.junit.Test;

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
    public void testAdd(){
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
    }

    @Test
    public void testFind() {
    }
}