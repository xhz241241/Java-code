package Sort;

import java.util.Arrays;
import java.util.Stack;

public class QuickSort {
    public static void quickSort(int[] arr){
        quickSort2(arr, 0, arr.length-1);
    }

    private static void quickSort2(int[] arr, int left, int right) {
        if(left >= right){
            return ;
        }
        int index = partition(arr, left, right);
        quickSort2(arr, left, index-1);
        quickSort2(arr, index+1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        //选取基准值
        int val = arr[right];
        int l = left;
        int r = right;
        while(l < r){
            //如果基准值选的是末尾元素 那么就要先让 left 从左向右走
            //如果基准值选的是最左侧元素 那么就要先让 right 从右向左走
            while(l < r && arr[l] <= val){
                //从左往右走, 遇到比基准值小的就跳过
                //出循环时, l 指向的就是比基准值大的第一个元素
                l++;
            }
            while(l < r && arr[r] >= val){
                //从右往左走, 遇到比基准值大的就跳过
                //出循环时, r 指向的就是比基准值小的第一个元素
                r--;
            }
            //交换 l 和 r
            int tem = arr[l];
            arr[l] = arr[r];
            arr[r] = tem;
        }
        //此时 l 和 r 重合了, 就交换重合位置和基准值
        int tem = arr[right];
        arr[right] = arr[l];
        arr[l] = tem;
        //最后返回重合位置的 index
        return r;
    }

    public static void quickSortNoR(int[] arr){
        //非递归写法和先序遍历的非递归写法差不多
        //先创建一个栈
        Stack<Integer> stack = new Stack<>();
        //再把左右区间都入栈 如果先把 left 入栈就要后出 left
        stack.push(0);
        stack.push(arr.length-1);
        while(!stack.isEmpty()){
            int right = stack.pop();
            int left = stack.pop();
            if (left >= right) {
                continue;
            }
            int index = partition(arr, left, right);
            //右侧区间为 [index+1, right]
            stack.push(index+1);
            stack.push(right);
            //左侧区间为 [left, index-1]
            stack.push(left);
            stack.push(index-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {13, 24, 146, 35, 61, 15, 6, 58, 36};
//        quickSort(arr);
        quickSortNoR(arr);
        System.out.println(Arrays.toString(arr));
    }
}
