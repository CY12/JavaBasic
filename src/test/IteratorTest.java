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


        double d1 = 10;
        double d2 = 8.8;
        double c = d1 - d2;
        System.out.println("d1 - d2 = "+c);
        BigDecimal b1 = new BigDecimal(Double.toString(d1));//同上
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        System.out.println(b1.subtract(b2));

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
    //加法
    public static BigDecimal add(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));//这里使用的是String构造器，将double转换为String类型
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2);
    }

    //减法
    public static BigDecimal sub(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));//同上
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2);//这是b1-b2,可以理解为从b1截取b2
    }

    //乘法
    public static BigDecimal mul(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));//同上
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2);
    }

    //除法
    public static BigDecimal div(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2,2,BigDecimal.ROUND_HALF_UP);	//四舍五入,保留2位小数，除不尽的情况
    }

}
