import java.lang.reflect.Array;
import java.util.Arrays;

//实现一个方法 transform, 以数组为参数,
//循环将数组中的每个元素 乘以 2 , 并设置到对应的数组元素上.
//例如 原数组为 {1, 2, 3}, 修改之后为 {2, 4, 6}
public class Work21 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int len = arr.length;
        System.out.println(Arrays.toString(arr));
        transform(arr, len);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] transform(int[] arr, int len) {
        for (int i = 0; i < len; i++) {
            arr[i] = arr[i] * 2;
        }
        return arr;
    }
}
