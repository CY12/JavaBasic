package tem;

import map.Student;

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
    public < T extends Student> String getThing(T t){
        return t.toString();
    }


    public static void main(String[] args){
        OneHand oneHand = new OneHand();
        Student student = new Student();
        student.setName("王");
        student.setAge(23);
        System.out.println(oneHand.getThing(student));
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
//        String s = "你好-(私聊):喜喜喜喜:ldsd:";
//        String[] msg = s.split(":",2);
//        String head = msg[0];
//        String[] name = head.split("-");
//        System.out.println(s);

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


}
