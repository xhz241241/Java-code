package Test_0511;
//字符串反转

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        while(sc.hasNext()){
            String a = sc.nextLine();
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < a.length(); i++){
                stack.push(a.charAt(i));
            }
            while(!stack.isEmpty()){
                System.out.print(stack.pop());
            }
        }
    }
}
