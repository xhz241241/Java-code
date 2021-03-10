package StackAndQueue;

public class MyStackByArrayList {
    //使用顺序表实现栈
    private int[] arr = new int[100];
    private int size = 0;

    // 1. 入栈操作
    public boolean push(int val){
        if(size >= arr.length){
            return false;
        }
        arr[size] = val;
        size++;
        return true;
    }
    // 2. 出栈操作
    public Integer pop(){
        if(size == 0){
            return null;
        }
        int tem = arr[size-1];
        size--;
        return tem;
    }
    // 3. 取栈顶元素
    public Integer peek(){
        if(size == 0){
            return null;
        }
        return arr[size-1];
    }
}
