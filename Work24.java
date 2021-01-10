//给定一个整型数组, 实现冒泡排序(升序排序)
public class Work24 {
    public static void main(String[] args) {
        int[] arr = {13, 24, 21, 124, 45, 67, 23, 1, 6, 75, 73, 25, 68, 100};
        int len = arr.length - 1;
        for(int bound = 0; bound <= len; bound++){
            for(int cur = len; cur > 0; cur--){
                if(arr[cur] < arr[cur-1]){
                    int tem = arr[cur];
                    arr[cur] = arr[cur-1];
                    arr[cur-1] = tem;
                }
            }
        }
        for(int i = 0; i <= len; i++){
            System.out.printf("%d ", arr[i]);
        }
    }
}
