//实现一个方法 printArray, 以数组为参数, 循环访问数组中的每个元素, 打印每个元素的值.
public class Work22 {
    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 44, 55, 66};
        int len = arr.length;
        printArray(arr, len);
    }

    public static void printArray(int[] arr, int len) {
        for(int i = 0 ; i < len; i++){
            System.out.printf("%d ", arr[i]);
        }
    }
}
