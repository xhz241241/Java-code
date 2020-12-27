//实现一个方法 sum, 以数组为参数, 求数组所有元素之和.
public class Work20 {
    public static void main(String[] args) {
        int[] arr = {1, 34, 45, 5, 8, 12, 70};
        int len = arr.length;
        System.out.println("sum = :" + sum(arr, len));
    }

    public static int sum(int[] arr, int len) {
        int sum = 0;
        for (int i = 0; i < len ; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }
}
