package queue;

public class LinkedListTest {



    public static void main(String[] args) {
        SingleNode n1 = new SingleNode();
        n1.setDate("N1");
        n1.setNext(null);

        SingleNode n2 = new SingleNode();
        n2.setDate("N2");
        n2.setNext(n1);

        SingleNode n3 = new SingleNode();
        n3.setDate("N3");
        n3.setNext(n2);

        LinkedListTest linkedListTest = new LinkedListTest();
        linkedListTest.reverseLinkedList(n3);

        SingleNode singleNode = new SingleNode();


        while(n3 != null){
            System.out.println(n3.getDate());
            n3 = n3.getNext();
        }


        DoubleNode d1 = new DoubleNode();
        d1.setDate("d1");

        DoubleNode d2 = new DoubleNode();
        d2.setDate("d2");

        DoubleNode d3 = new DoubleNode();
        d3.setDate("d3");

        d1.setPreNode(null);
        d1.setNextNode(d2);

        d2.setPreNode(d1);
        d2.setNextNode(d3);

        d3.setPreNode(d2);
        d3.setNextNode(null);

    }

    /**
     * 单链表反转
     * @param node
     * @return
     */
    private SingleNode reverseLinkedList(SingleNode node){
        if (node == null || node.getNext() == null){
            System.out.println(" null ");
            return node;
        }else {
            System.out.println(node);
        }

        SingleNode preNode = null;
        SingleNode curNode = node;
        SingleNode nextNode = null;
        System.out.println(curNode);

        while(curNode != null){
            nextNode = curNode.getNext();
            curNode.setNext(preNode);
            preNode = curNode;
            curNode = nextNode;
        }

        return preNode;

    }

}
class SingleNode {

    private SingleNode next;
    private String date;
    public SingleNode getNext() {
        return next;
    }
    public void setNext(SingleNode next) {
        this.next = next;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

}

class DoubleNode {
    private String date;
    private DoubleNode preNode;
    private DoubleNode nextNode;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public DoubleNode getPreNode() {
        return preNode;
    }

    public void setPreNode(DoubleNode preNode) {
        this.preNode = preNode;
    }

    public DoubleNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(DoubleNode nextNode) {
        this.nextNode = nextNode;
    }
}
