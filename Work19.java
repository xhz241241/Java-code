//实现一个方法 avg, 以数组为参数, 求数组中所有元素的平均值(注意方法的返回值类型).
public class Work19 {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 6, 1, 9};
        int len = arr.length;
        System.out.println(avg(arr, len));
    }

    public static double avg(int[] arr, int len) {
        int sum = 0;
        for(int i = 0; i < len; i++){
            sum += arr[i];
        }
        double res = (double)sum / len;
        return res;
    }
}
