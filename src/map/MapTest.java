package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MapTest {
    public static void main(String[] args){
        ConcurrentHashMap map = new ConcurrentHashMap();
        HashMap<Integer,String> hashMap = new HashMap();
        hashMap.put(1,"11");
        hashMap.put(2,"22");
        hashMap.put(3,"33");
        hashMap.put(4,"44");
        // for循环
        for (Map.Entry<Integer,String> m: hashMap.entrySet()){
            System.out.println("key:"+m.getKey() + " value:"+m.getValue());
        }
        // iterator
        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()){
           Map.Entry<Integer,String> entry =(Map.Entry<Integer,String>) iterator.next();
            System.out.println("key:"+entry.getKey() + " value:"+entry.getValue());
        }
        // keySet
        Iterator keyIt = hashMap.keySet().iterator();

    }
}
