//实现一个方法 toString, 把一个整型数组转换成字符串.
//例如数组 {1, 2, 3} , 返回的字符串为 "[1, 2, 3]",
//注意 逗号 的位置和数量.
public class Work28 {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10};
        int len = arr.length;
        System.out.println(toString(arr, len));
    }

    public static String toString(int[] arr, int len) {
        String str = "[";
        for(int i = 0; i < len-1; i++){
            str = str + arr[i] + ", ";
        }
        str += arr[len-1] + "]";
        return str;
    }
}
