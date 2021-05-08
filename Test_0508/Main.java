package Test_0508;
//统计每个月兔子的总数

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int month = sc.nextInt();
            System.out.println(getTotalCount(month));
        }
    }

    public static int getTotalCount(int month){
        if(month <= 0){
            return 0;
        }
        //第 1 2 个月的时候只有一只兔子
        if(month < 3){
            return 1;
        }
        //第三个月开始生兔子
        //列出几个月就能发现是斐波那契数列
        return getTotalCount(month-1) + getTotalCount(month-2);
    }
}