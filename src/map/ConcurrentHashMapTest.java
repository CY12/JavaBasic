package map;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * ConcurrentHashMap
 * 底层采用分段的数组+链表实现
 * 通过把整个 Map 分为N个 Segment，可以提供相同的线程安全，但是效率提升N倍，默认提升16倍。(读操作不加锁，由于 HashEntry 的 value 变量是 volatile 的，也能保证读取到最新的值。)
 * Hashtable 的 synchronized 是针对整张 Hash 表的，即每次锁住整张表让线程独占，ConcurrentHashMap 允许多个修改操作并发进行，其关键在于使用了锁分离技术。
 * 有些方法需要跨段，比如 size() 和 containsValue()，它们可能需要锁定整个表而不仅仅是某个段，这需要按顺序锁定所有段，操作完毕后，又按顺序释放所有段的锁。
 * 扩容：段内扩容(段内元素超过该段对应 Entry 数组长度的75%触发扩容，不会对整个 Map 进行扩容)，插入前检测是否需要扩容，避免无效扩容。
 *锁分段技术：
 * 首先将数据分成一段一段的存储，然后给每一段数据配一把锁，当一个线程占用锁访问其中一个段数据的时候，其他段的数据仍能被其他线程访问。
 *
 * ConcurrentHashMap 提供了与 Hashtable 和 SynchronizedMap 不同的锁机制。Hashtable 中采用的锁机制是一次锁住整个 hash 表，从而在同一时刻只能由一个线程对其进行操作；而 ConcurrentHashMap 中则是一次锁住一个桶。
 *
 * ConcurrentHashMap 默认将 hash 表分为16个桶，诸如 get、put、remove 等常用操作只锁住当前需要用到的桶。这样，原来只能一个线程进入，现在却能同时有16个写线程执行，并发性能的提升是显而易见的。
 *
 *1️⃣整体结构
 *
 * 1.7：Segment + HashEntry + Unsafe
 * 1.8: 移除 Segment，使锁的粒度更小，Synchronized + CAS + Node + Unsafe
 *
 * 2️⃣put()
 *
 * 1.7：先定位 Segment，再定位桶，put 全程加锁，没有获取锁的线程提前找桶的位置，并最多自旋 64 次获取锁，超过则挂起。
 * 1.8：由于移除了 Segment，类似 HashMap，可以直接定位到桶，拿到 first 节点后进行判断：①为空则 CAS 插入；②为 -1 则说明在扩容，则跟着一起扩容；③ else 则加锁 put(类似1.7)
 *
 * 3️⃣get()
 *
 * 基本类似，由于 value 声明为 volatile，保证了修改的可见性，因此不需要加锁。
 *
 * 4️⃣resize()
 *
 * 1.7：跟 HashMap 步骤一样，只不过是搬到单线程中执行，避免了 HashMap 在 1.7 中扩容时死循环的问题，保证线程安全。
 * 1.8：支持并发扩容，HashMap 扩容在1.8中由头插改为尾插(为了避免死循环问题)，ConcurrentHashmap 也是，迁移也是从尾部开始，扩容前在桶的头部放置一个 hash 值为 -1 的节点，这样别的线程访问时就能判断是否该桶已经被其他线程处理过了。
 *
 * 5️⃣size()
 *
 * 1.7：很经典的思路：计算两次，如果不变则返回计算结果，若不一致，则锁住所有的 Segment 求和。
 * 1.8：用 baseCount 来存储当前的节点个数，这就设计到 baseCount 并发环境下修改的问题。
 *
 * 作者：日常更新
 * 链接：https://www.jianshu.com/p/78989cd553b4
 * 来源：简书
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ConcurrentHashMapTest {
    static Map<Long, String> conMap = new ConcurrentHashMap<Long, String>();
    public static void main(String[] args) throws InterruptedException {
        for (long i = 0; i < 5; i++) {
            conMap.put(i, i + "");
        }

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                conMap.put(100L, "100");
                System.out.println("ADD:" + 100);
                try {
                    Thread.sleep(100);
                    System.out.println("ADD:" + 1000);
                    conMap.put(1000L, "1000");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (Iterator<Map.Entry<Long, String>> iterator = conMap.entrySet().iterator(); iterator.hasNext();) {
                    Map.Entry<Long, String> entry = iterator.next();
                    System.out.println(entry.getKey() + " - " + entry.getValue());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        thread2.start();

        Thread.sleep(3000);
        System.out.println("--------");
        for (Map.Entry<Long, String> entry : conMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
