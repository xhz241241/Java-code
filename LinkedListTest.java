public class LinkedListTest {

    private static Node arrayToLinkedList(int[] arr) {
        //需要设置两个节点, 一个头节点,一个尾节点
        //初始情况下两个都为空
        Node head = null;
        Node tail = null;
        //通过for each依次把节点尾插到链表中
        for(int x : arr){
            Node newNode = new Node(x);
            //初始都为null的情况下, head和tail应该都指向同一个节点
            if (head == null) {
                head = newNode;
                tail = newNode;
            }else{
                //每次插入完毕后都要把tail更新
             tail.next = newNode;
             tail = tail.next;
            }
        }
        return head;
    }

    private static Node removeElements(Node head, int val) {
        //判断为空链表的请况
        if(head == null){
            return null;
        }
        //一般情况
        //需要注意的是,
        // 把判断头结点是否为要删除元素的代码放在前面会导致第二个节点无法被判断
        //所以要先处理一般情况, 后处理头结点
        Node pre = head;
        Node cur = head.next;
        while(cur != null){
            if(cur.val == val){
                //找到了, 开始删除元素
                pre.next = cur.next;
                cur = pre.next;
            }else{
                //没有找到, 更新 pre 的值和 cur 的值
                pre = pre.next;
                cur = cur.next;
            }
        }
        //判断链表头结点为要删除的元素的情况
        if(head.val== val){
            head = head.next;
        }
        return head;
    }

    private static Node reverseList(Node head) {
        //判断空链表
        if(head == null){
            return null;
        }
        //判断链表只有一个元素
        if(head.next == null){
            return head;
        }
        //处理一般情况
        Node newHead = null;
        Node preNode = null;
        Node curNode = head;
        while(curNode != null){
            Node nextNode = curNode.next;
            if(nextNode == null){
                //此时已经到达末尾
                newHead = curNode;
            }
            curNode.next = preNode;
            //更新位置
            preNode = curNode;
            curNode = nextNode;
        }

        return newHead;
    }

    private static void my_print(Node head) {
        for(Node cur = head; cur != null; cur = cur.next){
            System.out.println(cur.val);
        }
    }

    public static void main(String[] args) {
        // 1. 请将给定数组，转换成链表
//        int[] arr = {1, 2, 3, 4};
//        Node head = arrayToLinkedList(arr);
//        my_print(head);

        // 2. 删除链表中等于给定值 val 的所有节点。
//        Node head = MyLinkedListDelete.createList();
//        Node newHead = removeElements(head, 1);
//        my_print(newHead);

        // 3.反转一个单链表。
//        Node head = MyLinkedListDelete.createList();
//        Node newHead = reverseList(head);
//        my_print(newHead);
    }

}
