package Sort;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] arr){
        for(int bound = 0; bound < arr.length; bound++){
            for(int cur = arr.length-1; cur > bound; cur--){
                if(arr[cur] < arr[cur-1]){
                    int tem = arr[cur];
                    arr[cur] = arr[cur-1];
                    arr[cur-1] = tem;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {13, 24, 146, 35, 61, 15, 6, 58, 36};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
