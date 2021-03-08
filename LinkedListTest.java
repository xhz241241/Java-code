import java.awt.*;
import java.util.LinkedList;

public class LinkedListTest {

    private static Node arrayToLinkedList(int[] arr) {
        //需要设置两个节点, 一个头节点,一个尾节点
        //初始情况下两个都为空
        Node head = null;
        Node tail = null;
        //通过for each依次把节点尾插到链表中
        for (int x : arr) {
            Node newNode = new Node(x);
            //初始都为null的情况下, head和tail应该都指向同一个节点
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                //每次插入完毕后都要把tail更新
                tail.next = newNode;
                tail = tail.next;
            }
        }
        return head;
    }

    private static Node removeElements(Node head, int val) {
        //判断为空链表的请况
        if (head == null) {
            return null;
        }
        //一般情况
        //需要注意的是,
        // 把判断头结点是否为要删除元素的代码放在前面会导致第二个节点无法被判断
        //所以要先处理一般情况, 后处理头结点
        Node pre = head;
        Node cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                //找到了, 开始删除元素
                pre.next = cur.next;
                cur = pre.next;
            } else {
                //没有找到, 更新 pre 的值和 cur 的值
                pre = pre.next;
                cur = cur.next;
            }
        }
        //判断链表头结点为要删除的元素的情况
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }

    private static Node reverseList(Node head) {
        //判断空链表
        if (head == null) {
            return null;
        }
        //判断链表只有一个元素
        if (head.next == null) {
            return head;
        }
        //处理一般情况
        Node newHead = null;
        Node preNode = null;
        Node curNode = head;
        while (curNode != null) {
            Node nextNode = curNode.next;
            if (nextNode == null) {
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

    private static Node middleNode(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        int size = 0;
        Node cur = head;
        for (; cur != null; cur = cur.next) {
            size++;
        }
        //先找到待寻找的是链表的的几个节点
        int mid = (size / 2) + 1;
        Node newHead = head;
        //寻找第mid个节点
        for (int i = 1; i < mid; i++) {
            newHead = newHead.next;
        }
        return newHead;
    }

    private static Node FindKthToTail(Node head, int i) {
        int size = 0;
        Node cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        if (i < 0 || i > size){
            return null;
        }
        if (head == null) {
            return null;
        }
        cur = head;
        for (int j = 1; j < size - i + 1; j++) {
            cur = cur.next;
        }
        return cur;
    }

    private static Node mergeTwoLists(Node head1, Node head2) {
        Node pre = new Node(0);
        Node cur = pre;
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        //处理一般情况
        while (head1 != null && head2 != null) {
            //先把较小者放到新链表中
            if (head2.val > head1.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if (head2 != null) {
            ///把head2剩下的节点全部尾插到新链表后面
            cur.next = head2;
        } else{
            ///把head1剩下的节点全部尾插到新链表后面
            cur.next = head1;
        }
        return pre.next;
    }

    public static Node partition(Node pHead, int x) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        //创建一个小链表一个大链表(都带有傀儡节点)
        Node sCur = new Node(0);
        Node bCur = new Node(0);
        Node cur = pHead;
        Node smaller = sCur;
        Node bigger = bCur;
        while (cur != null) {
            if (cur.val < x) {
                //往小链表里面添加元素
                smaller.next = new Node(cur.val);
                smaller = smaller.next;
            } else {
                //往大链表里添加元素
                bigger.next = new Node(cur.val);
                bigger = bigger.next;
            }
            cur = cur.next;
        }
        //把小链表的尾节点设成大连表的头结点
        //把大链表的尾结点设成null
        bigger.next = null;
        smaller.next = bCur.next;
        //并返回小链表的头结点
        return sCur.next;
    }

    private static Node deleteDuplication(Node pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        Node newHead = new Node(-1);
        newHead.next = pHead;
        Node pre = newHead;
        Node cur = pHead;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return newHead.next;
    }

    private static boolean chkPalindrome(Node A) {
        if(A == null || A.next == null){
            return true;
        }
        //定义快慢指针
        Node fast = A;
        Node slow = A;
        while(fast != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //此时慢指针指向的就是链表中间节点
        //反转以中间节点为头结点的链表
        Node reversed = reverse(slow);

        //判断反转后的链表是否和原链表前半部分相等
        while(A != null && reversed != null){
            if(A.val != reversed.val){
                return false;
            }else{
                A = A.next;
                reversed = reversed.next;
            }
        }
        return true;
    }

    public static Node reverse(Node slow){
        if(slow == null || slow.next == null){
            return slow;
        }
        Node newHead = null;
        Node cur = slow;
        Node pre = null;
        while(cur != null){
            Node nextNode = cur.next;
            if(nextNode == null){
                newHead = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = nextNode;

        }
        return newHead;
    }

    private static Node getIntersectionNode(Node headA, Node headB) {
        if(headA == null || headB == null){
            return null;
        }
        Node cur1 = headA;
        Node cur2 = headB;
        while(cur1 != cur2){
//            if(cur1 == null){
//                cur1 = headB;
//            }else{
//                cur1 = cur1.next;
//            }
//            if(cur2 == null){
//                cur2 = headA;
//            }else{
//                cur2 = cur2.next;
//            }
            cur1 = cur1 == null ? headB : cur1.next;
            cur2 = cur2 == null ? headA : cur2.next;
            //三目运算符的时间复杂度比if语句低的多
        }
        return cur1;
    }

    private static boolean hasCycle(Node head) {
        if(head == null || head.next == null){
            return  false;
        }
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    private static Node detectCycle(Node head) {
        //核心算法就是分别从链表头结点开始到入环扣 和 在环内相遇的节点开始到入环口的距离相等
        //0. 判断特殊情况
        if(head == null || head.next == null){
            return null;
        }
        //1. 创建快慢指针
        Node fast = head;
        Node slow = head;
        //2. 快指针一次走两步慢指针一次走一步 记录两者相遇的点meet
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        //3.判断链表是否不带环
        if(fast == null || fast .next == null){
            return null;
        }
        //4. 分别从链表头结点和meet开始一起走相同步数, 两者相遇的点就是带环链表的入环口
        Node cur = head;
        Node meet = fast;
        while(cur != meet){
            cur = cur.next;
            meet = meet.next;
        }
        return cur;
    }

    private static void my_print(Node head) {
        for (Node cur = head; cur != null; cur = cur.next) {
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

        // 4. 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
        //    如果有两个中间结点，则返回第二个中间结点。
//        Node head = MyLinkedListDelete.createList();
//        Node newHead = middleNode(head);
//        my_print(newHead);

        // 5. 输入一个链表，输出该链表中倒数第k个结点。
//        Node head = MyLinkedListDelete.createList();
//        Node newNode = FindKthToTail(head, 2);
//        System.out.println(newNode);

        // 6. 将两个升序链表合并为一个新的 升序 链表并返回。
        //    新链表是通过拼接给定的两个链表的所有节点组成的。
//        Node head1 = MyLinkedListDelete.createList();
//        Node head2 = MyLinkedListDelete.createList2();
//        Node newHead = mergeTwoLists(head1, head2);
//        my_print(newHead);

        // 7.现有一链表的头指针 ListNode* pHead，给一定值x，
        //  编写一段代码将所有小于x的结点排在其余结点之前，
        //  且不能改变原来的数据顺序，返回重新排列后的链表的头指针。
//        Node pHead = MyLinkedListDelete.createList();
//        Node newHead = partition(pHead, 2);
//        my_print(newHead);

        // 8.在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
        // 重复的结点不保留，返回链表头指针。
        // 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
//        Node head = MyLinkedListDelete.createList();
//        my_print(deleteDuplication(head));

        // 9. 判断其是否为回文结构
//        Node head = MyLinkedListDelete.createList();
//        System.out.println(chkPalindrome(head));

        // 10. 找到两个单链表相交的起始节点。
//        Node headA = MyLinkedListDelete.createList();
//        Node headB = MyLinkedListDelete.createList2();
//        System.out.println(getIntersectionNode(headA, headB));

        // 11. 给定一个链表，判断链表中是否有环。
//        Node head = MyLinkedListDelete.createList();
//        hasCycle(head);

        // 12. 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//        Node head = MyLinkedListDelete.createList();
//        detectCycle(head);
    }


}
