import java.util.Arrays;
import java.util.Scanner;

public class Day2 {
//    private static int c = 3;
//    //private修饰的全局变量不能在同包不同类中使用
//    public static void main(String[] args) {
//        int a = 1;
//        int b = 2;
//        //private修饰的全局变量只能在该类中使用 但要加static
//        //private修饰的方法可以在该类中调用
//        System.out.println(my_Sum(a, c));
//
//    }
//
//    private static int my_Sum(int a, int b) {
//        return a + b + c;
//    }
//}
//class A{
//    //private修饰的方法不能在同文件不同类中使用
////    my_Sum();
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int num = sc.nextInt();
            System.out.println(searchInsert(arr, num));
        }
//        System.out.println(removeElement(arr, 2));
//        System.out.println(Arrays.toString(arr));
    }

    public static int searchInsert(int[] arr, int target) {
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target){
                return i;
            }
        }
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(target > arr[mid]){
                left = mid + 1;
            }
            else if(target < arr[mid]){
                right = mid - 1;
            }
            else{
                return mid;
            }
        }
        return left;
    }

    public static int removeElement(int[] arr, int val) {
        int end = arr.length;
        int i = 0;
        while(i < end){
            if(arr[i] == val){
                arr[i] = arr[end-1];
                end--;
            }
            else{
                i++;
            }
        }
        return end;
    }
}
