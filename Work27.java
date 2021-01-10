import java.util.Arrays;

//实现一个方法 copyOf, 对一个整型数组进行拷贝, 得到一个新的数组.
public class Work27 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int len = arr.length;
        System.out.println("旧数组: " + Arrays.toString(arr));
        System.out.println("==============================");
        System.out.println("新数组: " + Arrays.toString(copyOf(arr, len)));
    }

    public static int[] copyOf(int[] arr, int len) {
        int[] tarr = new int[len];
        for(int i = 0; i < len; i++){
            tarr[i] = arr[i];
        }
        return tarr;
    }
}
