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

// 2. 双指针解法
//
//import java.util.*;
//
//public class Main{
//    public static void main(String[] args){
//        Scanner sc = new Scanner (System.in);
//        while(sc.hasNext()){
//            String s = sc.nextLine();
//            int left = 0;
//            int right = s.length()-1;
//            char[] arr = s.toCharArray();
//            while(left < right){
//                char tem = arr[left];
//                arr[left] = arr[right];
//                arr[right] = tem;
//                left++;
//                right--;
//            }
//            System.out.println(arr);
//        }
//    }
//}