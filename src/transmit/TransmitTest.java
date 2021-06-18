package transmit;

public class TransmitTest {
    public static void main(String[] args) {
        System.out.println("------ swapNum -------" );
        int num1 = 10;
        int num2 = 20;

        swap(num1, num2);

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("------ changeArr -------" );
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(arr[0]);
        change(arr);
        System.out.println(arr[0]);
        System.out.println("------ swapStudent -------" );
        Student s1 = new Student("小张",11);
        Student s2 = new Student("小李",12);
        swapStudent(s1, s2);
        System.out.println("s1:" + s1.getName());
        System.out.println("s2:" + s2.getName());

        System.out.println("------ setName -------" );
        Student s3= new Student("小明",12);
        setName(s3);
        System.out.println("s3:" + s3.getName());
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    public static void change(int[] array) {
        // 将数组的第一个元素变为0
        array[0] = 0;
    }
    public static void swapStudent(Student x, Student y) {
        Student temp = x;
        x = y;
        y = temp;
        System.out.println("x:" + x.getName());
        System.out.println("y:" + y.getName());
    }

    public static void setName(Student student){
        Student s = student;
        s.setName("王华");
        System.out.println(s.getName());

    }

}
