package Test_0424;
//查找组成一个偶数最接近的两个素数

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            //核心思想就是从 n 的中间向两边依次各取一个数, 相加
            //如果等于 n 那么这两个数肯定是最接近的两个素数
            int mid = n / 2;
            for(int i = 0; mid - i > 0 && mid + i < n; i++){
                if(isPrime(mid-i) && isPrime(mid+i)){
                    System.out.println(mid-i);
                    System.out.println(mid+i);
                    break;
                }
            }
        }
    }

    //判断素数函数
    public static boolean isPrime(int n){
        if(n < 2){
            return false;
        }
        if(n == 2){
            return true;
        }
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
