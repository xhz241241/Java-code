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

    //数组中出现次数超过一半的数字
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
    //数组中出现次数超过一半的数字2
    //如果有一个数字出现了超过数组一半的次数的话 就成这个数字为众数 其他的叫非众数
    //我们遍历数组, 遇到一个众数和一个非众数就互相抵消, 最后剩下的一定是那个众数
    public class Solution2 {
        public int MoreThanHalfNum_Solution(int [] array) {
            if(array == null){
                return 0;
            }
            int res = array[0];
            int times = 1;
            for(int i = 1; i < array.length; i++){
                //已经开始计数了, 接下来判断当前数字和前一个是否相同
                if(times != 0){
                    //当前数字和前一个相同, 众数计数器 +1
                    if(array[i] == array[i-1]){
                        times++;
                    }else{
                        //当前数字和前一个不同, 众数计数器 -1
                        times--;
                    }
                }else{
                    //times计数器为 0 说明有一个众数和一个非众数互相抵消了
                    //就把当前数字设为新的众数
                    res = array[i];
                    times = 1;
                }
            }
            int count = 0;
            for(int i = 0; i < array.length; i++){
                if(array[i] == res){
                    count++;
                }
            }
            if(count > array.length/2){
                return res;
            }
            return 0;
        }
    }
}
