package StackAndQueue;

public class MyQueueByLinkedList {
    //使用链表实现队列
    ListNode head = null;
    ListNode tail = null;

    // 1. 入队操作
        public boolean offer(int val){
             ListNode newNode = new ListNode(val);
             if(head == null){
                 head = newNode;
                 tail = newNode;
                 return true;
             }
             tail.next = newNode;
             tail = tail.next;
             return true;
        }
    // 2. 出队操作
        public Integer poll(){
            if(head == null){
                  return null;
            }
            int tem = head.val;
            if(head.next == null){
                  head = null;
                  return tem;
            }
            head = head.next;
            return tem;
        }
    // 3. 取队首元素
        public Integer peek(){
            if(head == null){
                return null;
            }
            return head.val;
        }
}
