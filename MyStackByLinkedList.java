package StackAndQueue;

//使用链表实现栈
class ListNode{
    int val;
    ListNode next;

    public ListNode(int val){
        this.val = val;
        next = null;
    }
}
public class MyStackByLinkedList {
    //此处使用的是不带傀儡节点的链表
    ListNode head = null;
    // 1. 入栈操作
    public boolean push(int val){
        ListNode newNode = new ListNode(val);
        if(head == null){
            head = newNode;
            return true;
        }
        newNode.next = head;
        head = newNode;
        return true;
    }
    // 2. 出栈操作
    public Integer pop(){
        if(head == null){
            return null;
        }
        if(head.next == null){
            int tem = head.val;
            head = null;
            return tem;
        }
        int tem = head.val;
        head = head.next;
        return tem;
    }
    // 3. 取栈顶元素
    public Integer peek(){
        if(head == null){
            return null;
        }
        return head.val;
    }
}
