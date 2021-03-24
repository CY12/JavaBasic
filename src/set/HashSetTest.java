package set;

import java.util.HashSet;
import java.util.Iterator;

/**
 * HashSet 是用HashMap来实现的
 *  public boolean add(E e) {
 *         return map.put(e, PRESENT)==null;
 *     }
 * 利用HashMap key不重复；首先比较HashCode 相同在比较equals
 *
 * 基本类型没有HashCode equals方法
 *
 * String 重写了HashCode 和 equals 方法  equals hashcode值根据字符串来确定
 *
 * 添加对象时要重写HashCode 和 equals 方法
 *
 */
public class HashSetTest {

    public static void main(String[] args){

        HashSet hashSet = new HashSet();
        Person person = new Person();
        person.setName("www");
        person.setAge(1);
        Person person1 = new Person();
        person1.setName("www");
        person1.setAge(2);
        hashSet.add("111");
        hashSet.add("111");
        hashSet.add(person);
        hashSet.add(person);
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()){
            Object o = iterator.next();
            System.out.println(o);
        }
        for(Object o:hashSet){
            System.out.println(o);
        }
    }
    static class Person{
        String name;
        int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public int hashCode() {
            System.out.println("hashCode");
            // String 重写了HashCode 相同字符串的HashCode 相同
            int result = name.hashCode();
            return result+age;
        }

        @Override
        public boolean equals(Object obj) {
            System.out.println("equals");
            // instanceof 已经处理了obj = null的情况
            if (!(obj instanceof Person)) {
                return false;
            }
            Person person = (Person) obj;
            // 地址相等 没必要 地址相等 hashcode相等
            if (this == person) {
                return true;
            }
            if (person.name.equals(this.name) && person.age == this.age) {
                return true;
            }
            return false;
        }
    }
}
