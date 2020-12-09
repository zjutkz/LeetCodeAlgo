package com.zjutkz.leetcode.android.tree;

//前序、后序、中序遍历
//二叉树深度
//输出第K层的节点
public class Test {

    public static void main(String[] args) {
        BinaryTree binaryTree = constructTree();

        // https://blog.csdn.net/cherrybomb1111/article/details/78060438
        // https://www.jianshu.com/p/2db48864c314
        System.out.println("count: " + binaryTree.getTreeCount());
        System.out.println("max depth: " + binaryTree.getMaxDepth());
        System.out.println("min depth: " + binaryTree.getMinDepth());

        // https://www.codenong.com/cs106276390/
        // https://blog.csdn.net/zheng0518/article/details/8901062
        System.out.println("3 level node count: " + binaryTree.findKLevelNodes(3));
        System.out.println("3 level nodes:");
        binaryTree.printKLevelNodes(3);
        System.out.println();

        // https://blog.csdn.net/My_Jobs/article/details/43451187
        binaryTree.preOrderTraverse();
        System.out.println();
        binaryTree.postOrderTraverse();
        System.out.println();
        binaryTree.middleOrderTraverse();
        System.out.println();
        binaryTree.horizontalTraverse();
        System.out.println();
    }

    private static BinaryTree constructTree() {
        BinaryTree binaryTree = new BinaryTree();
        //创建一个根节点
        TreeNode root = new TreeNode(1);
        //把根节点赋给树
        binaryTree.setRoot(root);
        //创建两个节点
        TreeNode rootL = new TreeNode(2);
        TreeNode rootR = new TreeNode(3);
        //把心创建的节点设置为根节点的子节点
        root.leftNode = rootL;
        root.rightNode = rootR;

        //为第二层的节点创建子节点
        rootL.leftNode = new TreeNode(4);
        rootL.rightNode = new TreeNode(5);

        return binaryTree;
    }
}
