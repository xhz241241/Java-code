package Test_0415;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            if(m > 0 && n > 0){
                my_convert(m, n);
            }
        }
    }

    private static void my_convert(int m, int n) {
        if(n == 10){
            System.out.println(m);
            return;
        }
        //创建一个map存放16进制的字母
        Map<Integer, String> map = new HashMap<>();
        map.put(10, "A");
        map.put(11, "B");
        map.put(12, "C");
        map.put(13, "D");
        map.put(14, "E");
        map.put(15, "F");
        //创建一个栈 存放余数
        //如果是转成16进制的话栈中需要存放数字+字符
        //所以栈不标志类型
        Stack stack = new Stack<>();
        while(m > 0){
            int yushu = m % n;
            if(n < 10){
                stack.push(yushu);
            }else{
                if(yushu > 9){
                    stack.push(map.get(yushu));
                }else{
                    stack.push(yushu);
                }
            }
            m = m / n;
        }
        while (!stack.isEmpty()){
                System.out.print(stack.pop());
        }
    }
}
