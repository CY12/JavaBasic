package test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class IteratorTest {

    private List reversal(int num){
        System.out.println("reversal "+num+Thread.currentThread().getName());
        List list = new ArrayList();
        while(num != 5){
            num++;
            System.out.println("reversal之前 "+num);
            reversal(num);
            System.out.println("reversal之后 "+num);
//            list.add(num);
//            System.out.println("添加" + num);

        }
        return list;
    }

    public static void main(String[] args) {
        IteratorTest it = new IteratorTest();


        // TODO Auto-generated method stub
        List<Integer> li=new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            li.add(i);
        }
        ListIterator<Integer> lit=li.listIterator();//使用ListIterator
        while (lit.hasNext()) {
            System.out.print(lit.next()+"   ");

        }
        //此时，迭代器已经到达ArrayList的尾部，所以可以开始从后往前的遍历了
        while (lit.hasPrevious()) {
            System.out.print(lit.previous()+"   ");
        }
        System.out.println(" 递归 ");
        System.out.println(it.reversal(1));
    }


}
