package Test_0416;
//连续最大和
import java.util.*;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            int curMax = arr[0];
            int Max = arr[0];
            for(int i = 1; i < n; i++){
                curMax = Math.max(curMax+arr[i], arr[i]);
                if(curMax > Max){
                    Max = curMax;
                }
            }
            System.out.println(Max);
        }
    }
}
