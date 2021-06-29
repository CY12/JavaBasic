package ds;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindowALGO {
//    dvdhijfsafkkkk
//    dv d   left = 1  d0 v1
//    d vdhijfsa  f  left = 7  a8 s7 d2 v1 f6 h3 i4 j5
//    dvdhijf safk k left = 11  a8 s7 d2 v1 f9 h3 i4 j5 k10

    /**
     * 不重复 字符串长度
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // 记录出现重复字符串的最大值
                left = Math.max(left, map.get(s.charAt(i)) + 1);
                System.out.println("left" + left + " contains" + s.charAt(i)+"  map.get(s.charAt(i))"+map.get(s.charAt(i)));
            }
            // 如果相同char 则覆盖 最新的i 值 map中不会存入相同的字符串
            map.put(s.charAt(i), i);
            System.out.println("放入" + s.charAt(i));
            // i-left+1 记录当前最大字符串长度
            max = Math.max(max, i - left + 1);
            System.out.println("max" + max);
            System.out.println();
            for (Map.Entry<Character,Integer> m:map.entrySet()){
                System.out.print(m.getKey()+""+m.getValue()+" ");
            }
            System.out.println();
        }
        return max;

    }

    public static void main(String[] args){
        lengthOfLongestSubstring("dvdhijfsafkkkk");
    }

}
