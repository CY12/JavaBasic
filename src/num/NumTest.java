package num;

import java.math.BigDecimal;

/**
 * float a = 3.4f
 *
 *
 *
 * 十进制小数转化成二进制
 * 算法是乘以2直到没有了小数为止。举个例子，0.9表示成二进制数
 * 0.9*2=1.8   取整数部分 1
 * 0.8(1.8的小数部分)*2=1.6    取整数部分 1
 * 0.6*2=1.2   取整数部分 1
 * 0.2*2=0.4   取整数部分 0
 * 0.4*2=0.8   取整数部分 0
 * 0.8*2=1.6 取整数部分 1
 * 0.6*2=1.2   取整数部分 0
 *  .........
 * 0.9二进制表示为(从上往下): 1100100100100......
 *
 *
 *
 */
public class NumTest {
    public static void main(String[] args){
        int a= 5/2;
        System.out.println("a"+a);
        double d1 = 10;
        double d2 = 8.8;
        double c = d1 - d2;
        System.out.println("d1 - d2 = "+c);
        System.out.println("Double.toString(d1)"+Double.toString(d1));
        BigDecimal b1 = new BigDecimal(Double.toString(d1));//同上
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        System.out.println(b1.subtract(b2));
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
