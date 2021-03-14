package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    // 0. 先创建两个队列
    // 1. 让A队列负责入栈, B队列负责出栈
    private Queue<Integer> A = new LinkedList<>();
    private Queue<Integer> B = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        // 2. 入栈就直接用队列中的offer入栈
        A.offer(x);
    }

    public int pop() {
        if(A.isEmpty() && B.isEmpty()){
            return -1;
        }
        // 3. 出栈需要先把A中的元素一个个都挪到B中, 当A中仅剩一个元素时, 就是该出栈元素
        while(A.size() > 1){
            int ret = A.poll();
            B.offer(ret);
        }
        int tem = A.poll();
        // 4. 出栈完毕后, 需要把B中的元素都挪回A中, 这样还是原来的分工
        swapAB();
        return tem;
    }

    private void swapAB() {
        Queue<Integer> tem = A;
        A = B;
        B = tem;
    }

    public int top() {
        //取栈顶元素和出栈差不多, 也是取到最后一个元素,
        // 但不出栈, 只返回一下, 再入栈
        if(A.isEmpty() && B.isEmpty()){
            return -1;
        }
        while(A.size() > 1){
            int ret = A.poll();
            B.offer(ret);
        }
        int tem = A.poll();
        B.offer(tem);
        swapAB();
        return tem;
    }

    public boolean empty() {
         return (A.isEmpty() && B.isEmpty());
    }
}
