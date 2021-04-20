package Test_0420;
//求n个数中最小的k个

import java.util.*;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        //此处必须循环让list添加所有的数字
        while(sc.hasNext()) {
            list.add(sc.nextInt());
        }
        //求出最后一个数字 就是k
        int k = list.get(list.size()-1);
        //再把k删除
        list.remove(list.size()-1);
        //把所有的元素放到一个数组中
        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            arr[i] = list.get(i);
        }
        //给数组排序
        Arrays.sort(arr);
        //然后输出前k个
        //注意前k-1个后面要加空格 最后一个不要加空格
        for(int i = 0; i < k-1; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[k-1]);
    }
}