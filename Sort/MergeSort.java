package Sort;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr){
        mergeSort2(arr, 0, arr.length);
    }

    private static void mergeSort2(int[] arr, int left, int right) {
        if(right - left <= 1){
            return;
        }
        int mid = (right + left) / 2;
        mergeSort2(arr, left, mid);
        mergeSort2(arr, mid, right);
        mergr(arr, left, mid, right);
    }

    private static void mergr(int[] arr, int left, int mid, int right) {
        if(left >= right){
            return;
        }
        //需要创建一个临时数组用来辅助合并
        int[] tem = new int[right-left];
        int temindex = 0;
        int cur1 = left;
        int cur2 = mid;
        while(cur1 < mid && cur2 < right){
            if(arr[cur1] <= arr[cur2]){
                //归并排序稳定的主要原因就是这里写的是 <=
               tem[temindex] = arr[cur1];
               temindex++;
               cur1++;
            }else{
                tem[temindex] = arr[cur2];
                temindex++;
                cur2++;
            }
        }
        //循环结束后一方一定为空, 这时候我们需要把另一方全部移接到tem数组中
        while(cur1 < mid){
            tem[temindex] = arr[cur1];
            temindex++;
            cur1++;
        }
        while(cur2 < right){
            tem[temindex] = arr[cur2];
            temindex++;
            cur2++;
        }
        //最后需要把tem数组中的元素全部移回原来的数组中
        for(int i = 0; i < tem.length; i++){
            arr[left + i] = tem[i];
        }
    }

    private static void mergeSortNoR(int[] arr) {
        //设置gap作为每个组内的长度
        //初始情况每个组内只有一个元素
        //gap从1开始, 第二次为2, 第三次为4
        int gap = 1;
        for(; gap < arr.length; gap = gap * 2){
            //内层循环开始遍历数组以gap为间隔开始合并
            for(int cur = 0; cur < arr.length; cur = cur + 2 * gap){
                //要把[left, mid)和[mid, right)进行合并
                int left = cur;
                int mid = cur + gap;
                if(mid >= arr.length){
                    mid = arr.length;
                }
                int right = cur + gap * 2;
                if(right >= arr.length){
                    right = arr.length;
                }
                mergr(arr, left, mid, right);
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {13, 24, 146, 35, 61, 15, 6, 58, 36};
        mergeSort(arr);
//        mergeSortNoR(arr);
        System.out.println(Arrays.toString(arr));
    }
}
