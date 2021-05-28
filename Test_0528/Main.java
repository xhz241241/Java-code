package Test_0528;
//年会抽奖

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            float f = factor(n);
            float cuopai = count(n);
            float res = cuopai / f * 100;
            System.out.printf("%.2f%%", res);
            System.out.println();
        }
    }
    public static float factor(int n){
        float res = 1;
        if(n == 0){
            return 1;
        }
        else if(n > 0){
            res = n * factor(n-1);
        }
        return res;
    }

    public static float count(int n){
        if(n == 1){
            return 0;
        }
        else if(n == 2){
            return 1;
        }
        return (n-1) * (count(n-1) + count(n-2));
    }
}
