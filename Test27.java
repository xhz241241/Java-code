//大家都知道斐波那契数列，现在要求输入一个整数n，
// 请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
//输入
//4
//返回值
//3
public class Test27{
    public static void main(String[] args) {

    }
    public  int Fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (n > 1) {
            int one = 1;
            int two = 0;
            int sum = 0;
            for (int i = 2; i <= n; i++) {
                sum = one + two;
                two = one;
                one = sum;
            }
            return sum;
        }
        return -1;
    }
}