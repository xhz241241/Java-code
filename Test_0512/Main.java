package Test_0512;
//洗牌

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //输入描述
        //3     (一共有三组数据)
        //3 1   (第一组 一共有 2 * 3 个数字 洗牌一次)
        //1 2 3 4 5 6
        //3 2   (第二组 一共有 2 * 3 个数字 洗牌两次)
        //1 2 3 4 5 6
        //2 2   (第三组 一共有 2 * 2 个数字 洗牌两次)
        //1 1 1 1
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int t = sc.nextInt();
            while (t > 0) {
                int n = sc.nextInt();
                int k = sc.nextInt();
                //接收第 n 组数据的前半部分
                int[] arr1 = new int[n];
                //接收第 n 组数据的后半部分
                int[] arr2 = new int[n];
                for(int i = 0; i < n; i++){
                    arr1[i] = sc.nextInt();
                }
                for(int i = 0; i < n; i++){
                    arr2[i] = sc.nextInt();
                }
                //结果数组
                int[] res = new int[2*n];
                //循环洗牌
                for(int i = 0; i < k; i++){
                    xipai(arr1, arr2, res, n);
                }
                //输出洗牌后的数组
                for(int i = 0; i < 2*n; i++){
                    if(i == 2*n-1){
                        System.out.print(res[i]);
                    }else {
                        //必须写成else不然最后一个数字会打印两次
                        System.out.print(res[i]);
                        System.out.print(" ");
                    }
                }
                t--;
                //每组之间需要换行
                if(t > 0){
                    System.out.println();
                }
            }
        }
    }

    private static void xipai(int[] arr1, int[] arr2, int[] res, int n) {
        //前半部分数组在结果数组中的下标为 0 2 4
        for(int i = 0; i < n; i++){
            res[2*i] = arr1[i];
        }
        //后半部分数组在结果数组中的下标为 1 3 5
        for(int i = 0; i < n; i++){
            res[2*i + 1] = arr2[i];
        }
        //洗第二次牌时需要先把第一次洗牌后的结果放到前后半部分的数组中
        for(int i = 0; i < 2*n; i++){
            if(i < n){
                arr1[i] = res[i];
            }else{
                arr2[i-n] = res[i];
            }
        }
    }
}
