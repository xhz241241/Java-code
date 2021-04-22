package Test_0419;
//不要二
//核心思想就是如果当前位置的下标为arr[i][j] 那么就不能在arr[i][j+2] 和 arr[i+2][j] 的位置上放蛋糕

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int w = sc.nextInt();
            int h = sc.nextInt();
            //根据输入的行和列创建二维数组 more二维数组内的元素都是0
            int[][] arr = new int[w][h];
            int count = 0;
            //遍历二维数组, 遇到元素是 0 的计数器就+1,
            //并把该位置的欧几里得距离上的元素都设为 1
            for(int i = 0; i < w; i++){
                for(int j = 0; j < h; j++){
                    if(arr[i][j] == 0){
                        count++;
                        if(j+2 > 0) {
                            arr[i][j + 2] = 1;
                        }
                        if(i+2 >0) {
                            arr[i + 2][j] = 1;
                        }
                    }
                }
            }
            //最后返回count
            System.out.println(count);
        }
    }
}