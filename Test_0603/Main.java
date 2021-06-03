package Test_0603;
//发邮件(错排问题 D(n) = (n-1) * (D(n-1) + D(n-2)) )

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(email(n));
        }
    }
    public static int email(int n){
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        return email(n-1) * (email(n-1) + email(n-2));
    }
}