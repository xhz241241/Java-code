package Sort;
import java.util.Arrays;

public class SelectSort {
    public static void selsctSort(int[] arr){
        int bound = 0;
        for(; bound < arr.length; bound++){
            for(int cur = bound + 1; cur < arr.length; cur++){
                if(arr[bound] > arr[cur]){
                    int tem = arr[bound];
                    arr[bound] = arr[cur];
                    arr[cur] = tem;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {13, 24, 146, 35, 61, 15, 6, 58, 36};
        selsctSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
