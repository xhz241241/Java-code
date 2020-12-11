//给定一个数字，判定一个数字是否是素数
import java.util.Scanner;

public class Work4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个待判断的数字: ");
        int num = sc.nextInt();

        int i = 0;
        for(i = 2; i < num; i++){
            if(num % i == 0){
                break;
            }
        }
        if(i == num){
            System.out.println("是素数");
        }else{
            System.out.println("不是素数");
        }
    }
}
