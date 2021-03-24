package code;


import java.util.ArrayList;
import java.util.List;

public class Solution {
//2 8 5 9 4 3 7
//    List list = new ArrayList();
//
//        for (int p =0;p<5;p++){
//        list.add(0,p);
//    }
//        System.out.println(list);  [4, 3, 2, 1, 0]
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (listNode != null){
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;

    }
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


}


