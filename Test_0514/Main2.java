package Test_0514;
//计算字符串的距离

import java.util.*;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        while(sc.hasNext()){
            String a = sc.nextLine();
            String b = sc.nextLine();
            System.out.println(getDistance(a, b));
        }
    }
    public static int getDistance(String a, String b){
        char[] ch1 = a.toCharArray();
        char[] ch2 = b.toCharArray();
        int len1 = ch1.length;
        int len2 = ch2.length;
        //创建二维数组用来表示 字符串A的第 i 个字符到字符串B的第 j 个字符所需要的距离
        int[][] arr = new int[len1+1][len2+1];
        for(int i = 0; i <= len1; i++){
            arr[i][0] = i;
        }
        for(int j = 0; j <= len2; j++){
            arr[0][j] = j;
        }
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                //先求出插入和删除的最小值
                //再和替换进行比较
                arr[i][j] = Math.min(arr[i-1][j], arr[i][j-1]) + 1;
                //两个字符串长度相等 看是否需要替换
                if(ch1[i-1] == ch2[j-1]){
                    //两字符相等 不需要替换
                    arr[i][j] = Math.min(arr[i-1][j-1], arr[i][j]);
                }else{
                    arr[i][j] = Math.min(arr[i][j], arr[i-1][j-1]+1);
                }
            }
        }
        //最后返回从字符串A的前 len1 个字符转换到字符串B的前 len2 个字符所需要的距离
        return arr[len1][len2];
    }
}
