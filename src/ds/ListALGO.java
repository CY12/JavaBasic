package ds;

import java.util.ArrayList;
import java.util.List;

public class ListALGO {
    // 返回列表中最大元素与最小元素之差
    public static int gap(List<Integer> list) {
        if (list.size() < 1) {
            return 0;
        }
        int max = list.get(0);
        int min = list.get(0);
        for (Integer integer : list) {
            if (max < integer) {
                max = integer;
            }
            if (min > integer) {
                min = integer;
            }
        }
        return max - min;
    }
    // 反转列表
    public static void reverse(List<Integer> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            int temp = list.get(i);
            list.set(i, list.get(list.size() - i - 1));
            list.set(list.size() - i - 1, temp);
        }
    }
    // 打印列表
    public static void print(List<Integer> list){
        for (Integer integer:list){
            System.out.print(integer+" ");
        }
    }
    // 选择排序
    public static void selectSort(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(min) > list.get(j)) {
                    min = j;
                }
            }
            if (min != i){
                int temp = list.get(i);
                list.set(i, list.get(min));
                list.set(min, temp);
            }
        }
    }
    // 冒泡排序
    public static void bubbleSort(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
    // 归并排序
    public static int[] mergeSort(int[] nums1, int[] nums2) {
        int i =0,j=0,x=0;
        int[] arr = new int[nums1.length+nums2.length];
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] < nums2[j]){
                arr[x] = nums1[i];
                i++;
            }else {
                arr[x] = nums2[j];
                j++;
            }
            x++;
        }
        if ( i == nums1.length){
            while (j < nums2.length){
                arr[x] = nums2[j];
                x++;
                j++;
            }
        }else if  ( j == nums2.length){
            while (i < nums1.length){
                arr[x] = nums1[i];
                x++;
                i++;
            }
        }

        int z=0;
        while (z < arr.length){
            System.out.print(" "+arr[z]+" ");
            z++;
        }
        return arr;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(11);
        list.add(1);
        list.add(22);
        list.add(2);
        System.out.println("初始值:");
        print(list);
        System.out.println("差值  "+gap(list));
        System.out.println("反转后:");
        reverse(list);
        print(list);
        System.out.println("选择排序:");
//        bubbleSort(list);
        selectSort(list);
        print(list);
    }
}
