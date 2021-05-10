package Test_0508;
//字符串通配符

import java.util.*;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        while(sc.hasNext()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            System.out.println(isTrue(str1, str2));
        }
    }

    public static boolean isTrue(String str1, String str2){
        //例如
        //t?t*.*
        //txtl2.xls
        int i = 0;
        int j = 0;
        boolean flag = false;
        while(i != str1.length() && j != str2.length()){
            //依次判断两个字符串的每一位是否相同
            if(str1.charAt(i) == str2.charAt(j)){
                //相同就都 ++
                i++;
                j++;
            }else{
                //不同的话分为三种情况
                if(str1.charAt(i) == '?'){
                    //1.
                    //第一个字符串是通配符 ?
                    //此时对应第二个字符串匹配一个字符
                    //所以 i 和 j 都++即可
                    i++;
                    j++;
                }else if(str1.charAt(i) == '*'){
                    //2.
                    //第一个字符串是通配符 *
                    //此时对应第二个字符串匹配多个字符
                    //此时 i 先++
                    //然后把标识符替换为 true
                    //依次遍历第二个字符串
                    //直到找到一个和第一个字符串相同的字符
                    //再换为 false
                    i++;
                    flag = true;
                }else if(flag){
                    //进行遍历操作
                    //直到再第二个字符串中找到
                    //和第一个字符串相同的字符才退出循环
                    //并把标识符设为false
                    while(str1.charAt(i) != str2.charAt(j)){
                        j++;
                    }
                    flag = false;
                }else{
                    //3.
                    //既不是 ? 也不是 *
                    //此时直接返回false即可
                    return false;
                }
            }
        }
        //如果遍历了一圈还没有触发false
        //那么就可以返回true
        return true;
    }
}