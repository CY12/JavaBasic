package test;

import java.util.*;

public class ListTes {
    public static void main(String[] args) {
        String f = "";
        System.out.println("length "+f.length());
        String t = null;
        try {
            System.out.println("length "+t.length());
        }catch (NullPointerException e){
            System.out.println("NullPointerException");
        }


        Map<String,String> map = new HashMap<>();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        for (Map.Entry<String, String> entry:map.entrySet()){
            System.out.println("key:"+entry.getKey()+" value"+entry.getValue());
        }
        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String> entry = iterator.next();
            System.out.println("key:"+entry.getKey()+" value"+entry.getValue());
        }
        System.out.println("");
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        Iterator<String> iterator1 = list.iterator();
        while (iterator1.hasNext()){
            String s = iterator1.next();
            System.out.println(s);
        }

    }
}
