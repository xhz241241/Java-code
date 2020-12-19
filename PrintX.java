import java.util.Scanner;
//输入               输出
//5     [0][0]    *   *   [0][x]
//      [1][1]     * *    [1][3]
//      [2][2]      *     [2][2]
//      [3][3]     * *    [3][1]
//      [4][4]    *   *   [4][0]


public class PrintX {
    public static void main(String[] args) {
        //用户输入数字以创建同样大小的二维数组
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {//使循环输入
            int x = sc.nextInt();
            char[][] arr = new char[x][x];

            //初始化数组全为空格
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < x; j++) {
                    arr[i][j] = ' ';
                }
            }

            //利用下标设置*
            for (int i = 0; i < x; i++) {
                int left = 0;
                int right = x - 1;
                for (; left < x && right >= 0; left++, right--) {
                    arr[i][i] = '*';//设置X的第一笔画全为*
                    arr[left][right] = '*';//设置X的第二笔画全为*
                }
            }

            //打印数组
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < x; j++) {
                    System.out.printf("%c", arr[i][j]);
                }
                System.out.println();
            }
        }
    }
}
