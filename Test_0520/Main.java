package Test_0520;
//奇数位上都是奇数或者偶数位上都是偶数

public class Main {
    public static void oddInOddEvenInEven(int[] arr) {
        //核心思想就是定义两个指针 分别指向奇数位和偶数位
        //如果奇数位指针指的是偶数
        //偶数位指针指的是奇数
        //就互换两指针中的内容
        int ou = 0;
        int ji = 1;
        while(ou < arr.length && ji < arr.length){
            if(arr[ou] % 2 == 0){
                ou += 2;
            }
            if(arr[ji] % 2 == 1){
                ji += 2;
            }
            if(ou < arr.length && ji < arr.length &&
                    arr[ou] % 2 == 1 && arr[ji] % 2 == 0){
                int tem = arr[ou];
                arr[ou] = arr[ji];
                arr[ji] = tem;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        oddInOddEvenInEven(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
