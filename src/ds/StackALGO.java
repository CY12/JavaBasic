package ds;

import java.util.*;

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
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return p;
    }

    //    20. 有效的括号 https://leetcode-cn.com/problems/valid-parentheses/
//    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
//    有效字符串需满足：
//
//    左括号必须用相同类型的右括号闭合。
//    左括号必须以正确的顺序闭合。
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;
        List list = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            String s1 = String.valueOf(s.charAt(i));
            if (isLeft(s1)) {
                list.add(s1);
            } else {
                if (list.size() == 0) return false;
                String pop = list.remove(list.size() - 1).toString();
                if (!isMatched(pop, s1)) {
                    return false;
                }
            }
        }
        if (list.size() == 0) {
            return true;
        }

        return false;
    }

    private boolean isLeft(String c) {
        return "(".equals(c) || "{".equals(c) || "[".equals(c);
    }

    private boolean isMatched(String s1, String s2) {
        if ("(".equals(s1)) {
            if (")".equals(s2)) {
                return true;
            }
        } else if ("{".equals(s1)) {
            if ("}".equals(s2)) {
                return true;
            }
        } else if ("[".equals(s1)) {
            if ("]".equals(s2)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

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
