import java.util.Arrays;

//创建一个 int 类型的数组, 元素个数为 100, 并把每个元素依次设置为 1 - 100
public class Work23 {
    public static void main(String[] args) {
        int n = 100;
        int[] arr = new int[n];
        setArray(arr, n);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] setArray(int[] arr, int n) {
        for (int i = 1; i <= n; i++) {
            arr[i-1] = i;
        }
        return arr;
    }
}
