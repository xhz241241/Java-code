package Sort;

import java.util.Arrays;

public class ShellSort {
    public static void shellSort(int[] arr){
        //希尔排序有专门的希尔序列:
        //如果数组长度为size
        //那么gap的序列为 size/2  size/4  size/8... size/size
        int gap = arr.length/2;
        while(gap >= 1){
            shellSort2(arr, gap);
            gap = gap/2;
        }
    }

    private static void shellSort2(int[] arr, int gap) {
        int bound = gap;
        for(; bound < arr.length; bound++){
            int val = arr[bound];
            int cur = bound-gap;
            for(; cur >= 0; cur -= gap){
                if(val < arr[cur]){
                    arr[cur+gap] = arr[cur];
                }else{
                    break;
                }
            }
            arr[cur+gap] = val;
        }
    }

    public static void main(String[] args) {
        int[] arr = {13, 24, 146, 35, 61, 15, 6, 58, 36};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
