package BinaryTree;



public class BinaryTreeDemo {
    public static void main(String[] args) {
        //先需要创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的结点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关圣");
        HeroNode node6 = new HeroNode(6, "何文勇");

        //说明，我们先手动创建该二叉树，后面我们学习递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        node5.setLeft(node6);
        binaryTree.setRoot(root);

        //测试
//        binaryTree.preOrder();

        //测试前序查找
        HeroNode preNode= binaryTree.preOrderSearch(6);
        System.out.println(preNode);

        //测试中序查找
//        HeroNode infixNode= binaryTree.infixOrderSearch(6);
//        System.out.println(infixNode);
    }
}

class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root=root;
    }
    //前序遍历
    public void preOrder() {
        if(this.root != null) {
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //中序遍历
    public void infixOrder() {
        if(this.root != null) {
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //后序遍历
    public void postOrder() {
        if(this.root != null) {
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //前序查找
    public HeroNode preOrderSearch(int no) {

        if(this.root != null) {
           return root.preOrdersearch(no);
        }else {
            return null;
        }
    }

    //中序查找
    public HeroNode infixOrderSearch(int no) {
        if (this.root != null) {
            return root.infixOrdersearch(no);
        } else {
            return null;
        }
    }
}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //定义BinaryTree二叉树


    //编写前序遍历的方法
    public void preOrder() {
        System.out.println(this);  //先输出父节点
        //递归向左子树前序遍历
        if(this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if(this.right != null) {
            this.right.preOrder();
        }

    }
    //中序遍历
    public void infixOrder() {
        //递归向左子树中序遍历
        if(this.left != null) {
            this.left.infixOrder();
        }
        //输出父节点
        System.out.println(this);
        //递归向右子树中序遍历
        if(this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if(this.left != null) {
            this.left.postOrder();
        }
        if(this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    public HeroNode preOrdersearch(int no) {
        if(this.no == no) {
            return this;
        }
        //1.判断当前结点的左子节点是否为空，如果不为空，则递归前序查找
        //2.如果左递归前序查找，找到节点，则返回
        HeroNode resNode = null;
        if(this.left != null) {
            resNode = this.left.preOrdersearch(no);
        }
        if(resNode != null) {  //说明我们左子树找到
            return resNode;
        }
        //1.左递归前序查找，找到结点，则返回，否继续判断
        //2.当前结点的右子结点是否为空，如果不空，则继续向右递归前序查找
        if(this.right != null) {
            resNode = this.right.preOrdersearch(no);
        }
        return resNode;
    }
    //中序查找
    //1。判断当前结点的左子结点是否为空，如果不为空，则递归中序查找
    //2。如果找到则返回，如果没有找到，就和当前结点比较，如果是则返回当前结点，
    //   否则继续进行右递归的中序查找
    //3。如果右递归中序查找，找到就返回，否则返回null
    public HeroNode infixOrdersearch(int no) {
        HeroNode resNode = null;

        if(this.left != null) {
            return this.left.infixOrdersearch(no);


        }
        if(this.no == no)  {

            return this;
        }else {
            resNode = this.right.infixOrdersearch(no);
        }
        return resNode;

    }
}
