import java.lang.String;
import java.util.Arrays;

public class Day1 {
    public static void main(String[] args) {
//        int a = 20;
//        int b = 5;
//        System.out.println(a + b + " " + (a + b)+b);//25 255
//        int a = 1234;
//        System.out.println(a % 10);
//        System.out.println(a / 10);
//        String str = "HELLO";
//        toLowerCase(str);
//        System.out.println(toLowerCase(str));
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(rotate(arr, k)));
    }

    public static int[] rotate(int[] arr, int k) {
        if(k <= 0){
            return arr;
        }
        //大概思路就是把数组想象成一个环 一直将前一个元素赋给后一个元素 遇到首元素时单独处理
        for(int count = 0; count < k; count++) {
            int i = arr.length-1;
            int tem = arr[arr.length-1];
            for (; i > 0; i--) {
                arr[i] = arr[i-1];
            }
            if (i == 0) {
                arr[0] = tem;
            }
        }
        return arr;
    }

    public static String toLowerCase(String str) {
        if(str == null){
            return str;
        }
        //java里面不能直接用str[] 只能先转换成数组, 再通过数组下标逐个判断大小写
        char[] ch = str.toCharArray();
        for(int i = 0; i < str.length(); i++){
            //当元素在大写字母范围内, 逐个+32, 就变成小写字母了
            if(ch[i] >= 'A' && ch[i] <= 'Z'){
                ch[i] += 32;
            }
        }
        //返回值是string 所以要将刚刚的数组再次转成字符串才能返回
        return String.copyValueOf(ch);
    }
}
