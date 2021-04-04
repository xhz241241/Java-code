import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int fib = sc.nextInt();
            int one = 1;
            int two = 0;
            while(one < fib){
                int sum = one + two;
                two = one;
                one = sum;
            }
            System.out.println(Math.min(one-fib, fib-two));
        }
    }
}
