package list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class forList {
    public static void main(String[] args){
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        String a = "dfafa";
        for (int i=0;i<list.size();i++){
            if (2 == list.get(i)){
                list.set(2,11);
                list.add(3,12);
            }
        }
        System.out.println(list);


    }
}
