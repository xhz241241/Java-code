package Test_0414;
//字符串中找出连续最长的数字串

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String input = sc.nextLine();
            // count 表示数字串的长度
            int count = 0;
            // end 表示数字串的末尾位置
            int end = 0;
            // max 表示当前最长的字符串的长度
            int max = 0;
            for(int i = 0; i < input.length(); i++){
                if(input.charAt(i) >= '0' && input.charAt(i) <= '9'){
                    //说明该字符是数字
                    count++;
                    if(max < count){
                        max = count;
                        end = i;
                    }
                }else{
                    //该字符不是数字
                    //要把之前的数字串清空
                    count = 0;
                }
            }
            System.out.println(input.substring(end-max+1, end+1));
        }
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0){
            return 0;
        }
        //先对数组进行排序
        Arrays.sort(array);
        int count = 0;
        //如果有一个数字的出现次数超过了数组的一半
        //那么中间那个数字一定是该数字
        //需要判断中间那个数字出现的次数
        for(int i = 0; i < array.length; i++){
            if(array[i] == array[array.length/2]){
                count++;
            }
        }
        //如果中间的数字出现的次数大于数组一半的长度
        //就返回数组中间的数字
        //否则返回0
        if(count > array.length/2){
            return array[array.length/2];
        }
        return 0;
    }
}
