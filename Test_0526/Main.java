package Test_0526;
//剪花布条

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String a = sc.next();
            String b = sc.next();
            System.out.println(isContains(a, b));
        }
    }
    //indexOf方法
    public static int isContains(String a, String b){
        //查询字符串 b 在 a 中第一次全部包含的首位下标
        int index = a.indexOf(b, 0);
        int count = 0;
        while(index >= 0){
            count++;
            index = a.indexOf(b, b.length()+index);
        }
        return count;
    }
}