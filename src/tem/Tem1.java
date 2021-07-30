package tem;

import transmit.Student;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Tem1 {

    private static int testReturn1() {
        int i = 1;
        try {
            i++;
            System.out.println("try:" + i);
            return i;
        } catch (Exception e) {
            i++;
            System.out.println("catch:" + i);
        } finally {
            i++;
            System.out.println("finally:" + i);
        }
        return i;
    }

    private static int testReturn3() {
        int i = 1;
        try {
            i++;
            System.out.println("try:" + i);
            int x = i / 0 ;
            return i;
        } catch (Exception e) {
            i++;
            System.out.println("catch:" + i);
            return i;
        } finally {
            i++;
            System.out.println("finally:" + i);
        }

    }

    public static void main(String[] args){

        String message = "HTTP 504 Unsatisfiable Request";
        if (message.contains("504")){
            System.out.println("contains 504");
        }
        if (true){
            return;
        }
        final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,5,1, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(50));
        for (int i = 0; i < 30; i++) {
            final int finali = i;
            System.out.println("循环i:"+i);
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        System.out.println("TAG  "+"run : "+finali+"  当前线程："+Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            threadPoolExecutor.execute(runnable);
        }

//        try {
//            for (int i = 0; i < 10; i++) {
//                try {
//                    if (i == 5) {
//                        throw new Exception("测试异常");
//                    }
//                    System.out.println("第" + i + "次运行");
//
//                } catch (Exception e) {
//                    System.out.println(e.toString());
//                }finally {
//                    System.out.println("内部 第" + i + "次运行");
//                }
//
//            }
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }finally {
//            System.out.println( "外部 运行");
//        }
        Set set = new HashSet();
        Student student = new Student();
        student.setName("1");

        Student student2 = new Student();
        student2.setName("1");
        set.add(student);
        set.add(student2);
        set.add(student);
        for (Object student1 :set){
//            System.out.println(student1.toString());
        }
        Tem1 tem1 = new Tem1();
//        tem1.letterCombinations("234");
    }
    private void test1() throws Exception {
        System.out.println("test1 ");
        test2();
    }

    private void test2() throws Exception {
        throw new Exception("Exception 1");
    }


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
        // 2 3 4
        //adg adh adi
        public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
            if (index == digits.length()) {
                combinations.add(combination.toString());
            } else {
                char digit = digits.charAt(index);
                String letters = phoneMap.get(digit);
                int lettersCount = letters.length();
                for (int i = 0; i < lettersCount; i++) {
                    combination.append(letters.charAt(i));
                    System.out.println("当前字符串:"+letters.charAt(i)+" combination:"+combination.toString());
                    backtrack(combinations, phoneMap, digits, index + 1, combination);
                    System.out.println("删除"+combination.charAt(index)+" index"+index);
                    combination.deleteCharAt(index);
                }
            }
        }


}
