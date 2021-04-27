package Test_0427;
//计算日期到天数转换

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            int sum = getOutDay(year, month, day);
            System.out.println(sum);
        }
    }

    public static int getOutDay(int year, int month, int day){
        //先设置一个数组, 存储每个月的天数
        int[] arr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //还需要判断该年份是不是闰年 如果是闰年二月得加一天
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            arr[1] = 29;
        }
        //判断输入的年月日是否有效
        if(year <= 0 || month <= 0 || day <= 0){
            return -1;
        }
        //计算天数
        //比如要计算六月15号是多少天
        //就要先计算前五个月的天数之和, 再加上15
        int sum = 0;
        //所以此处要加到month-1个月即可
        for(int i = 0; i < month-1; i++){
            sum = sum + arr[i];
        }
        sum = sum + day;
        return sum;
    }
}