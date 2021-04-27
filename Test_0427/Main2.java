package Test_0427;
//幸运的袋子

import java.util.*;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            System.out.println(dfs(0, 0, 1, arr, n));
        }
    }

    public static int dfs(int index, int sum, long mul, int[] arr, int len){
        int res = 0;
        for(int i = index; i < len; i++){
            sum += arr[i];
            mul *= arr[i];
            if(sum > mul){
                res = 1 + res + dfs(i+1, sum, mul, arr, len);
            }
            else if(arr[i] == 1){
                res = res + dfs(i+1, sum, mul, arr, len);
            }
            else{
                break;
            }
            sum = sum - arr[i];
            mul = mul / arr[i];
            //while循环做的就是剪枝的工作
            while(i + 1 < len && arr[i] == arr[i+1]){
                i++;
            }
        }
        return res;
    }
}
