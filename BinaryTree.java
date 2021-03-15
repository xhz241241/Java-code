package Tree;

class Node{
    String val;
    Node left;
    Node right;

    public Node(String val){
        this.val = val;
    }
}

public class BinaryTree {
    //创建一棵树
    public static Node setTree(){
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        e.left = g;
        return a;
    }

    // 1. 先序遍历
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    // 2. 中序遍历
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val);
        inOrder(root.right);
    }

    // 3. 后序遍历
    public static void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val);
    }

    // 4. 求节点个数
    private static int count = 0;
    public static void length(Node root){
        if(root == null){
            return;
        }
        count++;
        length(root.left);
        length(root.right);
    }

    // 4. 求节点个数(不使用局部变量)
    public static int length2(Node root){
        if(root == null){
            return 0;
        }
        return 1 + length2(root.left) + length2(root.right);
    }

    // 5. 求叶子结点个数
    public static int LeafLength = 0;
    public static void getLeafLength(Node root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null) {
            LeafLength++;
        }
        getLeafLength(root.left);
        getLeafLength(root.right);
    }

    // 5. 求叶子结点个数(不使用局部变量)
    public static int getLeafLength2(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return getLeafLength2(root.left) + getLeafLength2(root.right);
    }

    // 6. 得到第k层节点个数
    public static int getKLevelSize(Node root, int k){
        if(root == null){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        return getKLevelSize(root.left, k-1) + getKLevelSize(root.right, k-1);
    }

    // 7. 求树的最大深度
    public static int getHeigth(Node root){
        if(root == null){
            return 0;
        }
        int rightHeigth = getHeigth(root.right);
        int leftHeigth = getHeigth(root.left);
        return 1 + (Math.max(rightHeigth, leftHeigth));
    }

    // 8. 寻找某个树上的节点
    public static Node find(Node root, String tofind){
        if(root == null){
            return null;
        }
        if(root.val.equals(tofind)){
            return root;
        }
        Node res = find(root.left, tofind);
        if(res != null){
            return res;
        }
        return find(root.right, tofind);
    }

    public static void main(String[] args) {
        Node root = setTree();
//        preOrder(root);
//        inOrder(root);
//        postOrder(root);
//        length(root);
//        System.out.println(count);
//        System.out.println(length2(root));
//        getLeafLength(root);
//        System.out.println(LeafLength);
//        System.out.println(getLeafLength2(root));
//        System.out.println(getKLevelSize(root, 3));
//        System.out.println(getHeigth(root));

    }
}
