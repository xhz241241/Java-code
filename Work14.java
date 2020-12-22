import java.util.Scanner;

//求 N 的阶乘 。
public class Work14 {
    public static void main(String[] args) {
        System.out.println("请输入一个数字: ");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 1;
        for(int i = 1; i <= N; i++){
            result = result * i;
        }
        System.out.println("阶乘结果为: " + result);
    }
}
