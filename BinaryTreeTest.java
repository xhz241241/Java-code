package Tree;

import com.sun.source.tree.Tree;

import java.util.*;

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

    // 11. 根据一棵树的前序遍历与中序遍历构造二叉树。
    public int index2 = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 0. 需要创建一个全局变量index, 并在方法一进来就初始化index为0
        // 保证每次用例之间互不影响
        index2 = 0;
        // 1. 将中序遍历结果转换成一个list 这样方便从中间截取某一段
        List<Integer> inorderList = new ArrayList<>();
        for(int x : inorder){
            inorderList.add(x);
        }
        return buildTree2(preorder, inorderList);
    }
    public TreeNode buildTree2(int[] preorder, List<Integer> inorderList){
        // 2. 接下来用先序遍历的框架分别设置根节点和左右子树的值
        if(inorderList.isEmpty()){
            return null;
        }
        TreeNode root = new TreeNode(preorder[index2]);
        index2++;
        // 3. 记录下root在中序遍历中的下标, 从该下标切分整个中序遍历结果
        int pos = inorderList.indexOf(root.val);
        // 4. 左子树的范围是[0, pos)
        root.left = buildTree2(preorder, inorderList.subList(0, pos));
        // 5. 有字数的范围是[pos+1, size)
        root.right = buildTree2(preorder, inorderList.subList(pos+1, inorderList.size()));
        return root;
    }

    // 12. 将一个二叉树转换成一个由括号和整数组成的字符串。
    StringBuffer StringBuffer = null;
    public String tree2str(TreeNode t) {
        // 0. 判断特殊情况
        // 1. 创建一个String的可变对象用来追加字符串
        StringBuffer = new StringBuffer();
        if(t == null){
            return "";
        }
        tree2str2(t);
        StringBuffer.deleteCharAt(0);
        StringBuffer.deleteCharAt(StringBuffer.length()-1);
        return StringBuffer.toString();
    }
    public void tree2str2(TreeNode t){
        if(t == null){
            return ;
        }
        StringBuffer.append("(");
        StringBuffer.append(t.val);
        tree2str2(t.left);
        // 2. 当左子树为空, 右子树非空时需要加上()
        if(t.left == null && t.right != null){
            StringBuffer.append("()");
        }
        tree2str2(t.right);
        StringBuffer.append(")");
    }

    // 13. 非递归实现先序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // 非递归的先序遍历和层序遍历差不多
        if(root == null){
            return res;
        }
        // 0. 判断特殊情况并先创建一个栈
        Stack<TreeNode> stack = new Stack<>();
        // 1. 将根节点入栈
        stack.push(root);
        // 2. 取出栈顶元素访问
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.add(cur.val);
            // 3. 并将该节点的右子树和左子树依次入栈
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
        return res;
    }

    // 14. 非递归实现中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        // 0. 判断特殊情况, 创建一个栈
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        // 1. 创建一个cur指向root
        TreeNode cur = root;
        // 2. cur 一路往左走, 遇到的节点都入栈
        while(true){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            // 2. 此处还需要判断左子树为空的情况
            if(stack.isEmpty()){
                break;
            }
            // 3. 直到遇见null, 则说明到达了树的最下面
            // 4. 现在开始出栈
            TreeNode top = stack.pop();
            res.add(top.val);
            // 5. cur 再去访问右子树
            cur = top.right;
        }
        return res;
    }

    // 15. 非递归实现后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        // 0. 判断特殊情况, 创建一个栈
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        // 1. 创建一个cur指向root
        TreeNode cur = root;
        TreeNode pre = null;
        // 2. 让cur一直往left走并把一路上遇见的节点都入栈, 直到遇见null
        while(true){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            if(stack.isEmpty()){
                break;
            }
            // 3. 遇到null后还需要判断该节点的右子树是不是空
            //     `是空的话就可以访问该节点,
            //     `如果不为空就要看看该右子树是不是访问过,
            //        `没有访问过的话, 就需要回去执行2
            //        `访问过的话就可以访问该节点了
            TreeNode top = stack.peek();
            if(top.right == null || pre == top.right){
                //可以访问该节点
                stack.pop();
                res.add(top.val);
                pre = top;
            }else{
                //继续让cur从右子树开始循环
                cur = top.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = setTree();
//        levelOrder(root);
//        System.out.println(isCompleteTree(root));
    }
}
