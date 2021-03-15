package StackAndQueue;

class MyCircularDeque {
    private int[] arr;
    private int capacity;
    private int head;
    private int tail;
    private int size;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        capacity = k;
        arr = new int[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(head == tail && size == capacity){
            return false;
        }
        head = (head - 1 + capacity) % capacity;
        arr[head] = value;
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(head == tail && size == capacity){
            return false;
        }
        arr[tail] = value;
        tail = (tail + 1 + capacity) % capacity;
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(head == tail && size == 0){
            return false;
        }
        head = (head + 1) % capacity;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(head == tail && size == 0){
            return false;
        }
        tail = (tail - 1 + capacity) % capacity;
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(head == tail && size == 0){
            return -1;
        }
        return arr[head];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(head == tail && size == 0){
            return -1;
        }
        return arr[(tail-1+capacity)%capacity];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        return false;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if(size == capacity){
            return true;
        }
        return false;
    }
}
