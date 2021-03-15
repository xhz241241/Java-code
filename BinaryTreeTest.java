package Tree;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val, TreeNode left, TreeNode right) {
         this.left = left;
         this.right = right;
    }
}

public class BinaryTreeTest {
    // 1. 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(q.val != p.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // 2. 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
    // s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null){
            return false;
        }
        boolean ret = isSameTree(s, t);
        if(ret){
            return ret;
        }
        return isSubtree(s.left, t.left) || isSubtree(s.right, t.right);
    }

}
