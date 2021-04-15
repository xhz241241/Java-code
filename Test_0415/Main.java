package Test_0415;
//计算糖果
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            int n4 = sc.nextInt();
            int A = (n1+n3) / 2;
            int B = (n3-n1) / 2;
            int C = (n4-n2) / 2;
            if((A-B == n1) && (B-C == n2) && (A+B == n3) && (B+C == n4)){
                System.out.println(A + " " + B + " " + C);
            }else{
                System.out.println("No");
            }
        }
    }
}
