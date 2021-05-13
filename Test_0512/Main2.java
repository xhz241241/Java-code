package Test_0512;
//MP3光标

import java.util.*;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            String order = sc.next();
            if(n <= 4){
                less4(order, n);
            }else{
                more4(order, n);
            }
        }
    }
    public static void less4(String order, int n){
        char[] ch = order.toCharArray();
        //当前页面起始歌曲序号
        int begin = 1;
        //光标位置歌曲序号
        int cur = 1;
        for(int i = 0; i < ch.length; i++){
            //当前光标在第一首歌曲 并执行UP操作 需要把光标移到最后一首歌曲上
            if(cur == 1 && ch[i] == 'U'){
                cur = n;
            }
            //当前光标在最后一首歌曲 并执行Down操作 需要把光标移到第一首歌曲上
            else if(cur == n && ch[i] == 'D'){
                cur = 1;
            }else{
                //其余的把当前光标 ++ 或 -- 即可
                if(ch[i] == 'U'){
                    cur--;
                }else{
                    cur++;
                }
            }
        }
        //开始输出结果
        for(int i = 1; i <= n; i++){
            if(i != n){
                System.out.print(i + " ");
            }else{
                System.out.println(i);
            }
        }
        System.out.println(cur);
    }
    public static void more4(String order, int n){
        char[] ch = order.toCharArray();
        //当前页面的第一首歌曲序号
        int begin = 1;
        //当前光标位置的歌曲序号
        int cur = 1;
        for(int i = 0; i < ch.length; i++){
            //当前光标在第一页的第一首歌曲上 并执行UP操作
            if(begin == 1 && cur == 1 && ch[i] == 'U'){
                begin = n-3;
                cur = n;
            }
            //当前光标在最后一页的最后一首歌曲上 并执行Down操作
            else if(begin == n-3 && cur == n && ch[i] == 'D'){
                cur = 1;
                begin = 1;
            }
            //当前不在第一页 但是光标在当前页面的第一首歌曲上 并执行UP操作
            else if(ch[i] == 'U' && begin == cur){
                begin--;
                cur--;
            }
            //当前不在最后一页 但光标在当前页面的最后一首歌曲上 并执行Down操作
            else if(ch[i] == 'D' && begin+3 == cur){
                begin++;
                cur++;
            }else{
                //不需要换页的其他情况
                if(ch[i] == 'U'){
                    cur--;
                }else{
                    cur++;
                }
            }
        }
        //输出结果
        System.out.println(begin + " " + (begin+1) + " " + (begin+2) + " " + (begin+3));
        System.out.println(cur);
    }
}
