package reflex;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 *    第一种：Student.class;
 *
 *    第二种：new Student().getClass();
 *
 *    第三种：Class.forName(包名+类名);
 *
 *  获取公有方法 getXXX 获取私有 getDeclaredXXX 加上具体的名 参数  之后再加上 setAccessible
 *
 */
public class Reflex {

   public static void main(String[] args) {


       Class clz = null;
//        clz = ReflexTest.class;
//        clz = new ReflexTest().getClass();
       try {
           clz = ReflexTest.class;
//           clz = Class.forName("com.example.space.reflex.ReflexTest");
       } catch (Exception e) {
           System.out.println(e.toString());
       }
       if (clz == null) return;

       // 公有方法
       Method[] methods = clz.getMethods();
       for (Method method : methods) {
           System.out.println( "反射获取到的方法名 " + method.getName());
       }

       // 共有构造方法
       Constructor[] constructors = clz.getConstructors();
       for (Constructor constructor : constructors) {
           System.out.println("反射获取到的构造方法名" + constructor.getName());
       }

       // 私有构造方法
       Constructor privateConstructor = null;
       try {
           privateConstructor = clz.getDeclaredConstructor(String.class);
           privateConstructor.setAccessible(true);
       } catch (NoSuchMethodException e) {
           e.printStackTrace();
       }

       Object obj = null;
       try {
           obj = privateConstructor.newInstance("xixixixi");
       } catch (IllegalAccessException e) {
           e.printStackTrace();
       } catch (InstantiationException e) {
           e.printStackTrace();
       } catch (InvocationTargetException e) {
           e.printStackTrace();
       }

       // 成员变量
       Field[] fields = clz.getFields();
       for (Field field : fields) {
           System.out.println("反射获取到的属性名" + field.getName());
       }


       // 私有成员变量 属性
       Field nameField = null;
       try {
           nameField = clz.getDeclaredField("privateAttr");
       } catch (NoSuchFieldException e) {
           e.printStackTrace();
       }
       nameField.setAccessible(true);
       String privateAttr1 = null;
       Object reflex = null;
       try {
           reflex = clz.newInstance();
       } catch (InstantiationException e) {
           e.printStackTrace();
       } catch (IllegalAccessException e) {
           e.printStackTrace();
       }
       try {
           privateAttr1 = (String) nameField.get(reflex);
       } catch (IllegalAccessException e) {
           e.printStackTrace();
       }
       System.out.println("反射更改前的 privateAttr  " + privateAttr1);
       try {
           nameField.set(reflex, "privateHHH");
       } catch (IllegalAccessException e) {
           e.printStackTrace();
       }
       try {
           String privateAttr = (String) nameField.get(reflex);
           System.out.println("反射更改后的 privateAttr  " + privateAttr);
       } catch (IllegalAccessException e) {
           e.printStackTrace();
       }


       // 私有方法
       Method privateMethod = null;
       try {
           privateMethod = clz.getDeclaredMethod("privateParameter", String.class);
           privateMethod.setAccessible(true);
       } catch (Exception e) {
           System.out.println(e.toString());
       }
       if (privateMethod == null) return;

       try {
           privateMethod.invoke(clz.newInstance(), "Tom");
       } catch (IllegalAccessException e) {
           e.printStackTrace();
       } catch (InvocationTargetException e) {
           e.printStackTrace();
       } catch (InstantiationException e) {
           e.printStackTrace();
       }


       Field name = null;
       try {
           name = clz.getDeclaredField("name");
       } catch (NoSuchFieldException e) {
           e.printStackTrace();
       }
       name.setAccessible(true);
       if (name == null) return;
       String mName = null;
       try {
           mName = (String) name.get(obj);
       } catch (IllegalAccessException e) {
           e.printStackTrace();
       }
       System.out.println( "final 修饰的name 初始值" + mName);

       try {
           name.set(obj, "啦啦啦啦啦啦");
       } catch (IllegalAccessException e) {
           e.printStackTrace();
       }
       try {
           System.out.println("final 修饰的name 修改后 " + name.get(obj) + " hashCode:" + name.get(obj).hashCode());
       } catch (IllegalAccessException e) {
           e.printStackTrace();
       }

       Method printMethod = null;
       try {
           printMethod = clz.getDeclaredMethod("printName");
           printMethod.setAccessible(true);
       } catch (NoSuchMethodException e) {
           e.printStackTrace();
       }
       if (printMethod == null) return;
       try {
           printMethod.invoke(obj);//ReflexTest name嘻嘻嘻 因为调用ReflexTest 中 printName() 方法中的name 是常量
       } catch (IllegalAccessException e) {
           e.printStackTrace();
       } catch (InvocationTargetException e) {
           e.printStackTrace();
       }
   }

}