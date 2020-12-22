import java.util.Scanner;

//求斐波那契数列的第n项。(迭代实现)
public class Work12 {
    public static void main(String[] args) {
        System.out.println("请输入您要求的项数:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = fibNum(n);
        System.out.printf("第 %d 项为: %d", n, res);
    }

    public static int fibNum(int n) {
        int cur = 0;
        int one = 1;
        int two = 1;
        if (n == 1 || n == 2) {
            return 1;
        }
        for(int i = 3; i <= n; i++){
            cur = one + two;
            one = two;
            two = cur;
        }
        return cur;
    }
}
