import java.util.Arrays;

public class Day9 {
    public static void main(String[] args) {
        int[] arr = {3,2,4};
        System.out.println(Arrays.toString(twoSum(arr, 6)));
    }


    public static int[] twoSum(int[] arr, int target) {
        int[] a = new int[2];
        for(int i = 0; i < arr.length; i++){
            a[0] = i;
            for(int j = 0; j < arr.length; j++){
                if(j == i){
                    continue;
                }
                if(arr[i] + arr[j] == target){
                    a[1] = j;
                    return a;
                }
            }
        }
        return a;
    }
}
