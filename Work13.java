import java.util.Scanner;

//求1！+2！+3！+4！+........+n!的和
public class Work13 {
    public static void main(String[] args) {
        System.out.println("请输入一个数字: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum = sum + factorResult(i);
        }
        System.out.println(sum);
    }

    public static int factorResult(int num) {
        int res = 1;
        for(int i = 1; i <= num; i++){
            res = res * i;
        }
        return res;
    }
}
