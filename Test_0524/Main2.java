package Test_0524;
//分解因数

import java.util.*;

public class Main2{
    public static void main(String[] args){
        Scanner sc =  new Scanner (System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            System.out.print(n + " " + "=" + " ");
            for(int i = 2; i < n; i++){
                    while(n % i == 0 && i != n){
                        System.out.print(i + " " + "*" + " ");
                        n = n / i;
                    }
            }
            System.out.println(n);
        }
    }
}
