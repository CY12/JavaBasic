package code;

public class Fibonacci {
    public int Fibonacci(int n) {
        int front = 0;
        int front1 = 1;
        if (n <= 1) {
            return n;
        } else {
            for (int i = 2; i <= n; i++) {
                System.out.println("i==" + i);
                int tem = front1;
                front1 = front + front1;
                front = tem;
            }
            return front1;
        }
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.Fibonacci(9));
    }
}
