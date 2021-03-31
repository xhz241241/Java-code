package MapAndSet;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class BrokenKeyboard{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            //先读取两个字符串
            //预期字符串(较长的那个)
            String expected = sc.next();
            //实际输出的字符串(较短的那个)
            String actual = sc.next();
            //然后需要全部转换成大写的
            expected = expected.toUpperCase();
            actual = actual.toUpperCase();
            //创建一个set, 用来存actual里面的内容
            Set<Character> set = new HashSet<>();
            for(int i = 0; i < actual.length(); i++){
                set.add(actual.charAt(i));
            }
            //在遍历expected 看set里面哪些不存在
            //再创建一个坏键set用来存放坏键, 防止重复坏键被输出
            Set<Character> broken = new HashSet<>();
            for(int i = 0; i < expected.length(); i++){
                char c = expected.charAt(i);
                if(set.contains(c)){
                    continue;
                }
                if(broken.contains(c)){
                    continue;
                }
                System.out.print(c);
                broken.add(c);
            }
            System.out.println();
        }
    }
}


