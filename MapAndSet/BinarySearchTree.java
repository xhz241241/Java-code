package MapAndSet;


class BinarySearchNode{
    int key;
    int val;
    BinarySearchNode left;
    BinarySearchNode right;

    public BinarySearchNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class BinarySearchTree {
    private static BinarySearchNode root = null;

    // 1. get
    public static Integer get(int key){
        BinarySearchNode cur = root;
        while(cur != null){
            if(key < cur.key){
                cur = cur.left;
            }
            else if(key > cur.key){
                cur = cur.right;
            }else {
                return cur.val;
            }
        }
        return null;
    }

    // 2. put
    public static void put(int key, int val){
        //判断空树的情况
        if(root == null){
            root = new BinarySearchNode(key, val);
            return;
        }
        BinarySearchNode parent = null;
        BinarySearchNode cur = root;
        // 找末尾
        while(cur != null){
            if(key < cur.key){
                parent = cur;
                cur = cur.left;
            }
            else if(key >cur.key){
                parent = cur;
                cur = cur.right;
            }else{
                //找的途中发现了相同key的元素, 直接把新的val放到旧的key中即可
                cur.val = val;
                return;
            }
        }
        //找到了末尾, 这时判断新节点要放到父亲节点的左边还是右边
        BinarySearchNode newNode = new BinarySearchNode(key, val);
        if(newNode.key < parent.key){
            parent.left = newNode;
        }else{
            parent.right = newNode;
        }
        return;
    }

    // 3. remove
    public static void remove(int key){
        //先查找该key对应的是哪个节点
        BinarySearchNode cur = root;
        BinarySearchNode parent = null;
        while(cur != null){
            if(key < cur.key){
                parent = cur;
                cur = cur.left;
            }
            else if(key > cur.key){
                parent = cur;
                cur = cur.right;
            }else{
                removeNode(parent, cur);
                return;
            }
        }
    }

    private static void removeNode(BinarySearchNode parent, BinarySearchNode cur) {
        //这里就是那三种情况
        if(cur.left == null){
            // 1.要删除的节点没有左子树
            if(cur == root){
                // 1.1 要删除的节点是根节点
                root = cur.right;
            }
            else if(cur == parent.right){
                // 1.2 要删除的节点是它父亲节点的右子树
                parent.right = cur.right;
            }else if(cur == parent.left){
                // 1.3 要删除的节点是它父亲节点的左子树
                parent.left = cur.right;
            }
        }
        else if(cur.right == null){
            // 2. 要删除的节点没有右子树
            if(cur == root){
                // 2.1 要删除的节点为根节点
                root = cur.left;
            }
            else if(cur == parent.right){
                // 2.2 要删除的节点是它父亲节点的右子树
                parent.right = cur.left;
            }else if(cur == parent.left){
                // 2.3 要删除的节点是它父亲节点的左子树
                parent.left = cur.left;
            }
        }else{
            // 3. 要删除的节点左右子树都非空
            // 3.1 先在右子树中找到最小值
            BinarySearchNode goat = cur.right;
            BinarySearchNode goatparent = cur;
            while(goat.left != null){
                goatparent = goat;
                goat = goat.left;
            }
            // 3.2 把找到的替罪羊节点的内容赋给待删除节点
            cur.key = goat.key;
            cur.val = goat.val;
            // 3.3 这时删除原来的替罪羊节点即可
            if(goat == goatparent.right){
                goatparent.right = goat.right;
            }else{
                goatparent.left = goat.right;
            }
        }
    } // removeNode end

    public static void main(String[] args) {
        put(1, 1);
        put(2, 2);
        put(3, 3);
        put(4, 4);
        put(5, 5);
        put(6, 6);
        System.out.println(get(1));
        System.out.println(get(5));
        System.out.println(get(2));
        remove(1);
        System.out.println(get(1));
    }
}
