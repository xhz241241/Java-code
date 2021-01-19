import java.util.Arrays;

public class Day4 {
//    static boolean n;
//    private float f = 1.0f;
//    int m = 12;
//    static int l = 1;
//    static{
//        l += 9;
//    }

    public static void main(String[] args) {
//        String s;
//        System.out.println("s" + s);//Error:(4, 28) java: 可能尚未初始化变量
//        System.out.println(n);//未设置初始值时 默认为false
//        Day4 d = new Day4(88);
//        d.f = d.m;//带有static关键字的变量不能被对象调用
//        System.out.println(d.f);
//        System.out.println(l);

//1. 给定整型数组, 把所有的偶数放到数组前面, 把所有奇数放到数组后面.
//        int[] arr = {1, 3, 12, 6, 3, 8, 13};
//        System.out.println("转换后: " + Arrays.toString(sortArray(arr)));

//2. 给定两个整型数组, 交换两个数组的内容.
//        int[] arr1 = {11, 22, 33, 44};
//        int[] arr2 = {55, 66, 77, 88};
//        System.out.println("arr1 交换前: " + Arrays.toString(arr1));
//        my_Swap(arr1, arr2);
//        System.out.println("arr1 交换后: " + Arrays.toString(arr2));
//      int i = 3;
//      switch(i){
//          case 1:
//              i++;
//          case 2:
//              i++;
//          case 3:
//              i++;
//          default :
//              i++;
//      }
//        System.out.println(i);//5
        //不执行 i 之前的语句

//        String s = "a ";
//        System.out.println(lengthOfLastWord(s));

        int m = 3;
        int n = 3;
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, m, nums2, n);

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //将nums2的内容拼接到nums1后
        int j = 0;
        for(int i = m; i < m+n; i++){
            for(; j < n; ){
                nums1[i] = nums2[j];
                j++;
                break;
            }
        }
        //排序nums1
        //[1, 2, 3, 2, 5, 6]
        int len = m+n-1;
        for(int bound = 0; bound <= len; bound++){
            for(int cur = len; cur > bound; cur--){
                if(nums1[cur] < nums1[cur-1]){
                    int tem = nums1[cur];
                    nums1[cur] = nums1[cur-1];
                    nums1[cur-1] = tem;
                }
            }
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static int lengthOfLastWord(String s) {
        //先去掉首和尾的空格
        s = s.trim();
        char[] ch = s.toCharArray();
        for(int i = s.length()-1; i >= 0; i--){
            if(ch[i] == ' '){
                return s.length()-1 - i;
            }
        }
        return s.length();
    }

    public static int[] my_Swap(int[] arr1, int[] arr2) {
        for(int i = 0; i < arr1.length; i++){
            arr1[i] = arr2[i];
        }
        return arr1;
    }

    public static int[] sortArray(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            //当arr[left]能被2整除时, 则为偶数 跳过, 指向奇数时停下
            while((arr[left] % 2) == 0 && left < right){
                left++;
            }
            //当arr[left]能被2整除时, 则为奇数 跳过, 指向偶数时停下
            while((arr[right] % 2) != 0 && right > left){
                right--;
            }
            //此时left指向一个奇数, right指向一个偶数, 互换两个数
            int tem = arr[left];
            arr[left] = arr[right];
            arr[right] = tem;

        }
        return arr;
    }
//    static{
//        l /= 3;
//    }
//    Day4(int a) {
//
//        f=a;
//
//    }
}
