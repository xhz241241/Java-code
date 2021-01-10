//给定一个整型数组, 判定数组是否有序（递增）
public class Work25 {
    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 44, 55, 15, 66, 77, 88, 99};
        int len = arr.length;
        for(int i = 0; i < len; i++){
            if(i == len-1){
                System.out.println("该数组是递增序列~");
            }
            if(arr[i] > arr[i+1]){
                System.out.printf("第 %d 个元素不符合递增序列~", i+1);
                break;
            }
        }
    }
}
