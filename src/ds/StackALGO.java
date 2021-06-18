package ds;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class StackALGO {
    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    public static void push(int node) {
        stack1.push(node);
    }

    public static int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int p = stack2.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return p;
    }

    public static void main(String[] args){

        push(1);
        push(2);
        push(3);
        System.out.println(pop());
        push(4);
        System.out.println(pop());
        System.out.println(pop());
//        stack1.push(1);
//        stack1.push(2);
//        stack1.push(3);
//        stack1.push(4);
//        stack1.push(5);
//
//        for (int i=stack1.size()-1;i>=0;i--){
//            System.out.println(stack1.get(i));
//        }
//        for (Integer i : stack1){
//           System.out.println(i);
//        }


    }
}
