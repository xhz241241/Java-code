import java.util.Arrays;
import java.util.Scanner;

public class Day8 {
    private static void day(){
        System.out.println("day");
    }
    public static void main(String[] args) throws java.io.FileNotFoundException, java.io.IOException {
//        ((Day8)null).day();//day
//        try {
//            int[] arr = {1, 2, 3};
//            System.out.println(arr[100]);
//
//        } catch (java.lang.Exception ex) {
//
//            System.out.print("Exception!");//Exception!
//
//        }

        int[] arr = {3, 2, 1};
//        System.out.println(Arrays.toString(plusOne(arr)));
        System.out.println(thirdMax(arr));
    }

    public static int thirdMax(int[] arr) {
        long MIN = Long.MIN_VALUE;
        if(arr.length == 1){
            return arr[0];
        }
        if(arr.length == 2){
            return arr[0] > arr[1] ? arr[0] : arr[1];
        }
        long one = arr[0];
        long two = MIN;
        long third = MIN;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == one || arr[i] == two || arr[i] == third){
                continue;
            }
            if(arr[i] > one){
                third = two;
                two = one;
                one = arr[i];
            }
            else if(arr[i] > two){
                third = two;
                two = arr[i];
            }
            else if(arr[i] > third){
                third = arr[i];
            }
        }
        if(third == MIN){
            return (int)one;
        }
        return (int)third;
    }

    public static int[] plusOne(int[] arr) {
        for(int i = arr.length-1; i >= 0; i--){
            //个位数为9, 需要进位
            if(arr[i] == 9){
                arr[i] = 0;
                //还需要判断当前i是不是首元素, 若是首元素, 还需要扩容一位
                //并将首元素设置为 1
                if(i == 0){
                    arr = new int[arr.length+1];
                    arr[0] = 1;
                }
            }
            //个位数不为9, 不需要进位, 直接+1后跳出循环
            else{
                arr[i] = arr[i] + 1;
                break;
            }
        }
        return arr;
    }
}
