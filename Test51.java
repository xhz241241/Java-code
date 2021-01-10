//输入
//[1,2,3,4,5]
//返回值
//[120,60,40,30,24]
import java.util.ArrayList;
import java.util.Arrays;

public class Test51 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(multiply(arr)));
    }
    public static int[] multiply(int[] A) {
        int[] tarr = new int[A.length];
        for(int i = 0; i < A.length; i++){
            int res = 1;
            int factor = 1;
            int tem = A[i];
            for(int j = 0; j < A.length; j++){
                A[i] = 1;
                factor = A[j] * factor;
            }
            tarr[i] = factor;
            A[i] = tem;
        }
        return tarr;
    }
}