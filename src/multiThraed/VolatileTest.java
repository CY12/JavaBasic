package multiThraed;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * i++
 *  可见i++执行了多部操作,从变量i中读取读取i的值->值+1 ->将+1后的值写回i中,这样在多线程的时候执行情况就类似如下了
 *
 *  Thread1             Thread2
 *     r1 = i;             r3 = i;         //读取i值
 *     r2 = r1 + 1;        r4 = r3 + 1;    //i值加1
 *     i = r2;             i = r4;         //写回到i
 *  这样会造成的问题就是 r1, r3读到的值都是 0,最后两个线程都将 1 写入 i, 最后 i等于 1,但是却进行了两次自增操作。
 *
 * 在 java 垃圾回收整理一文中，描述了jvm运行时刻内存的分配。其中有一个内存区域是jvm虚拟机栈，每一个线程运行时都有一个线程栈，
 *
 * 线程栈保存了线程运行时候变量值信息。当线程访问某一个对象时候值的时候，首先通过对象的引用找到对应在堆内存的变量的值，然后把堆内存
 *
 * 变量的具体值load到线程本地内存中，建立一个变量副本，之后线程就不再和对象在堆内存变量值有任何关系，而是直接修改副本变量的值，
 *
 * A a = new A();
 *      1. 向栈中压入变量 a,并在堆中分配内存
 *      2.在堆中初始化A
 *      3.将A地址赋值给a
 * JVM 指令重排会导致 2 3 执行顺序不一定，所以双重校验锁加上volatile
 *
 */
public class VolatileTest extends Thread{

    boolean flag = false;
    int i = 0;

    @Override
    public void run() {
        while (!flag) {
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            i++;
//            System.out.println(i);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        VolatileTest vt = new VolatileTest();
        vt.start();
        Thread.sleep(1000);
        vt.flag = true;
        System.out.println("score" + vt.i);
    }
    /*


    在这里我需要说明一下，有的同学可能在测试上面代码的时候程序可以正常退出。那是因为你的JVM没有优化造成的！在DOC下面输入 java -version 查看 如果显示Java HotSpot(TM) … Server 则JVM会进行优化。

    那么按照我们上面所讲的 “JVM在运行时候的内存分配过程” 就很好解释上面的问题了。

    首先 vt线程在运行的时候会把 变量 flag 与 i (代码3,4行)从“主内存” 拷贝到 线程栈内存（上图的线程工作内存）

    然后 vt线程开始执行while循环

     7         while (!flag) {
     8             i++;
     9         }
    while (!flag)进行判断的flag 是在线程工作内存当中获取，而不是从 “主内存”中获取。

    i++; 将线程内存中的i++; 加完以后将结果写回至 “主内存”，如此重复。

    然后再说说主线程的执行过程。 我只说明关键的地方

    vt.flag = true;

    主线程将vt.flag的值同样 从主内存中拷贝到自己的线程工作内存 然后修改flag=true. 然后再将新值回到主内存。

    这就解释了为什么在主线程（main）中设置了vt.flag = true; 而vt线程在进行判断flag的时候拿到的仍然是false。那就是因为vt线程每次判断flag标记的时候是从它自己的“工作内存中”取值，而并非从主内存中取值！

    这也是JVM为了提供性能而做的优化。那我们如何能让vt线程每次判断flag的时候都强制它去主内存中取值呢。这就是volatile关键字的作用。
     */
}

