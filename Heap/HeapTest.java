package Heap;

public class HeapTest {
    public static void main(String[] args) {
        int[] arr = new int[100];
        MyPriorityQueue.creatHeap(arr);
        MyPriorityQueue.offer(913);
        MyPriorityQueue.offer(35);
        MyPriorityQueue.offer(5);
        MyPriorityQueue.offer(2);
        MyPriorityQueue.offer(25);
        MyPriorityQueue.offer(57);
        MyPriorityQueue.offer(24);
        MyPriorityQueue.offer(46);
        System.out.println(MyPriorityQueue.peek());
        System.out.println(MyPriorityQueue.poll());
        System.out.println(MyPriorityQueue.peek());
    }
}
