package com.zjutkz.leetcode.android.newtree;


//前序、后序、中序遍历
//二叉树深度
//输出第K层的节点
public class Test {

    public static void main(String[] args) {
        BinaryTree binaryTree = constructTree();

        System.out.println("count: " + binaryTree.getNodeCount());

        binaryTree.printTreeVertical();
        System.out.println();

        binaryTree.printMaxPerLevel();
        System.out.println();

        System.out.println(binaryTree.findKLevelNodeCount(2));

        System.out.println(binaryTree.findMinDepth());
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
