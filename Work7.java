import java.util.Scanner;

//求两个正整数的最大公约数
public class Work7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入两个正整数:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = a > b ? b : a;
        for(int i = c; i >= 1; i--){
            if(a % i == 0 && b % i == 0){
                System.out.println("最大公约数为: " + i);
                break;
            }
        }
    }
}
