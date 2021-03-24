package test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 泛型擦除
 * Java 泛型的参数只可以代表类，不能代表个别对象。由于 Java 泛型的类型参数之实际类型在编译时会被消除，所以无法在运行时得知其类型参数的类型。
 * Java 编译器在编译泛型时会自动加入类型转换的编码，故运行速度不会因为使用泛型而加快。
 *
 *
 *
 */
public class GenericTest {
    List<Integer> integerList = new ArrayList<>();
    List<String> stringList = new ArrayList<>();
    public static void main(String[] args) {


        GenericTest genericTest = new GenericTest();

        System.out.println(genericTest.integerList.getClass() == genericTest.stringList.getClass());

        System.out.println("integerList----> "+genericTest.integerList.getClass().getName());
        System.out.println("stringList----> "+genericTest.stringList.getClass().getName());

        genericTest.testErase();
//        Float f = 3.41f;
//        genericTest.integerList.add(f);
        System.out.println("integerList ---> " + genericTest.integerList);
        System.out.println("stringList ---> " + genericTest.stringList);
    }

    public void testErase() {
        Double d = 10d;
        try {
            // 通过反射机制获取字段，然后将double类型的数据放入泛型为Integer集合中
            Field integerField = this.getClass().getDeclaredField("integerList");
            integerField.setAccessible(true);
            List integerFieldList = (List) integerField.get(this);
            integerFieldList.add(d);

            // 通过反射机制获取字段，然后将double类型的数据放入泛型为String集合中
            Field stringField = this.getClass().getDeclaredField("stringList");
            stringField.setAccessible(true);
            List stringFieldList = (List) stringField.get(this);
            stringFieldList.add(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}