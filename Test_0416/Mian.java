package Test_0416;
//统计回文

import java.util.Scanner;

public class Mian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String A = sc.nextLine();
            String B = sc.nextLine();
            int count = 0;
            //遍历第一个字符串
            //把B逐个插入到A的每个缝隙中
            //每次插入完判断是否是回文
            //如果是就计数器+1
            for(int i = 0; i <= A.length(); i++){
                //因为要在String基础上插入新元素 所以要用StringBuffer可变对象
                StringBuffer newA = new StringBuffer(A);
                newA.insert(i, B);
                //但是判断回文用的是String对象 所以又要变回来
                if(isPalindromic(newA.toString())){
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static boolean isPalindromic(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
