package queue;

import java.util.*;

public class ListTest {
    private List<Object> list = new ArrayList<>();

    private Object dequeue(){
        if (list.size() > 0){
            return list.remove(0);
        }
        return null;
    }

    private Object pop(){
        if (list.size() > 0){
           return list.remove(list.size() -1);
        }
        return null;
    }
    private void printList(){
        for (Object o:list){
            System.out.println(o.toString());
        }
    }
    public static void main(String[] args){
        int a = 20 << 4 | 2;
        System.out.println("a"+a);
        ListTest listTest = new ListTest();
        listTest.list.add(1);
        listTest.list.add(2);
        listTest.list.add(3);
        listTest.list.add(4);
        listTest.list.add(5);
        Iterator iterator = listTest.list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("初始-----");
        listTest.printList();
        System.out.println("出列-----"+listTest.dequeue());
        listTest.printList();
        System.out.println("出栈-----"+listTest.pop());
        listTest.printList();
    }
}
