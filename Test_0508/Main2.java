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
        //t?t*.*
        //txtl2.xls
        int i = 0;
        int j = 0;
        boolean flag = false;
        while(i != str1.length() && j != str2.length()){
            if(str1.charAt(i) == str2.charAt(j)){
                i++;
                j++;
            }else{
                if(str1.charAt(i) == '?'){
                    i++;
                    j++;
                }else if(str1.charAt(i) == '*'){
                    if(i == str1.length()){
                        break;
                    }
                    ++i;
                    flag = true;
                }else if(flag){
                    while(str1.charAt(i) != str2.charAt(j)){
                        ++j;
                    }
                    flag = false;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}