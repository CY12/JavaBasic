package ds;

import java.util.HashMap;

public class MapALGO {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if(length == 0) {
            return 0;
        }
        int begin = 0;

        int max = 0;
        HashMap map = new HashMap();
        for(int i = 0;i < length;i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),"");
            }else {
                map.clear();
                map.put(s.charAt(i),"");
                int dis = i - begin;
                if (dis > max){
                    max = dis;
                }
                begin = i;
            }
        }


        return Math.max(max, map.size());
    }
}
