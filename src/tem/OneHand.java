package tem;

import map.Student;

import java.util.*;

public class OneHand {

    private static void mergeList(int[] arr,int[] arr2,int[] temp){
        int a = 0,b = 0,j=0;
        while (a < arr.length && b < arr2.length){
            if (arr[a] > arr2[b]){
                temp[j] = arr2[b];
                b++;
            }else {
                temp[j] = arr[a];
                a++;
            }
            j++;
        }
        if (a < arr.length){
            while ( a < arr.length){
                temp[j] = arr[a];
                a++;
                j++;
            }
        }
        if (b < arr2.length){
            while ( b < arr2.length){
                temp[j] = arr2[b];
                b++;
                j++;
            }
        }
    }
     public static class ListNode {
    int val;
     ListNode next;
    ListNode() {}
     ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    public < T extends Student> String getThing(T t){
        return t.toString();
    }

    public static void main(String[] args){
        String s = "abcdada";
        s.indexOf("a");
        System.out.print("a"+(5/2));
        System.out.print("b"+(6/2));
        String a = " ";
        System.out.println("a length"+a.length());
        int i = 1;
        int j1 = i++;
        System.out.println("j1=" + j1); // 输出 j1=1
        System.out.println("i=" + i); // 输出 i=2
        OneHand oneHand = new OneHand();
        Student student = new Student();
        student.setName("王");
        student.setAge(23);
        System.out.println(oneHand.getThing(student));
        lengthOfLongestSubstring("abcabcbb");
        lengthOfLongestSubstring1("dvdhijfsafkkkk");
//            int[] arr1 = {1,3,44,54,99};
//            int[] arr2 = {1,4,34,45,47,90,1111};
//            int[] arr3 = new int[arr1.length+arr2.length];
//            mergeList(arr1,arr2,arr3);
//        for(int i=0;i<arr3.length;i++){
//            System.out.print(arr3[i]+" ");
//        }
//        String s = "ailink-basic/api-api/service";
//        System.out.println(s.replaceFirst("-","/"));
//        String a = "xxx(-)";
//        String[] t = a.split("[(]",2);
//        System.out.println(t[0]+" t"+t.length);
//        System.out.println(t[1]+" t"+t.length);
//        System.out.println("=======");
//        String t = "你好-(私聊):喜喜喜喜:ldsd:";
//        String[] msg = t.split(":",2);
//        String head = msg[0];
//        String[] name = head.split("-");
//        System.out.println(name[1]);
        String ss = "今夕何夕兮，搴舟中流。" + "今日何日兮，得与王子同舟。" + "蒙羞被好兮，不訾诟耻。" + "心几烦而不绝兮，得知王子。";
        ss.split(",|。");

//        int[] arr = {11,44,23,67,88,65,34,48,9,12};
//        int[] tmp = new int[arr.length];    //新建一个临时数组存放
//        mergeSort(arr,0,arr.length-1,tmp);
//        for(int i=0;i<arr.length;i++){
//            System.out.print(arr[i]+" ");
//        }

    }

    public static void merge(int[] arr,int low,int mid,int high,int[] tmp){
        int i = 0;
        int j = low,k = mid+1;  //左边序列和右边序列起始索引
        while(j <= mid && k <= high){
            if(arr[j] < arr[k]){
                tmp[i++] = arr[j++];
            }else{
                tmp[i++] = arr[k++];
            }
        }
        //若左边序列还有剩余，则将其全部拷贝进tmp[]中
        while(j <= mid){
            tmp[i++] = arr[j++];
        }

        while(k <= high){
            tmp[i++] = arr[k++];
        }

        for(int t=0;t<i;t++){
            arr[low+t] = tmp[t];
        }
    }

    public static void mergeSort(int[] arr,int low,int high,int[] tmp){
        if(low<high){
            int mid = (low+high)/2;
            mergeSort(arr,low,mid,tmp); //对左边序列进行归并排序
            mergeSort(arr,mid+1,high,tmp);  //对右边序列进行归并排序
            merge(arr,low,mid,high,tmp);    //合并两个有序序列
        }
    }
//   dvdhijfsafkkkk
//    dv d
//    vdfsa  f
//    safk k
    public static int lengthOfLongestSubstring1(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                // 记录出现重复字符串的最大值
                left = Math.max(left,map.get(s.charAt(i)) + 1);
                System.out.println("left" + left + " contains" + s.charAt(i)+"  map.get(s.charAt(i))"+map.get(s.charAt(i)));
            }
            map.put(s.charAt(i),i);
            System.out.println("放入"+s.charAt(i));
            // i-left+1 记录当前最大字符串长度
            max = Math.max(max,i-left+1);
            System.out.println("max"+max);
            System.out.println();
            for (Map.Entry<Character,Integer> m:map.entrySet()){
                System.out.print(m.getKey()+""+m.getValue()+" ");
            }
            System.out.println();
        }
        return max;

    }


    public static int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
//                System.out.println("移除 "+s.charAt(i-1));
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
    public static int lengthOfLongestSubstring3(String s) {
        if (s.length()==0) {
            return 0;
        }
        HashMap<Character,Integer> hashMap = new HashMap();
        int start = 0;
        int max = 0;
        for (int i=0;i<s.length();i++){
            if (hashMap.containsKey(s.charAt(i))){
                start = hashMap.get(s.charAt(i))+1;
                hashMap.clear();
            }
            hashMap.put(s.charAt(i),i);
            max = Math.max(max,i-start+1);
        }
        return max;
    }



}
