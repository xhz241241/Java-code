import java.lang.reflect.Array;
import java.util.Arrays;

public class Day6 {
    public static void main(String[] args) {
       int[] arr = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(arr)));

        String s = "7_28]";
        System.out.println(reverseOnlyLetters(s));
    }

    public static String reverseOnlyLetters(String s) {
        char[] ch = s.toCharArray();
        int right = ch.length-1;
        int left = 0;
        while(left < right){
            //当left指向的是一个非字母的元素时跳过, 要特别注意字符串全为非字母的情况, 要加上left<right
            while(!Character.isLetter(ch[left]) && left < right){
                left++;
            }
            //当right指向一个不是字母的元素是跳过, 也要注意加上right>left
            while(!Character.isLetter(ch[right]) && right > left){
                right--;
            }
            //此时right和left指向的都是一个字母, 互换
            char tem = ch[left];
            ch[left] = ch[right];
            ch[right] = tem;
            left++;
            right--;
        }
        return String.valueOf(ch);
    }

    public static int[] sortedSquares(int[] arr) {
        if(arr.length == 0){
            return arr;
        }
        for(int i = 0; i < arr.length; i++){
            arr[i] = arr[i] * arr[i];
        }
        Arrays.sort(arr);
        return arr;
    }
}
