package Sort;

import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int[] arr){
        //  先创建一个堆
        creatHeap(arr);
        int heapSize = arr.length;
        for(int i = 0; i < arr.length; i++){
            int tem = arr[0];
            arr[0] = arr[heapSize-1];
            arr[heapSize-1] = tem;

            heapSize--;
            shiftDown(arr, heapSize, 0);
        }
    }

    private static void creatHeap(int[] arr) {
        for(int i = ((arr.length-1)-1)/2; i >= 0; i--){
            shiftDown(arr, arr.length, i);
        }
    }

    private static void shiftDown(int[] arr, int length, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while(child < length){
            if(child + 1 < length && arr[child] < arr[child+1]){
                child = child + 1;
            }
            if(arr[child] > arr[parent]){
                int tem = arr[parent];
                arr[parent] = arr[child];
                arr[child] = tem;
            }else{
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {13, 24, 146, 35, 61, 15, 6, 58, 36};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
