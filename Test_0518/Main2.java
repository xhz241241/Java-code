package Test_0518;
//快到碗里来

import java.util.*;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        while(sc.hasNext()){
            //这里必须用double接收
            double cat = sc.nextDouble();
            double r = sc.nextDouble();
            if(help(cat, r)){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
    public static boolean help(double cat, double r){
        double d = 6.28 * r;
        if(d < cat){
            return false;
        }
        return true;
    }
}
