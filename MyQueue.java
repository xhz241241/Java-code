package StackAndQueue;

import java.util.Stack;

public class MyQueue {
    // 0. 先创建两个栈
    // 1. 让A负责入队列, B负责出队列
    private Stack<Integer> A = new Stack<>();
    private Stack<Integer> B = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        //把互换 AB 变成了入栈前把A 中的元素挪到B中
        while(!B.isEmpty()){
            int ret = B.pop();
            A.push(ret);
        }
        // 2. A入队列就用栈中的push入队列
        A.push(x);
    }

    public int pop() {
        if(A.isEmpty() && B.isEmpty()){
            return -1;
        }
        // 3.出队列要先把A中的元素挪到B中, 当A中只剩下一个元素时, 就把该元素出队列
        while(!A.isEmpty()){
            int tem = A.pop();
            B.push(tem);
        }
        return B.pop();
    }

    public int peek() {
        if(A.isEmpty() && B.isEmpty()){
            return -1;
        }
        // 3.出队列要先把A中的元素挪到B中, 当A中只剩下一个元素时, 就把该元素出队列
        while(!A.isEmpty()){
            int tem = A.pop();
            B.push(tem);
        }
        return B.peek();
    }

    public boolean empty() {
        return (A.isEmpty() && B.isEmpty());
    }
}
