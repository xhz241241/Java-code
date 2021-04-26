package Test_0421;
//颠倒数字

//import java.util.*;
//
//public class Main2{
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int n = sc.nextInt();
//            String s = "";
//            while(n != 0){
//                //取到最后一位
//                int a = n % 10;
//                //把原来的数字去掉最后一位
//                int b = n / 10;
//                //把数字 a 转换成字符串再添加到 s 后面
//                s = s + String.valueOf(a);
//                n = b;
//            }
//            System.out.println(s);
//        }
//    }
//}

import java.util.*;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            StringBuffer stringbuffer = new StringBuffer();
            while(n != 0){
                int a = n % 10;
                int b = n / 10;
                stringbuffer.append(a);
                n = b;
            }
            System.out.println(stringbuffer.toString());
        }
    }
}