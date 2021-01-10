import java.util.Scanner;

//给定一个有序整型数组, 实现二分查找
public class Work26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您要查找的数字: ");
        while(sc.hasNextInt()){
            int[] arr = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65};
            int len = arr.length;
            int left = 0;
            int right = len - 1;
            int toGuess = sc.nextInt();
            while(left <= right){
                int mid = (right + left) / 2;
                if(toGuess < arr[mid]){
                    right = mid - 1;
                }
                else if(toGuess > arr[mid]){
                    left = mid + 1;
                }
                else{
                    System.out.println("找到了!");
                    break;
                }
            }
            if(left > right){
                System.out.println("该数组中没有该数字!");
            }
        }
    }
}
