//public class MyLinkedListTraversal {
//    private static Node creatList() {
//        Node a = new Node(1);
//        Node b = new Node(2);
//        Node c = new Node(3);
//        Node d = new Node(4);
//        Node e = new Node(5);
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = e;
//        e.next = null;
//        return a;
//        //此处return的是a的地址, 不是a的内容
//    }
//
//    public static void main(String[] args) {
//        Node head = creatList();
//
//        // 1. 遍历链表, 打印元素
//        for(Node cur = head; cur != null; cur = cur.next){
//            System.out.println(cur.val);
//        }
//
//        // 2. 遍历链表找到链表的最后一个节点
//        Node cur = head;
//        while(cur != null && cur.next != null){
//            cur = cur.next;
//        }
//        System.out.println(cur.val);
//
//        // 3. 遍历链表, 找到倒数第二个节点
//        Node cur = head;
//        while(cur != null && cur.next != null && (cur.next.next) != null){
//            cur = cur.next;
//        }
//        System.out.println(cur.val);
//
//        // 4. 取链表的第 n 个元素
//        Node cur = head;
//        int n = 3;
//        for(int i = 1; i < n; i++){
//            cur = cur.next;
//        }
//        System.out.println(cur.val);
//
//        // 5. 获取链表长度
//        int count = 0;
//        for(Node cur = head; cur != null; cur = cur.next){
//            count++;
//        }
//        System.out.println(count);
//
//        // 6. 遍历链表, 找到倒数第 n 个元素
//        //倒数第二个元素就是正数第四个
//        //即倒数的位置是 5-2+1 即(整个链表的长度 + 1 - 该元素正数的位置)
//        //所以求倒数第 n 个元素就是, count + 1 - 正数的位置
//        int count = 0;
//        for(Node cur = head; cur != null; cur = cur.next){
//            count++;
//        }
//
//        int n = 2;
//        Node cur = head;
//        for(int i = 1; i < count+1-n; i++){
//            cur = cur.next;
//        }
//        System.out.println(cur.val);
//
//        // 7. 遍历链表, 查找链表上是否存在某个元素
//        int toSearch = 9;
//        Node cur = head;
//        for (; cur != null; cur = cur.next){
//            if(toSearch == cur.val){
//                System.out.println("找到了!");
//                break;
//            }
//        }
//        if(cur == null){
//            System.out.println("未找到!");
//        }
//
//    }
//}
