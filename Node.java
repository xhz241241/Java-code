public class Node {
    //表示一个节点
    //节点里有两部分, 一是值(val), 二是下一个节点的地址(next)
    //需要一个构造方法, 将val传进来
    public int val;
    public  Node next;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "[" + val + "]";
    }
}
