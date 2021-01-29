import java.util.Arrays;

public class Day12 {
    public static void main(String[] args) {
        //1.递归求斐波那契数列的第 N 项
//        int num = 6;
//       System.out.println("第 " + num + " 项的值为: " + my_fib(num));
//
//        //2.写一个递归方法，输入一个非负整数，返回组成它的数字之和
//        int a =1234;
//        System.out.println("sum = : " + geshibaiqian_sum(a));
//
//        //3.递归求 1 + 2 + 3 + ... + 10
//        int b = 10;
//        System.out.println(ten_sum(b));
//
//        //4.递归求 N 的阶乘
//        int n = 5;
//        System.out.println(factor(n));

        char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(compress(chars));
        //double d = Math.cos(42);

        int[] nums = {1, 2, 3, 4};
        System.out.println(findUnsortedSubarray(nums));
    }

    public static int findUnsortedSubarray(int[] nums) {
        //先将原数组拷贝一份
        int[] oldnums = Arrays.copyOf(nums, nums.length);
        //将原数组排序
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        //分别从左和从右比较排序后的和排序前的数组是否相同
        //如果不同 记录下数字
        //最后相减+1即为结果
        while(left <= right){
            if(oldnums[left] != nums[left]){
                break;
            }
            left++;
        }
        if(left == nums.length){
            return 0;
        }
        while(right >= 0){
            if(nums[right] != oldnums[right]){
                break;
            }
            right--;
        }
        return right - left + 1;
    }

    public static int compress(char[] chars) {
        //先创建一个stringBuffer的对象, 用来拼接字符和数字
        StringBuffer stringBuffer = new StringBuffer();
        //考虑到只有一个字符的情况, 直接返回即可
        if(chars.length == 1){
            return 1;
        }
        for(int i = 0; i < chars.length-1; i++){
            int count = 1;
            //如果后者和前者相同 计数变量count+1
            while(i < chars.length-1 && chars[i] == chars[i+1]){
                i++;
                count++;
            }
            //如果count没有+1, 说明只有一个该字符, 直接把该字符拼接上即可
            if(count == 1){
                stringBuffer.append(chars[i]);
            }
            //如果有多个就要把该字符拼接上还要把个数也拼接到尾部
            else if(count > 1){
                stringBuffer.append(chars[i]);
                stringBuffer.append(count);
            }
        }
        //全部判断完毕后有两种可能
        //1.最后一个字符和倒数第二个字符相同, 这种情况不需要在拼接了
        //2.最后一个字符和倒数第二个字符不同, 那就要再把最后一个字符拼接到尾部
        if(chars[chars.length-2] != chars[chars.length-1]){
            stringBuffer.append(chars[chars.length-1]);
        }

        //最后一步需要把拼接出来的字符串转成为字符数组, 并将字符数组中的的内容搬到原数组中
        char[] tem = stringBuffer.toString().toCharArray();
        for(int j = 0; j < tem.length; j++){
            chars[j] = tem[j];
        }
        return tem.length;
    }

    public static int factor(int n) {
        if(n == 1){
            return 1;
        }
        return n * factor(n-1);
    }

    public static int ten_sum(int b) {
        if(b == 1){
            return 1;
        }
        return b + ten_sum(b-1);
    }

    public static int geshibaiqian_sum(int a) {
        if(a < 10){
            return a;
        }
        return a % 10 + geshibaiqian_sum(a / 10);
    }

    public static int my_fib(int num) {
        if(num < 0){
            return -1;
        }
        if(num < 3 && num > 0){
            return 1;
        }
        return my_fib(num-1) + my_fib(num-2);
    }
}
