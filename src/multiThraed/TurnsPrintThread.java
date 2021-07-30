package multiThraed;

public class TurnsPrintThread {
    static volatile boolean a = true;
    private static volatile  int b = 0;
    static String obj = "1";
    public static void main(String[] args) {

        t1 t1 = new t1();
        t1.start();

        t2 t2 = new t2();
        t2.start();
    }
//    static class t1 extends Thread {
//        @Override
//        public void run() {
//            while (true) {
//                if (a){
//                    System.out.println("A"+b);
//                    b++;
//                    a = false;
//                    try {
//                        sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//    }
//
//    static class t2 extends Thread {
//        @Override
//        public void run() {
//            while (true) {
//                if (!a){
//                    System.out.println("B"+b);
//                    b++;
//                    a = true;
//                    try {
//                        sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//    }

    static class t1 extends Thread {
        @Override
        public void run() {
            while (true){
                synchronized (obj){
                    obj.notify();
                    System.out.println("A"+b);
                    b++;
                    try {
                        obj.wait();
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class t2 extends Thread {
        @Override
        public void run() {
            while (true){
                synchronized (obj){
                    obj.notify();
                    System.out.println("B"+b);
                    b++;
                    try {
                        obj.wait();
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


}
