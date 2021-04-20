package Test_0417;
//不要二
//核心思想就是如果当前位置下标为arr[i][j] 那么arr[i+2][j] 和 arr[i][j+2]位置上就不能放蛋糕
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int w = sc.nextInt();
            int h = sc.nextInt();
            int count = 0;
            //默认二维数组内都是0
            //遍历二维数组, 计算每个元素的欧几里得距离
            //并把不能放蛋糕的位置标记为1
            int[][] arr = new int[w][h];
            for(int i = 0; i < w; i++){
                for(int j = 0; j < h; j++){
                    if(arr[i][j] == 0){
                        //如果当前元素下标为0 证明该位置可以放蛋糕
                        //计数器+1
                        count++;
                        //并把当前位置元素的欧几里得距离上的元素都标记为1
                        //前提是判断有没有数组越界
                        if(i + 2 < w){
                            arr[i+2][j] = 1;
                        }
                        if(j + 2 < h){
                            arr[i][j+2] = 1;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
}
