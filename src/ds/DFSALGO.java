package ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFSALGO {
    // 深度优先 DFS
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }
    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                System.out.print(combination.toString()+"  ");
//                System.out.println("当前字符串:"+letters.charAt(i)+" combination:"+combination.toString());
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                System.out.print("删除"+combination.charAt(index)+" ");
                combination.deleteCharAt(index);
                System.out.println(combination.toString()+"  ");
            }
        }
    }
    // BFS
    public List<String> addLetter(List<String> list, String s) {
        List<String> newList = new ArrayList<String>();
        for (int j = 0; j < list.size(); j++) {
            for (int i = 0; i < s.length(); i++) {
                newList.add(list.get(j) + s.charAt(i));
            }
        }
        return newList;
    }

    public List<String> letterCombination(String digits) {
        HashMap<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            result = addLetter(result, map.get(String.valueOf(digits.charAt(i))));
        }

        return result;
    }


    public static void main(String[] args){
        DFSALGO dfsalgo = new DFSALGO();
//        dfsalgo.letterCombinations("234");
        dfsalgo.letterCombination("234");
    }
}
//        a  ad  adg  删除g ad
//        adh  删除h ad
//        adi  删除i ad
//        删除d a
//        ae  aeg  删除g ae
//        aeh  删除h ae
//        aei  删除i ae
//        删除e a
//        af  afg  删除g af
//        afh  删除h af
//        afi  删除i af
//        删除f a
//        删除a
//        b  bd  bdg  删除g bd
//        bdh  删除h bd
//        bdi  删除i bd
//        删除d b
//        be  beg  删除g be
//        beh  删除h be
//        bei  删除i be
//        删除e b
//        bf  bfg  删除g bf
//        bfh  删除h bf
//        bfi  删除i bf
//        删除f b
//        删除b
//        c  cd  cdg  删除g cd
//        cdh  删除h cd
//        cdi  删除i cd
//        删除d c
//        ce  ceg  删除g ce
//        ceh  删除h ce
//        cei  删除i ce
//        删除e c
//        cf  cfg  删除g cf
//        cfh  删除h cf
//        cfi  删除i cf
//        删除f c
//        删除c