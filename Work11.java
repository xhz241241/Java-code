import java.util.Scanner;

//有一组数据，只有一个数字是出现一次，其他是两次，请找出这个数字。
public class Work11 {
    public static void main(String[] args) {
        //用户输入一组数据(以数组存储)
        //从数组第一个元素开始遍历,遇到和自身相同的就continue
        //直到遇到没有和自身相同的输出
        int[] arr = inputArry();
        for(int i = 0; i < 10; i++){
            int count = 0;
            for(int j = 0; j < 10; j++){
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            if(count == 1){
                System.out.println("只出现一次的数字为: " + arr[i]);
            }
        }
    }
    public static int[] inputArry(){
        System.out.println("请输入一组数据:");
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for(int i = 0 ; i < 10; i++){
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}
