package Test_0413;
//倒置字符串

import java.util.LinkedList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            LinkedList<Character> linkedList = new LinkedList<>();
            for(int i = s.length()-1; i >= 0; i--){
                //创建一个链表, 当前不是空格的话就把字符串里面的内容尾插到链表上
                if(s.charAt(i) != ' '){
                    char c = s.charAt(i);
                    linkedList.add(c);
                    continue;
                }
                //当前字符是空格
                //此时把链表中的内容倒着输出
                String tem = "";
                while(!linkedList.isEmpty()){
                    tem = tem + linkedList.removeLast();
                }
                System.out.print(tem + " ");
            }
            //此时已经把除了最后一个字符串之外的其他内容都输出了,
            //并把最后一个字符串的内容都添加到链表中了
            //只需要再把链表中的内容倒着输出就行
            String tem = "";
            while(!linkedList.isEmpty()){
                tem = tem + linkedList.removeLast();
            }
            System.out.print(tem);
        }
    }
}
