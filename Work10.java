import java.util.Scanner;

//输出一个整数的每一位，如：123的每一位是1 ， 2 ， 3
public class Work10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数:");
        int num = sc.nextInt();
        print(num);
    }
    public static void print(int num){
        if(num > 9){
            print(num / 10);
        }
        System.out.print(num % 10 + " ");
    }
}
