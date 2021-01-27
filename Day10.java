import java.util.Arrays;

public class Day10 {
    public static void main(String[] args) {
        String str = "    ";
//        System.out.println(myAtoi(str));

        int[] arr = {};
        System.out.println(Arrays.toString(searchRange(arr, 8)));
    }

    public static int[] searchRange(int[] arr, int target) {
        int[] a = {-1,-1};
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target){
                a[0] = i;
                break;
            }
        }
        for(int i = arr.length-1; i >= 0; i--){
            if(arr[i] == target){
                a[1] = i;
                break;
            }
        }
        return a;
    }

    public static int myAtoi(String str) {
        //去掉前后的空格, 并转成字符数组
        int index= 0;
        str = str.trim();
        char[] ch = str.toCharArray();

        //判断全是空格的情况
        if(ch.length == 0){
            return 0;
        }

        //判断第一个元素正负
        int sign = 1;
        if(ch[0] == '+'){
            index++;
        }
        else if(ch[0] == '-'){
            index++;
            sign = -1;
        }

        int res = 0;
        for(; index < ch.length; index++){
            //不合法字符, 不是数字, 直接break;
            if(ch[index] > '9' || ch[index] < '0'){
                break;
            }

            if (res > Integer.MAX_VALUE / 10 ||
                    (res == Integer.MAX_VALUE / 10 && (ch[index] - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 ||
                    (res == Integer.MIN_VALUE / 10 && (ch[index] - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            res = res * 10 + sign * (ch[index] - '0');
        }
        return res;
    }
}
