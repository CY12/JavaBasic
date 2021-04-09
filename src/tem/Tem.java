package tem;

import java.util.ArrayList;
import java.util.List;

public class Tem {
    static Tem t=new Tem();

    class T1 extends Thread{
        public T1(String name){
            super(name);
        }
        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //T3线程中要处理的东西
            System.out.println("T1线程执行");
            for(int i=0;i<10;i++){
                System.out.println(this.getName() + ":" + i);
            }
        }
    }

    class T2 extends Thread{
        public T2(String name){
            super(name);
        }
        @Override
        public void run() {
            //T3线程中要处理的东西
            System.out.println("T2线程执行");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i=0;i<10;i++){
                System.out.println(this.getName() + ":" + i);
            }
        }
    }

    class T3 extends Thread{
        public T3(String name){
            super(name);
        }
        @Override
        public void run() {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //T3线程中要处理的东西
            System.out.println("T3线程执行");
            for(int i=0;i<10;i++){
                System.out.println(this.getName() + ":" + i);
            }
        }
    }

    public static int a = 0;

    public static void count(){
        System.out.println("a == "+a);
        a++;
    }

    public static void main(String[] args) {
            List list = new ArrayList();
        for (int i = 0; i < 1000; i++) {
            System.out.println("i == "+i);
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    count();
                }
            }).start();
        }
//        for (int i=0;i<10;i++){
//            if (i == 5)
//                break;//break 不会执行后面的 输出0 1 2 3 4
//            System.out.println(i);
//        }
//
//        for(int j=0;j<10;j++){
//            if (j == 5)
//                continue;
//            System.out.println("j == "+j);
//        }
//        try {
//            T3 t3= t.new T3("T3");
//            t3.start();//启动t3线程
//            t3.join();//阻塞主线程，执行完t3再返回
//
//            T2 t2= t.new T2("T2");
//            t2.start();//启动t3线程
//            t2.join();//阻塞主线程，执行完t3再返回
//
//            T1 t1= t.new T1("T1");
//            t1.start();//启动t3线程
//            t1.join();//阻塞主线程，执行完t3再返回
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}
