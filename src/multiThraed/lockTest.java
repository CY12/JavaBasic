package multiThraed;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入就是说某个线程已经获得某个锁，可以再次获取锁而不会出现死锁
 *
 * synchronized和Lock的区别
 *
 * synchronized是Java中的关键字，是Java的内置实现；Lock是Java中的接口。
 * synchronized遇到异常会释放锁；Lock需要在发生异常的时候调用成员方法Lock#unlock()方法。
 * synchronized是不可以中断的，Lock可中断。
 * synchronized不能去尝试获得锁，没有获得锁就会被阻塞； Lock可以去尝试获得锁，如果未获得可以尝试处理其他逻辑。
 * synchronized多线程效率不如Lock，不过Java在1.6以后已经对synchronized进行大量的优化，所以性能上来讲，其实差不了多少。

 */
public class lockTest {
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println("第1次获取锁，这个锁是：" + lock);

                    int index = 1;
                    while (true) {
                        try {
                            lock.lock();
                            System.out.println("第" + (++index) + "次获取锁，这个锁是：" + lock);

                            try {
                                Thread.sleep(new Random().nextInt(200));
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            if (index == 10) {
                                break;
                            }
                        } finally {
                            lock.unlock();
                        }

                    }

                } finally {
                    lock.unlock();
                }
            }
        }).start();




//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (this) {
//                    System.out.println("第1次获取锁，这个锁是：" + this);
//                    int index = 1;
//                    while (true) {
//                        synchronized (this) {
//                            System.out.println("第" + (++index) + "次获取锁，这个锁是：" + this);
//                        }
//                        if (index == 10) {
//                            break;
//                        }
//                    }
//                }
//            }
//        }).start();
    }

}
