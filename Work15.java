import java.util.Arrays;
import java.util.Scanner;

//调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序。
public class Work15 {
    public static void main(String[] args) {
        int[] arr = inputArry();
        System.out.println("调换顺序前: " + Arrays.toString(arr));
        int right = arr.length - 1;
        int left = 0;
        while(left < right){
            //从右边开始逐个遍历, 遇到偶数跳过,直到遇到奇数
            while(left < right && arr[right] % 2 == 0){
                right--;
            }
            //从左边开始逐个遍历, 遇到奇数跳过, 直到遇到偶数
            while(left < right && arr[left] % 2 != 0){
                left++;
            }
            //此时互换左右两个数
            int tem = arr[right];
            arr[right] = arr[left];
            arr[left] = tem;
        }
        System.out.println("调换顺序后: " + Arrays.toString(arr));

    }
    public static int[] inputArry(){
        System.out.println("请输入一组数据: ");
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for(int i = 0; i < 10; i++){
            arr[i] = sc.nextInt();
        }
        return arr;
    }

}
