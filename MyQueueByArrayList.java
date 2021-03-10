package StackAndQueue;

public class MyQueueByArrayList {
    private int[] arr = new int[100];
    private int size = 0;
    private int head = 0;
    private int tail = 0;

    // 1. 入队操作
    public boolean offer(int val){
        if(size == arr.length){
            return  false;
        }
        arr[tail] = val;
        size++;
        tail++;
        if(tail == arr.length){
            tail = 0;
        }
        return true;
    }
    // 2. 出队操作
    public Integer poll(){
        if(head == 0){
            return null;
        }
        int tem = arr[head];
        if(head == arr.length){
            head = 0;
        }
        size--;
        return tem;
    }
    // 3. 取队首元素
    public Integer peek(){
        if(head == 0){
            return null;
        }
        return arr[head];
    }
}
