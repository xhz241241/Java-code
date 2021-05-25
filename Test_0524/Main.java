package Test_0524;
//美国节日

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int year = sc.nextInt();
                holidayOfUsa(year);
                System.out.println();
        }
    }
    public static void holidayOfUsa(int year){
        newYear(year);
        martinglutherkingDay(year);
        presidentDay(year);
        memorialDay(year);
        celebrationDay(year);
        laberDay(year);
        thanksDay(year);
        chrismasDay(year);
    }
    //元旦
    public static void newYear(int year){
        System.out.printf("%d-01-01\n", year);
    }
    //马丁路德金日
    public static void martinglutherkingDay(int year){
        System.out.printf("%d-01-%02d\n", year, day(year, 1, 3, 1));
    }
    //总统节
    public static void presidentDay(int year){
        System.out.printf("%d-02-%02d\n", year, day(year, 2, 3, 1));
    }
    //阵亡将士纪念日
    public static void memorialDay(int year){
        int week = week(year, 6, 1);
        int day = 31 - ((week == 1) ? 6 : (week - 2));
        System.out.printf("%d-05-%02d\n", year, day);
    }
    //国庆节
    public static void celebrationDay(int year){
        System.out.printf("%d-07-04\n", year);
    }
    //劳动节
    public static void laberDay(int year){
        System.out.printf("%d-09-%02d\n", year, day(year, 9, 1, 1));
    }
    //感恩节
    public static void thanksDay(int year){
        System.out.printf("%d-11-%02d\n", year, day(year, 11, 4, 4));
    }
    //圣诞节
    public static void chrismasDay(int year){
        System.out.printf("%d-12-25\n", year);
    }

    public static int week(int year, int month, int day){
        if(month == 1 || month == 2){
            month = month + 12;
            year = year - 1;
        }
        //求出当前世纪
        int century = year / 100;
        year = year % 100;
        //根据蔡勒公式求出当前星期
        int week = year + (year / 4) + (century / 4) - 2 * century + 26
                * (month + 1) / 10 + day -1;
        week = (week % 7 + 7) % 7;
        if(week == 0){
            week = 7;
        }
        return week;
    }
    //根据星期求出几号
    public static int day(int year, int month, int count, int d_of_week){
        //求出当前月1号的星期数
        int week = week(year, month, 1);
        int day = 1 + (count - 1) * 7 + (7 + d_of_week - week) % 7;
        return day;
    }
}