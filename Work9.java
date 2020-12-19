import java.util.Scanner;

//求一个整数，在内存当中存储时，二进制1的个数。
public class Work9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数:");
        int num = sc.nextInt();
        int count = 0;
        for(int i = 0; i < 32; i++){
            if(((num >> i) & 1) == 1){
                count++;
            }
        }
        System.out.println(count);
    }
}
