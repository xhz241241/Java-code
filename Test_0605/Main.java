package Test_0605;
//解读密码


import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) <= '9' && s.charAt(i) >= '0'){
                    System.out.print(s.charAt(i));
                }
            }
            System.out.println();
        }
    }
}
