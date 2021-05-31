package Test_0531;
//数据库连接池

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            //下面这行代码是必须的
            //要读完数字后面的空格
            sc.nextLine();
            String[] s = new String[n];
            for(int i = 0; i < n; i++){
                s[i] = sc.nextLine();
            }
            System.out.println(count(s, n));
        }
    }
    public static int count(String[] s, int n){
        int res = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            String[] ss = s[i].split(" ");
            if(ss[1].equals("connect")){
                res++;
                if(res > max){
                    max = res;
                }
            }else if(ss[1].equals("disconnect")){
                res--;
            }
        }
        return max;
    }
}