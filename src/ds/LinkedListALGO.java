package ds;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LinkedListALGO {
    static class Node{
        int value;
        Node next;


        public  Node(int value){
            this.value = value;
        }

        public  Node(int value,Node next){
            this.value = value;
            this.next = next;
        }

//        @Override
//        public boolean equals(Object obj) {
//            if (this == obj){
//                return true;
//            }
//            if (obj instanceof Node){
//                Node node = (Node)obj;
//                if (node.value == this.value && )
//            }
//
//        }
//        @Override
//        public int hashCode() {
//
//        }


    }
    // 获得链表的长度
    public static int getLength(Node head){
        if (head == null){
            return 0;
        }
        int len = 0;
        while (head != null){
            len++;
            head = head.next;
        }
        return len;
    }
    //打印链表
    public static void printNode(Node node){
        while (node != null){
            System.out.print(node.value+"  ");
            node = node.next;
        }
        System.out.println("  ");
    }
    // 向指定node之后添加一个元素
    public static void addNode(Node curNode,Node addNode){
        Node temp = curNode.next;
        curNode.next = addNode;
        addNode.next = temp;
    }
    // 只给一个节点删除链表中元素 实际上更改当前元素的值为下一个元素 要删除的node并没有删除
    public static void deleteByUpdateNode(Node node){
        Node temp = node.next;
        node.value = temp.value;
        node.next = temp.next;
    }
    public static Node deleteNode(Node head,Node deleteNode){
        if (head == null || deleteNode == null ){
            return head;
        }
        Node headNode = head;
        if (head == deleteNode){
            return head.next;
        }
        while (head.next != null){
            if (head.next == deleteNode){
                if (head.next.next != null){
                    head.next = head.next.next;
                }else {
                    head.next = null;
                }
                return headNode;
            }
            head = head.next;
        }
        return headNode;
    }

    // 链表之快慢指针
    // 已知一个单链表求倒数第 N 个节点 即fast-slow = n
    // 寻找单链表的中间元素 即 fast = 2 slow
    public static Node getMidNode(Node head){
        if (head == null){
            return null;
        }
        Node fast = head;// 一次移动两个位置
        Node slow = head;// 一次移动一个位置
        while(fast != null && fast.next != null){
            fast = fast.next.next;// fast.next = null 时会出现空指针
            slow = slow.next;
        }
        return slow;
    }
// 事先预备一个
    public Node removeNthFromEnd(Node head, int n) {
        Node dummy = new Node(0, head);
        Node first = head;
        Node second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        Node ans = dummy.next;
        return ans;
    }

    public Node removeNthFromEnd2(Node head, int n) {
        Node fast = head;
        Node slow = head;
        for (int i = 0;i<n;i++){
            fast = fast.next;// 这里暂定不会出现空指针
        }
        if(fast == null){// 当fast 为 null 则代表删除头结点
            return head.next;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }


    public static Node reverseNodeList(Node node){
        Node cur = node;
        Node pre = null;
        Node next = null;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static boolean isLoop(Node node){
        Set<Node> nodeSet = new HashSet<>();
        while (node != null){
            boolean isSuccess = nodeSet.add(node);
            if (!isSuccess){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public static Node Merge(Node list1,Node list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null && list2 != null) return list2;
        if (list1 != null && list2 == null) return list1;

        Node head = null,l = null;
        while(list1 != null && list2 != null){
            if( list1.value < list2.value){
                if(l == null){
                    l = new Node(list1.value);
                    head = l;
                }else{
                    l.next = new Node(list1.value);
                    l = l.next;
                }

                list1 = list1.next;

            }else{
                if(l == null){
                    l = new Node(list2.value);
                    head = l;
                }else{
                    l.next = new Node(list2.value);
                    l = l.next;
                }

                list2 = list2.next;
            }
        }

        while(list1 != null ){
            l.next = new Node(list1.value);
            list1 = list1.next;
            l = l.next;
        }
        while(list2 != null ){
            l.next = new Node(list2.value);
            list2 = list2.next;
            l = l.next;
        }
        return head;
    }

    public static void main(String[] args){
        Node node1 = new Node(1);
        Node node2 = new Node(11);
        Node node3 = new Node(32);
        Node node4 = new Node(12);
        Node node5 = new Node(13);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        printNode(node1);
        Node node6 = new Node(6);
        System.out.println("在Node 值为 1 后添加Node 值为6");
        addNode(node1,node6);
        printNode(node1);
        System.out.println("打印中间元素");
        System.out.println(getMidNode(node1).value);
        System.out.println("删除Node 值为12");
//        deleteByUpdateNode(node4);
//        System.out.println(" node3.next "+node3.next+" node4 " +node4);
        printNode(deleteNode(node1,node4));
        System.out.println("打印中间元素");
        System.out.println(getMidNode(node1).value);
        System.out.println("反转链表");

        printNode(reverseNodeList(node1));
        node1.next = node5;
        System.out.println("isLoop "+isLoop(node5));

        Node node7 = new Node(1);
        Node node8 = new Node(3);
        Node node9 = new Node(5);
        Node node10 = new Node(5);
        Node node11 = new Node(5);
        Node node12 = new Node(5);
        node7.next = node8;
        node8.next = node9;
        node10.next = node11;
        node11.next = node12;
        System.out.println("合并有序链表 ");
        printNode(Merge(node7,null));
    }
    // 5 - 3 - 2 - 6 - 1
    //12  32  11   6   1
}
