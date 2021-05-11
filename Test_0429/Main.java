package Test_0429;
//扑克牌大小

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String[] s = str.split("-");
            String[] s1 = s[0].split(" ");
            String[] s2 = s[1].split(" ");
            String ss = "34567891JQKA2";
            if(str.contains("joker JOKER")){
                System.out.println("joker JOKER");
            }else if(s1.length == s2.length){
                //如果两幅手牌长度相同就比较第一位大小
                //从基准字符串中查找两幅手牌的第一个元素 进行比较
                //大的一方手牌就大
                if(ss.indexOf(s1[0].substring(0, 1)) > ss.indexOf(s2[0].substring(0, 1))){
                    System.out.println(s[0]);
                }else{
                    System.out.println(s[1]);
                }
            }else if(s1.length == 4){
                //如果两幅手牌长度不同
                //那么有炸弹的一方大
                System.out.println(s[0]);
            }else if(s2.length == 4){
                System.out.println(s[1]);
            }else{
                System.out.println("ERROR");
            }
        }
    }
}
