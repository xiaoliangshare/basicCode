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
        if (a == null) { // 说明x节点就是head节点
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

    // 删除尾节点

    /**
     * 对于链表的尾节点q，不可以直接free(q)
     * 必须要找到前驱节点，比如前驱节点为p
     * 这时p.next的值是q
     * 要删除q，不仅要free(q) 还需设置p->next=NULL
     * 否则 下次遍历 到p的时候，访问p->next的值，还是q的值，而这时q已经释放，导致野指针错误
     *
     * @param linked
     */
    public void removeTailNode(Linked linked) {
        if (linked.head == null) return;
        Node temp = linked.head;
        Node p = null;
        while (temp.next != null) {
            p = temp;
            temp = temp.next;
        } // 执行完之后temp就是尾节点
        if (temp.next == null) {
            temp = null;
            p.next = null;
        }
        //temp=null;
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

    /**
     * 两个链表相加操作
     *
     * @param l1
     * @param l2
     * @return
     */
    public static Node addTwoNumbers(Node l1, Node l2) {
        //传的应该是两个链表的头节点吧
        /* 思路：1、先对这两个链表进行反转
                2、对依次遍历这两个链表，
                3、进行相加，同时设置十分位：int tendigits=0;
        */
        // 1、先对链表进行判空处理
        if (l1 == null || l2 == null) return null;

        // 2.1、对l1进行反转
        Node newl1 = null;
        Node temp1 = l1;
        while (temp1 != null) {
            Node x = temp1;
            temp1 = temp1.next;
            if (newl1 == null) {
                x.next = null;
                newl1 = x;
            } else {
                x.next = newl1;
                newl1 = x;
            }
        }
        // 2.2、对l2进行反转
        Node newl2 = null;
        Node temp2 = l2;
        while (temp2 != null) {
            Node x = temp2;
            temp2 = temp2.next;
            if (newl2 == null) {
                x.next = null;
                newl2 = x;
            } else {
                x.next = newl2;
                newl2 = x;
            }
        }

        // 3、进行进行链表相加操作,相加操作之后得往addHead前面插
        int tendigits = 0;
        Node i = newl1;
        Node j = newl2;
        Node addHead = null;
        //int sum=0;
        while (i != null && j != null) {
            int sum = i.data + j.data;
            Node x = new Node((sum + tendigits) % 10); //取个位上的数字
            if ((sum + tendigits) >= 10) {
                tendigits = 1; //取十分位上的数字
            } else {
                tendigits = 0;
            }
            if (addHead == null) {
                addHead = x; //此时x.next=null
            } else {
                x.next = addHead;
                addHead = x;
            }
            i = i.next;
            j = j.next;
        } // 此时只是遍历到两个链表都不为空的部分
        if (i == null && j != null) {
            // 遍历l2
            while (j != null) {
                Node x = new Node((j.data + tendigits) % 10);
                if ((j.data + tendigits) >= 10) {
                    tendigits = 1; //取十分位上的数字
                } else {
                    tendigits = 0;
                }
                x.next = addHead;
                addHead = x;
                j = j.next;
            }
        } else if (j == null && i != null) {
            // 遍历l1
            while (i != null) {
                Node x = new Node((i.data + tendigits) % 10);
                if ((i.data + tendigits) >= 10) {
                    tendigits = 1; //取十分位上的数字
                } else {
                    tendigits = 0;
                }
                x.next = addHead;
                addHead = x;
                i = i.next;
            }
        }
        // 不管那种情况执行完，还有其他
        if (i == null && j == null) {
            if (tendigits == 1) {
                Node x = new Node(tendigits);
                x.next = addHead;
                addHead = x;
            }
        }
        return addHead;
    }

    /**
     * 对链表进行重新排序
     * 思路：先反转链表，再按照奇偶数进行取轮次
     *
     * @param linked
     */
    public void reorderList(Linked linked) {
        // 对链表判空处理
        if (linked.head == null) return;

        Node newHead = null;
        Node temp = linked.head;
        int linkedSize = 0;
        while (temp != null) {
            linkedSize++;
            Node x = new Node(temp.data);
            if (newHead == null) {
                newHead = x;
            } else {
                x.next = newHead;
                newHead = x;
            }
            temp = temp.next;
        } //这样就实现了链表的反转，而且是新创建的链表

        // 下面开始拼接
        Node reorderHead = null;
        Node temp1 = linked.head;
        Node temp2 = newHead;
        Node guard = null;
        if (linkedSize % 2 == 0) { //如果是偶数就取（linkedSize/2）轮
            for (int k = 0; k < (linkedSize / 2); k++) {
                Node i = new Node(temp1.data);
                Node j = new Node(temp2.data);
                if (reorderHead == null) {
                    reorderHead = i;
                    reorderHead.next = j;
                } else {
                    guard.next = i;
                    i.next = j;
                }
                guard = j;
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        } else { //如果是偶数就取（linkedSize/2）+1 轮
            for (int k = 0; k < (linkedSize / 2) + 1; k++) {
                Node i = new Node(temp1.data);
                Node j = new Node(temp2.data);
                if (reorderHead == null) {
                    reorderHead = i;
                    reorderHead.next = j;
                } else {
                    guard.next = i;
                    i.next = j;
                }
                guard = j;
                // 奇数的最后一轮
                if (k == ((linkedSize / 2) + 1)) {
                    Node node = new Node(temp1.data);
                    guard.next = node;
                }
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
    }
}
/**
 * 总结：1、对于链表操作，第一件事就是链表判空（判断是否是空壳头节点），如果为空直接return
 *      2、对传参节点进行判空,如果为空直接return
 *
 * 删除头节点方式：
 *     1、单向链表：head = head.next
 *     2、双向链表：head = head.next;  head.prev = null; （设置后继节点，也要设置前驱节点）
 * 刷题过程中一般会给定头节点，但也需要判断是否为空壳头节点
 */
