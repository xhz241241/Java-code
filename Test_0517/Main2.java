package Test_0517;
//数根

import java.util.*;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            //此题应该用字符串接收
            //因为数字过大
            String s = sc.next();
            while(s.length() > 1){
                int count = 0;
                //依次取到每一位 并把 0 删减掉
                for(int i = 0 ; i < s.length(); i++){
                    count = count + s.charAt(i) - '0';
                }
                //再把取到的位数赋给原来字符串继续执行
                //直到字符串中只剩下一个数字
                s = s.valueOf(count);
            }
            System.out.println(s);
        }
    }
}