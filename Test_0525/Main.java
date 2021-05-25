package Test_0525;
//淘宝网店

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            int toyear = sc.nextInt();
            int tomonth = sc.nextInt();
            int today = sc.nextInt();
            int res = 0;
            //判断是不是在同一年
            //如果前后都在同一年 那么直接后面 - 前面即可
            if(year == toyear){
                //注意后面的日要 - 1
                res = yearMoney(toyear, tomonth, today) - yearMoney(year, month, day-1);
            }else{
                //不在同一年
                //先求出开始年份的一年总利润 再减去该年直到现在的利润 就是该年剩下的利润
                //结束年份同上
                res = money(year) - yearMoney(year, month, day);
                //再加上中间隔的年数
                for(int i = year+1; i < toyear; i++){
                    res += money(i);
                }
                //最后加上结束年份的利润
                res += yearMoney(toyear, tomonth, today);
            }
            System.out.println(res);
        }
    }
    //判断是否是闰年
    //是闰年就加1天
    public static int isLeapYear(int year){
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            return 1;
        }else{
            return 0;
        }
    }
    //判断一年的利润是多少
    public static int money(int year){
        int total = 0;
        total = 31 * 2 +1* 28 +1*31 + 30 * 2 +1* 31 + 30 * 2 + 31
                + 31 * 2 + 30 * 2 + 31 * 2 + 30 + 31 * 2 + isLeapYear(year);
        return total;
    }
    //判断该月是不是素月
    public static int isPrime(int month){
        if(month == 2 || month == 3 || month == 5 || month == 7 || month == 11){
            return 1;
        }
        else{
            return 2;
        }
    }
    //计算该日期前本年的利润
    public static int yearMoney(int year, int month, int day){
        int[] arr = {62,28,31,60,31,60,31,62,60,62,30,62};
        int total = 0;
        if(month > 2){
            total += isLeapYear(year);
        }
        for(int i = 0; i < month-1; i++){
            total += arr[i];
        }
        if(isPrime(month) == 2){
            total += 2* day;
        }else{
            total += day;
        }
        return total;
    }

}