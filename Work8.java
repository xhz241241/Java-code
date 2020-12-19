import java.util.Scanner;

//输出n*n的乘法口诀表，n由用户输入。
public class Work8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个正整数:");
        int n = sc.nextInt();
        multiplication(n);
    }

    public static void multiplication(int n){
        //按行打印, row=几就打印几行
        for(int row =1; row <= n; row++){
            multiplicationline(row);
        }
    }

    public static void multiplicationline(int row){
        //每一行里要打印的列数 row行row列
        for(int col = 1; col <= row; col++){
            System.out.printf("%d x %d = %-2d ", col, row, row*col);
        }
        System.out.println();
    }
}
