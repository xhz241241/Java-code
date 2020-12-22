import java.util.Scanner;

//求和的重载
//在同一个类中,分别定义求两个整数的方法 和 三个小数之和的方法。
public class Work18 {
    public static void main(String[] args) {
        System.out.println("请输入两个整数: ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("两个整数之和为: " + sum(a, b));
        System.out.println("请输入三个小数: ");
        double c = sc.nextDouble();
        double d = sc.nextDouble();
        double e = sc.nextDouble();
        System.out.println("三个小数之和为: " + sum(c, d, e));
    }
    public static int sum(int a, int b){
        return a + b;
    }
    public static double sum(double a, double b, double c){
        return a + b + c;
    }
}
