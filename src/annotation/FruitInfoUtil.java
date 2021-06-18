package annotation;

import java.lang.reflect.Field;

public class FruitInfoUtil {

    public static void getFruitInfo(Class<?> clazz){
        Field[] fields = clazz.getDeclaredFields();
//        Method method = clazz.getMethod("subscribe")
        for (Field field : fields){
            // isAnnotationPresent 注释B是否在此A上。如果在则返回true;不在则返回false
            if (field.isAnnotationPresent(FruitName.class)){
                FruitName fruitName = (FruitName)field.getAnnotation(FruitName.class);
                System.out.println("水果的名称是"+fruitName.value());
            }else if (field.isAnnotationPresent(FruitColor.class)){
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                System.out.println("水果的颜色是"+fruitColor.fruitColor()+"  toString()"+fruitColor.fruitColor().toString());
            }
        }
    }
}
