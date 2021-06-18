package multiThraed;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;

/**
 * 进程是系统的执行单位 线程是系统CPU的最小单位 一个进程可以有多个线程，多个线程共享一个进程内的资源。
 *
 * 线程状态  1.创建状态  2.就绪状态  3.运行状态  4.阻塞状态  5.死亡状态
 *
 * join()方法用于将线程由”并行“变成”串行“.它用于等待其他线程的终止，在当前线程掉用了join()方法，
 *             那么当前线程将进入阻塞状态，等到另一个线程结束，
 *             当前线程再由阻塞状态转变成就绪状态，等待CPU的使用权
 * join方法的原理就是调用相应线程的wait方法进行等待操作的，例如A线程中调用了B线程的join方法，则相当于在A线程中调用了B线程的wait方法，
 * 当B线程执行完（或者到达等待时间），B线程会自动调用自身的notifyAll方法唤醒A线程，从而达到同步的目的。
 *
 * yield() 只是向调度器发起让出 CPU 的请求，但是 调度器可能不鸟你
 *
 * stop()  stop方法是很危险的，就象突然关闭计算机电源，而不是按正常程序关机一样，可能会产生不可预料的结果
 *
 * interrupt()  不能中断在运行中的线程，它只能改变中断状态而已
 *      1.线程处于阻塞状态，如使用了sleep方法 ,sleep方法将抛出一个InterruptedException退出
 *      2.使用while（！isInterrupted（））{……}来判断线程是否被中断  线程将直接退出
 * synchronized修饰方法
 *      1、静态方法的锁和实例方法的锁，默认是不同的对象锁
 *
 *      2、静态方法加锁，能和该类中所有用synchronized修饰静态方法的相互互斥，和未用synchronized修饰的静态方法不互斥
 *
 *      3、静态方法锁实际是对类对象加锁，实例方法加锁实际是对实例对象加锁
 */
public class MultiThreadTest {
    public static int a = 0;

    public static void count() {
        System.out.println("a == " + a);
        a++;
    }

    /**
     * i == 0
     * i == 1
     * i == 2
     * i == 3
     * i == 4
     * i == 5
     * i == 6
     * i == 7
     * i == 8
     * i == 9
     * i == 10
     * i == 11
     * i == 12
     * i == 13
     * i == 14
     * i == 15
     * i == 16
     * i == 17
     * a == 0
     * a == 0  线程处于就绪态，但并没有执行就创建下一个线程，等到run的时候执行第一行代码的时候大家访问的 a的值可能是一样的
     * <p>
     * 解决方法 用synchronized 修饰 count 方法
     */
    public static void wrong() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("i == " + i);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count();
                }
            }).start();
        }
    }


    public static void main(String[] args) throws InterruptedException {
       // wrong();
        ThreadJoinTest1 t1 = new ThreadJoinTest1("今天");
        ThreadJoinTest1 t2 = new ThreadJoinTest1("明天");
        ThreadJoinTest1 t3 = new ThreadJoinTest1("后天");
        /*
            join()方法用于将线程由”并行“变成”串行“.它用于等待其他线程的终止，在当前线程掉用了join()方法，
            那么当前线程将进入阻塞状态，等到另一个线程结束，
            当前线程再由阻塞状态转变成就绪状态，等待CPU的使用权
              程序在main线程中调用t1线程的join方法，则main线程放弃cpu控制权，并返回t1线程继续执行直到线程t1执行完毕
         所以结果是t1线程执行完后，才到主线程执行，相当于在main线程中同步t1线程，t1执行完了，main线程才有执行的机会

         * 通过join方法来确保t1、t2、t3的执行顺序 main线程阻塞 知道 t1 执行完 执行t2...
         * */
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();




    }

    static class ThreadJoinTest1 extends Thread {
        public ThreadJoinTest1(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(this.getName() + ":" + i);
            }
        }
    }
}
//public class ThreadJoinDemo {
//
//    public static void main(String[] args) {
//        final Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("产品经理规划新需求");
//            }
//        });
//
//        final Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    thread1.join();
//                    System.out.println("开发人员开发新需求功能");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        Thread thread3 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    thread2.join();
//                    System.out.println("测试人员测试新功能");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        System.out.println("早上：");
//        System.out.println("测试人员来上班了...");
//        thread3.start();
//        System.out.println("产品经理来上班了...");
//        thread1.start();
//        System.out.println("开发人员来上班了...");
//        thread2.start();
//    }
//}
//运行结果
//
//        早上：
//        测试人员来上班了...
//        产品经理来上班了...
//        开发人员来上班了...
//        产品经理规划新需求
//        开发人员开发新需求功能
//        测试人员测试新功能