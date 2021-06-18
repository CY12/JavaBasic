package set;

import java.util.TreeSet;

public class TreeSetTest {

    public static void main(String[] args){
        TreeSet<Integer> set = new TreeSet();
        set.add(11);
        set.add(111);
        set.add(12);
        set.add(131);
        set.add(11);
        for (Integer integer :set){
            System.out.println(integer);
        }
        Student student1 = new Student(11, "啊一");
        Student student2 = new Student(13, "比二");
        Student student3 = new Student(11, "比二");
        Student student4 = new Student(11, "第四");
        Student student5 = new Student(11, "比二");
        TreeSet<Student> treeSet = new TreeSet<>();
        treeSet.add(student1);
        treeSet.add(student2);
        treeSet.add(student3);
        treeSet.add(student4);
        treeSet.add(student5);
        for (Student student :treeSet){
            System.out.println(student.toString());
        }
    }
}
