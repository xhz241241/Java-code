package Test_0527;
//收件人列表

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            //因为这里数字占了一行 需要直接读取一行再转换为数字
            //否则字符串数组会自动添加数字后面的空格作为一个字符串
            int n = Integer.parseInt(sc.nextLine());
            String[] s = new String[n];
            for(int i = 0; i < n; i++){
                s[i] = sc.nextLine();
            }
            StringBuffer stringbuffer = new StringBuffer();
            for(int i = 0; i < n; i++){
                if(i == n-1){
                    if(s[i].contains(" ") || s[i].contains(",")){
                        stringbuffer.append("\"");
                        stringbuffer.append(s[i]);
                        stringbuffer.append("\"");
                    }else{
                        stringbuffer.append(s[i]);
                    }
                }else{
                    if(s[i].contains(" ") || s[i].contains(",")){
                        stringbuffer.append("\"");
                        stringbuffer.append(s[i]);
                        stringbuffer.append("\"");
                        stringbuffer.append(", ");
                    }else{
                        stringbuffer.append(s[i]);
                        stringbuffer.append(", ");
                    }
                }
            }
            System.out.println(stringbuffer);
        }
    }
}