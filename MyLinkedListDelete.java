
public class MyLinkedListDelete {
    //创建一个不带傀儡节点的链表
    public static Node createList() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;
        return a;
    }

    //创建一个带傀儡节点的链表
    //所以该链表的头结点是傀儡节点, 不能对傀儡节点进行打印输出
    public static Node createListWithDummy(){
        Node dummy = new Node(0);
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        dummy.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;
        return dummy;
    }

    //尾插一个节点
    public static Node insertTail(Node head, int val){
        Node newNode = new Node(val);
        if(head == null){
            //如果为空链表的话直接把新增的节点作为头结点返回
            return newNode;
        }
        //找到尾节点
        Node cur = head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = newNode;
        return head;
    }

    //删除节点, 根据元素内容删除
    public static void remove(Node head, int val){
        Node pre = head;
        while(pre != null && pre.next != null && pre.next.val != val){
            pre = pre.next;
        }
        //此时指向的就是要删除元素前面一个节点
        //还需判断输入的值是否有效, 如果在链表中找不到对应的节点, 那就说明输入无效
        if(pre == null && pre.next == null){
            return;
        }
        //开始删除操作
        Node toDelete = pre.next;
        pre.next = toDelete.next;
    }

    //删除节点, 按照位置删除
    public static void remove(Node head, Node toDelete){
        //还是需要找到待删除元素的前一个节点
        Node pre = head;
        while(pre != null && pre.next != toDelete){
            pre = pre.next;
        }
        //也需要判断不存在的情况
        if(pre == null){
            return;
        }
        pre.next = toDelete.next;
    }

    //删除节点, 时间复杂度为O(1)
    public static void remove_2(Node head, Node toDelete){
        Node nextNode = toDelete.next;
        toDelete.next = nextNode.next;
        toDelete.val = nextNode.val;
    }

    //删除节点, 按照下标删除
    public static void remove_3(Node head, int index){
        if(index < 0 || index >= size(head)){
            return;
        }
        if(index == 0){
        //在头部删除元素, 下面会有
        }
        Node pre = head;
        for(int i = 0; i < index-1; i++){
            pre = pre.next;
        }
        //开始删除
        Node toDelete = pre.next;
        pre.next = toDelete.next;
    }

    public static int size(Node head) {
        int size = 0;
        for(Node cur = head; cur != null; cur = cur.next){
            size++;
        }
        return size;
    }

    public static void my_print(Node head) {
        for(Node cur = head; cur != null; cur = cur.next){
            System.out.println(cur.val);
        }
    }

    public static void my_printWithDummy(Node head) {
        for(Node cur = head.next; cur != null; cur = cur.next){
            System.out.println(cur.val);
        }
    }

    public static void main(String[] args) {
//        Node head = createList();

        //不带傀儡节点, 往链表中间插入元素
//        Node newNode = new Node(999);//待插入的元素
//        Node pre = head;
//        newNode.next = pre.next;
//        pre.next = newNode;
//        my_print(head);

        //不带傀儡节点, 往链表头部插入元素
//        Node newNode = new Node(999);
//        newNode.next = head;
//        head = newNode;
//        my_print(head);

        //不带傀儡节点, 向链表尾部插入元素
//        insertTail(head, 999);
//        my_print(head);

        //不带傀儡节点, 删除链表中间元素(通过值删除)
//        remove(head, 2);
//        my_print(head);

        //不带傀儡节点, 删除链表中间元素(按照位置删除)
//        remove(head, head.next.next);
//        my_print(head);

        //不带傀儡节点, 删除链表中间元素, 时间复杂度为O(1)
//        remove_2(head, head.next.next.next);
//        my_print(head);

        //不带傀儡节点, 删除链表中间元素(按照下标删除)
//        remove_3(head, 3);
//        my_print(head);

        //带傀儡节点, 往链表头部插入元素
//        Node head = createListWithDummy();

//        Node newNode = new Node(100);
//        Node pre = head.next;
//        newNode.next = pre.next;
//        pre.next = newNode;
//        my_printWithDummy(head);

        //带傀儡节点, 往链表头部插入元素
//        Node newNode = new Node(100);
//        Node pre = head;
//        newNode.next = pre.next;
//        pre.next = newNode;
//        my_printWithDummy(head);

    }
}
