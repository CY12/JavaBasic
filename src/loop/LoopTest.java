package loop;

import java.util.*;

public class LoopTest {

    public static void main(String[] args){
        ok:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("i=" + i + ",j=" + j);
//                if (j == 3){
//                    break ;
//                }
                if (j == 5) {
                    break ok;
                }

            }
        }


        Map<String,String> map = new HashMap<>();
        map.put("1 key","1 value");
        map.put("2 key","2 value");
        map.put("3 key","3 value");
        map.put("4 key","4 value");
        System.out.println("   iterator  lambda ");
        map.forEach((key,value) ->{
            System.out.println(key+"  "+value);
        });
        System.out.println("   iterator ");

        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String> entry = iterator.next();
            System.out.println(entry.getKey()+"  "+entry.getValue());
        }
        System.out.println("   iterator1   ");
        Iterator iterator1 = map.entrySet().iterator();
        while (iterator1.hasNext()){
            Map.Entry entry = (Map.Entry) iterator1.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println(key+"  "+value);
        }
        System.out.println("   for   ");

        for (Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey()+"  "+entry.getValue());
        }
        for (String key :map.keySet()){

        }
//        2 key  2 value  ? 指令重排？遍历问题?
//        1 key  1 value
//        3 key  3 value
//        4 key  4 value



        List<String> list = new ArrayList();
        list.add("1 list");
        list.add("2 list");
        list.add("3 list");
        list.add("4 list");
        Iterator<String> iterator3 = list.iterator();
        while (iterator3.hasNext()){
            String s = iterator3.next();
            System.out.println(s);
        }
//        ListIterator listIterator = list.listIterator();
//        listIterator.hasPrevious();

        for (int i=0;i<10;i++){
            if (i == 5) {
                break;//break 不会执行后面的 输出0 1 2 3 4
            }
            System.out.println(i);
        }

        for(int j=0;j<10;j++){
            if (j == 5) {
                continue;
            }
            System.out.println("j == "+j);
        }
    }
}
