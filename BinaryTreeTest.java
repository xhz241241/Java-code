package Tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
         this.val = val;
    }
}

public class BinaryTreeTest {

    public static TreeNode setTree(){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
//        c.right = f;
        c.left = g;
        return a;
    }

    // 1. 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
    public static boolean isSameTree(TreeNode p, TreeNode q) {
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
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null){
            return false;
        }
        boolean ret = isSameTree(s, t);
        if(ret){
            return ret;
        }
        return isSubtree(s.left, t.left) || isSubtree(s.right, t.right);
    }

    // 3. 给定一个二叉树，判断它是否是高度平衡的二叉树。
    public static boolean isBalanced(TreeNode root) {
        // 0. 判断特殊情况
        if(root == null){
            return true;
        }
        if(root.left == null &&root.right == null){
            return true;
        }

        // 1. 求出左右子树的高度
        int rightHeigh = getHeigh(root.right);
        int leftHeigh = getHeigh(root.left);
        // 2. 做差, 判断差值是否大于1
        // 3. 如果不大于1 就继续遍历左右子树
        // 4. 大于1直接返回false
        if(leftHeigh - rightHeigh > 1 || leftHeigh - rightHeigh < -1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public static int getHeigh(TreeNode root){
        if(root == null){
            return 0;
        }
        int right = getHeigh(root.right);
        int left = getHeigh(root.left);
        return 1 + (Math.max(right, left));
    }

    // 4. 给定一个二叉树，检查它是否是镜像对称的。
    public static boolean isSymmetric(TreeNode root) {
        // 判断是否是镜像的有两条准则
        // . 左子树的左子树和右子树的右子树必须相等
        // . 左子树的右子树和右子树的左子树必须相等

        // 0. 判断特殊情况
        if(root == null){
            return true;
        }
        return isMirror(root.left, root.right);
    }
    public static boolean isMirror(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        // 1. 判断条件
        if(p.val != q.val){
            return false;
        }
        return isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }

    // 5.  二叉树的层序遍历
    public static void levelOrder(TreeNode root){
        // 0.判断特殊情况
        if(root == null){
            return;
        }
        // 1. 创建一个队列, 把根节点入队,
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 2. 遍历整棵树, 先打印根节点的值
        // 3. 将根节点的左右子树入队
        // 4. 取队首元素并访问
        while(true){
            TreeNode cur = queue.poll();
            if(cur == null){
                break;
            }
            System.out.print(cur.val + " ");

            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    // 6. 判断一棵树是不是完全二叉树
    public static boolean isCompleteTree(TreeNode root){
        //判断一棵树是否是完全二叉树分为两个阶段
        // 一. 层序遍历这棵树, 要求每个根节点都必须有左右子树
        // 1. 如果有左右子树就继续遍历
        // 2. 如果只有右子树, 没有左子树, 则直接返回false
        // 3. 如果只有左子树, 没有右子树, 则进入第二阶段
        // 4. 如果左右子树都没有, 则进入第二阶段
        // 二. 进入第二阶段, 就要求所有节点都必须没有左右子树
        // 如果有一个节点不符合则返回false
        if(root == null){
            return true;
        }
        boolean level2 = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(true){
            TreeNode cur = queue.poll();
            if(cur == null){
                break;
            }
            if(!level2){
                //第一阶段
                if(cur.left != null && cur.right != null){
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
                else if(cur.right != null && cur.left == null){
                    return false;
                }
                else if(cur.right == null && cur.left != null){
                    queue.offer(cur.left);
                    level2 = true;
                }else{
                    level2 = true;
                }
            }else{
                //第二阶段
                if(cur.left != null || cur.right != null){
                    return false;
                }
            }
        }
        return true;
    }

    // 7. 已知先序遍历结果(包含空格), 求该树的中序遍历结果
    public static int index = 0;
    public static TreeNode build(String line){
        int index = 0;
        return build2(line);
    }

    public static TreeNode build2(String line){
        char ch = line.charAt(index);
        //将第index个字符判空, 不为空的话就放到root上,
        //然后继续判断它的left和right
        if(ch == '#'){
            return null;
        }
        TreeNode root = new TreeNode(ch);
        index++;
        root.left = build2(line);
        index++;
        root.right = build2(line);
        return root;
    }

    // 8. 二叉树的分层遍
    public List<List<Integer>> levelOrder2(TreeNode root) {
        // 先创建一个空的二维链表
        List<List<Integer>> res = new ArrayList<>();
        // 0. 判断特殊情况
        if(root == null){
            return res;
        }
        // 1. 创建队列, 和层序遍历差不多
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 2. 先计算当前queue中有多少元素, 并依次放到一个新的一维链表中
        // 3. 将当前队首元素的左子树和右子树分别入队
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tem = new LinkedList<>();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                tem.add(cur.val);
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            res.add(tem);
        }
        return res;
    }

    // 9. 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先
    public static TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        find(root, p, q);
        return lca;
    }
    public static boolean find(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }
        int mid = (p == root || q == root) ? 1 : 0;
        int left = find(root.left, p, q) ? 1 : 0;
        int right = find(root.right, p, q) ? 1 : 0;
        if(mid + left + right == 2){
            lca = root;
        }
        return (mid + left + right > 0);
    }

    // 10. 二叉搜索树转换成一个排序的双向链表
    public TreeNode Convert(TreeNode pRootOfTree) {
        // 主要思想是通过中序遍历来转换
        // 0. 判断特殊情况
        if(pRootOfTree == null){
            return null;
        }
        if(pRootOfTree.left == null && pRootOfTree.right == null){
            return pRootOfTree;
        }
        // 1. 先将左子树转为一个双向链表, 再把当前节点尾插到左子树的链表后
        TreeNode leftHead = Convert(pRootOfTree.left);
        TreeNode leftTail = leftHead;
        while(leftTail != null && leftTail.right != null){
            leftTail = leftTail.right;
        }
        if(leftHead != null){
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        // 2. 再将右子树转为一个双向链表, 再把当前节点头插到右子树的前面
        TreeNode rightHead = Convert(pRootOfTree.right);
        if(rightHead != null){
            pRootOfTree.right = rightHead;
            rightHead.left = pRootOfTree;
        }
        return (leftHead == null) ? pRootOfTree : leftHead;
    }


    public static void main(String[] args) {
        TreeNode root = setTree();
//        levelOrder(root);
//        System.out.println(isCompleteTree(root));
    }
}
