import java.util.Scanner;

//求最大值方法的重载
//在同一个类中定义多个方法：
// 要求不仅可以求两个整数的最大值，还可以求两个小数的最大值，以及两个小数和一个整数的大小关系
public class Work17 {
    public static void main(String[] args) {
        System.out.println("请输入两个整形数字a, b: ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("a, b的较大者为: "+ max(a, b));//两个int
        System.out.println("请输入两个double型数字c, d: ");
        double c = sc.nextDouble();
        double d = sc.nextDouble();
        System.out.println("c, d的较大者为: "+ max(c, d));//两个double
        System.out.println("请输入一个整形数字一个double型数字e, f: ");
        int e = sc.nextInt();
        double f = sc.nextDouble();
        System.out.println("e, f的较大者为: "+ max(e, f));//一个int一个double
    }
    public static int max(int a, int b){
        return a > b ? a : b;
    }
    public static double max(double a, int b){
        if(a > b){
            return a;
        }
        return b;
    }
    public static double max(double a, double b){
        if(a > b){
            return a;
        }
        return b;
    }
}
