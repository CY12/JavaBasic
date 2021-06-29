package ds;

import java.util.ArrayList;
import java.util.List;

public class SortALGO {

    public static int[] findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i =0,j=0,x=0,mid2 = -1;
        int mid = (nums1.length+nums2.length)/2;
        if (mid%2 == 1){
            mid2 = mid+1;
        }
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

    public static int[] findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length+nums2.length];
        int left = 0,right = 0;
        int aStart = 0,bStart = 0;
        for (int i = 0;i < arr.length/2+1;i++){
            left = right;
            if (aStart == nums1.length){
                arr[i] = nums2[bStart];
                right = arr[i];
                bStart++;
                continue;
            }
            if (bStart == nums2.length){
                arr[i] = nums1[aStart];
                aStart++;
                right = arr[i];
                continue;
            }
            if (nums1[aStart]<nums2[bStart]){
                arr[i] = nums1[aStart];
                aStart++;
            }else {
                arr[i] = nums2[bStart];
                bStart++;
            }
            right = arr[i];

        }

        int z=0;
        while (z < arr.length){
            System.out.print(" "+arr[z]+" ");
            z++;
        }
        return arr;
    }

    public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length+nums2.length];
        int left = 0,right = 0;
        int aStart = 0,bStart = 0;
        for (int i = 0;i < arr.length/2+1;i++){
            left = right;
            if (aStart == nums1.length){
                arr[i] = nums2[bStart];
                right = arr[i];
                bStart++;
                continue;
            }
            if (bStart == nums2.length){
                arr[i] = nums1[aStart];
                aStart++;
                right = arr[i];
                continue;
            }
            if (nums1[aStart]<nums2[bStart]){
                arr[i] = nums1[aStart];
                aStart++;
            }else {
                arr[i] = nums2[bStart];
                bStart++;
            }
            right = arr[i];

        }
        if(arr.length%2 == 1){
            return (left+right)/2.0;
        }else{
            return left;
        }
    }
    public static void main(String[] args) {
        int[]  a= {1,7,9,11,13,15,17,19};
        int[] b = {2,4,6,8,10};
        findMedianSortedArrays1(a,b);
        int[] c ={1,3};
        int[] d = {2,4};
        findMedianSortedArrays3(c,d);
    }
}
