package Sort;

import java.util.Arrays;

public class InsertSort {
    public static void insertSort(int[] arr){
        // 规定 [0, bound) 是已排序区间
        // 规定 [bound, length) 是待排序区间
        int bound = 1;
        for(; bound < arr.length; bound++){
            int val = arr[bound];
            int cur = bound -1;
            for(; cur >= 0; cur--){
                if(val < arr[cur]){
                    arr[cur+1] = arr[cur];
                }else{
                    break;
                }
            }
            arr[cur+1] = val;
        }
    }

    public static void main(String[] args) {
        int[] arr = {13, 24, 146, 35, 61, 15, 6, 58, 36};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
