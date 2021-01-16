//写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
public class Test48 {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        System.out.println(plus(a, b));
    }

    public static int plus(int a, int b) {
        while(b != 0){
            int tem = a ^ b;
            b = (a & b) << 1;
            a = tem;
        }
        return a;
    }
}
