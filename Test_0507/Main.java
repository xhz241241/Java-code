package Test_0507;
//iNOC产品部-杨辉三角形变形

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[][] arr = new int[n][n*2+1];
            //       1
            //     1 1 1
            //   1 2 3 2 1
            // 1 3 6 7 6 3 1
            //第一行的 1 处于第 4 列上所以第一行的下标应该是
            arr[0][n] = 1;
            for(int i = 1; i < n; i++){
                for(int j = 1; j < (2*n+1)-1; j++){
                    arr[i][j] = arr[i-1][j] + arr[i-1][j-1] + arr[i-1][j+1];
                }
            }
            int res = -1;
            //求第 n 行 在数组中处于第 n-1 行
            for(int i = 1; i < (n*2+1)-1; i++){
                if(arr[n-1][i] % 2 == 0){
                    res = i;
                    break;
                }
            }
            if(res == -1) {
                System.out.println(-1);
            }else{
                System.out.println(res);
            }
        }
    }
}