package Test_0426;
//跳石板

import java.util.*;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] step = new int[m+1];
            for(int i = 0; i < m+1; i++){
                step[i] = Integer.MAX_VALUE;
            }
            //初始化起始位置步数为0
            step[n] = 0;
            for(int i = n; i < m; i++){
                if(step[i] == Integer.MAX_VALUE){
                    continue;
                }
                //i 表示当前石板编号
                List<Integer> list = div(i);
                //j 表示一次可以跳多少块石板
                for(int j : list){
                    //如果当前石板已经被赋值就把里面的值拿出来和当前值比较 把小的放进去
                    if(i+j <= m && step[i+j] != Integer.MAX_VALUE){
                        step[i+j] = Math.min(step[i+j], step[i]+1);
                    }else if(i+j <= m){
                        //如果当前石板没有别赋值就直接把当前值赋进去
                        step[i+j] = step[i] + 1;
                    }
                }
            }
            //还需要判断 m 号石板上有没有值 有的话输出
            //没有的话表示没走到这一步 输出-1
            if(step[m] == Integer.MAX_VALUE){
                System.out.println(-1);
            }else{
                System.out.println(step[m]);
            }
        }
    }

    //求约数
    public static List<Integer> div(int num){
        List<Integer> list = new ArrayList<>();
        //不包括 1 和 它本身
        for(int i = 2; i*i <= num; i++){
            if(num % i == 0){
                list.add(i);
                if(num / i != i){
                    list.add(num/i);
                }
            }
        }
        return list;
    }
}