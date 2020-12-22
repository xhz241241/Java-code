import java.util.Scanner;

//创建方法求两个数的最大值max2，随后再写一个求3个数的最大值的函数max3。
//​ 要求：在max3这个函数中，调用max2函数，来实现3个数的最大值计算
public class Work16 {
    public static void main(String[] args) {
        System.out.println("请输入三个数字: ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println("前两者的较大者为: "+ max2(a, b));
        System.out.println("三个数的较大者为: " + max3(a, b, c));
    }
    public static int max2(int a, int b){
        return a > b ? a : b;
    }
    public static int max3(int a, int b, int c){
        if(a > b){
            return max2(a, c);
        }
        else if(a < b){
            return max2(b, c);
        }
        else if(b > c){
            return max2(a, b);
        }
        return -1;
    }
}
