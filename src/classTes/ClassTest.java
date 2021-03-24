package classTes;

import java.util.HashSet;

class A {
    public String show(D obj){
        // 方法一
        return ("A and D");
    }
    public String show(A obj){
        // 方法二
        return ("A and A");
    }
}

class B extends A{
    public String show(B obj){
        // 方法三
        return ("B and B");
    }
    @Override
    public String show(A obj){
        // 方法四
        return ("B and A");
    }
}

class C extends B{
}

class D extends
        B{
}

public class ClassTest {
    public static void main(String[] args) {
        A a1 = new A();    // 创建A类对象，故a1拥有调用方法一和方法二的能力
        A a2 = new B();    // 创建A类引用，指向B类对象，故a2拥有调用方法一和方法四的能力；但向上转型不能调用子类中有而父类中没有的方法，故不能调用方法三
        B b = new B();    // 创建B类对象（继承A），方法四重写方法二，故b拥有调用方法一、方法三和方法四的能力
        C c = new C();
        D d = new D();
        System.out.println("1--" + a1.show(b));    // 1--A and A 调用方法二
        System.out.println("2--" + a1.show(c));    // 2--A and A 调用方法二
        System.out.println("3--" + a1.show(d));    // 3--A and D 调用方法一
        System.out.println("4--" + a2.show(b));    // 4--B and A 调用方法四
        System.out.println("5--" + a2.show(c));    // 5--B and A 调用方法四
        System.out.println("6--" + a2.show(d));    // 6--A and D 调用方法一
        System.out.println("7--" + b.show(b));        // 7--B and B 调用方法三
        System.out.println("8--" + b.show(c));        // 8--B and B 调用方法三
        System.out.println("9--" + b.show(d));        // 9--A and D 调用方法一
    }
}