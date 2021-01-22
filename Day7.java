import java.util.Arrays;

public class Day7 {
    public static void main(String[] args) {
        int[] arr = {-1,-1,-1,0,1,1};
//        System.out.println(Arrays.toString(sortArrayByParity(arr)));
        System.out.println(pivotIndex(arr));
    }

    public static int pivotIndex(int[] arr) {
        int sum = 0;
        int sumleft = 0;
        for(int j = 0; j < arr.length; j++){
            sum = sum + arr[j];
        }
        for(int i = 0; i < arr.length; i++){
            if((sum-sumleft-arr[i]) == sumleft){
                return i;
            }
            sumleft = sumleft + arr[i];
        }
        return -1;
    }

    public static int[] sortArrayByParity(int[] arr) {
        int right = arr.length-1;
        int left = 0;
        while(left < right){
            //从右边起遇到奇数就跳过,直到right指向一个偶数
            while((arr[right] % 2 != 0) && left < right){
                right--;
            }
            //从左边起遇到偶数就跳过, 直到left指向一个奇数
            while((arr[left] % 2 == 0) && left < right){
                left++;
            }
            //此时right指向了一个偶数, left指向了一个奇数, 互换他俩
            int tem = arr[left];
            arr[left] = arr[right];
            arr[right] = tem;

            left++;
            right--;
        }
        return arr;
    }
}

