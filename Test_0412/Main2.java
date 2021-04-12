package Test_0412;
//删除公共字符串

import java.util.HashMap;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            HashMap<Integer, Character> map = new HashMap<>();
            // 先把 str2 里面的内容全部放到一个 Map 中
            for(int i = 0; i < str2.length(); i++){
                map.put(i, str2.charAt(i));
            }
            // 再遍历 str1 看 str1 中的字符有没有在 str2 中出现
            // 如果没有出现就打印 str1 的内容
            for(int i = 0; i < str1.length(); i++){
                if(!map.containsValue(str1.charAt(i))){
                    System.out.print(str1.charAt(i));
                }
            }
            System.out.println();
        }
    }
}
