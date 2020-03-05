public class LowestAncestor {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 定义递归终止条件root为null代表未找到，非空代表找到了p或q
        if (root == null || root == p || root == q) {
            return root;
        }
        // 递归左子树结点
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 递归右子树结点
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 左右都非空代表当前root结点就是所需结果
        if (left != null && right != null) {
            return root;
        }
        // 排除为空的一侧
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);   
        TreeNode B = new TreeNode(5);
        TreeNode C = new TreeNode(1);
        TreeNode D = new TreeNode(6);
        TreeNode E = new TreeNode(2);
        TreeNode F = new TreeNode(0);
        TreeNode G = new TreeNode(8);
        TreeNode H = new TreeNode(null);
        TreeNode I = new TreeNode(null);
        TreeNode J = new TreeNode(7);
        TreeNode K = new TreeNode(4);

        root.left = B;
        root.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        D.left = H;
        D.right = I;
        E.left = J;
        E.right = K;

        TreeNode node = lowestCommonAncestor(root, E, K);
        System.out.println(node.value);
    }
}