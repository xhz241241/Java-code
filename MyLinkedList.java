
class TwoNode{
    int val;
    TwoNode pre;
    TwoNode next;

    public TwoNode(int val){
        this.val = val;
    }
}

public class MyLinkedList {
    //双向链表需要记录收尾两个节点
    private TwoNode head;
    private TwoNode tail;
    private int length = 0;

    public MyLinkedList(){
        head = null;
        tail = null;
    }

    // 0. 求链表长度
    public int length(){
        return this.length;
    }

    // 1. 头插
    public void addFirst(int val){
        TwoNode newNode = new TwoNode(val);
        //空链表的情况
        if(head == null){
            head = newNode;
            tail = newNode;
            length++;
            return;
        }
        //非空链表
        newNode.next = head;
        head.pre = newNode;
        head = newNode;
        length++;
        return;
    }
    // 2. 尾插
    public void addLast(int val){
        TwoNode newNode = new TwoNode(val);
        //空链表情况
        if(head == null){
            head = newNode;
            tail = newNode;
            length++;
            return;
        }
        //非空链表
        tail.next = newNode;
        newNode.pre = tail;
        tail = newNode;
        length++;
        return;
    }
    // 3. 任意位置插入元素
    public void add(int index, int val){
        if(index < 0 || index > length){
            return;
        }
        if(index == 0){
            addFirst(val);
            return;
        }
        else if(index == length){
            addLast(val);
            return;
        }
        TwoNode newNode = new TwoNode(val);
        //一般情况需要先找到下标为index的节点
        TwoNode nextNode = getNode(index);
        TwoNode preNode = nextNode.pre;
        preNode.next = newNode;
        newNode.pre = preNode;
        nextNode.pre = newNode;
        newNode.next = nextNode;
        length++;
        return;
    }
    // 4. 头删
    public void deleteFirst(){
        if(head == null){
            return;
        }
        else if(head.next == null){
            head = null;
            tail = null;
            length--;
            return;
        }
        TwoNode nextNode = head.next;
        nextNode.pre = null;
        head = nextNode;
        length--;
        return;
    }
    // 5. 尾删
    public void deleteLast(){
        if(head == null){
            return;
        }
        else if(head.next == null){
            head = null;
            tail = null;
            length--;
            return;
        }
        TwoNode preNode = tail.pre;
        preNode.next = null;
        length--;
        return;
    }
    // 6. 按值删
    public void deleteByValue(int val){
        //可以找到该值对应的下标使用下标删除
        int index = indexOf(val);
        if(index == -1){
            return;
        }
        deleteByIndex(index);
        return;
    }
    // 7. 按下标删
    public void deleteByIndex(int index){
        if(index < 0 || index >= length){
            return;
        }
        if(index == 0){
            //头删
            deleteFirst();
            return;
        }
        if(index == length-1){
            deleteLast();
            return;
        }
        TwoNode cur = getNode(index);
        TwoNode preNode = cur.pre;
        TwoNode nextNode = cur.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
        length--;
        return;
    }
    // 8. 修改元素
    public void set(int index, int val){
        if(index < 0 || index >= length){
            return;
        }
        TwoNode toSet = getNode(index);
        toSet.val = val;
        return;
    }
    // 9. 查找元素
    public int indexOf(int value){
        TwoNode cur = head;
        for(int i = 0; i < length; i++){
            if(cur.val == value){
                return i;
            }
            cur = cur.next;
        }
        return -1;
    }
    // 10. 查找节点
    private TwoNode getNode(int index) {
        if(index < 0 || index > length){
            return null;
        }
        TwoNode cur = head;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        return cur;
    }
}

