package com.zjutkz.leetcode.android.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

    TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public int getTreeCount() {
        return doGetTreeCountInner(root);
    }

    private int doGetTreeCountInner(TreeNode node) {
        if(node == null) {
            return 0;
        } else {
            int leftCount = doGetTreeCountInner(node.leftNode);
            int rightCount = doGetTreeCountInner(node.rightNode);

            return 1 + leftCount + rightCount;
        }
    }

    public int getMaxDepth() {
        return doGetMaxDepthInner(root);
    }

    private int doGetMaxDepthInner(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int leftDepth = doGetMinDepthInner(node.leftNode);
        int rightDepth = doGetMinDepthInner(node.rightNode);

        int maxDepth = Math.max(leftDepth, rightDepth);

        return maxDepth + 1;
    }

    public int getMinDepth() {
        return doGetMinDepthInner(root);
    }

    private int doGetMinDepthInner(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int leftDepth = doGetMinDepthInner(node.leftNode);
        int rightDepth = doGetMinDepthInner(node.rightNode);

        int minDepth = Math.min(leftDepth, rightDepth);

        return minDepth + 1;
    }

    public int findKLevelNodes(int k) {
        return doFindLevelNodesInner(root, k);
    }

    private int doFindLevelNodesInner(TreeNode node, int k) {
        if(node == null || k < 1){
            return 0;
        }
        if(k == 1){
            return 1;
        }

        return doFindLevelNodesInner(node.leftNode, k - 1) + doFindLevelNodesInner(node.rightNode, k - 1);
    }

    public void printKLevelNodes(int k) {
        doPrintKLevelNodes(root, k);
    }

    private void doPrintKLevelNodes(TreeNode node, int k) {
        if(node == null || k < 1) {
            return ;
        }
        if(k == 1) {
            System.out.print(node.value + " ");
            return ;
        }
        doPrintKLevelNodes(node.leftNode, k -1);
        doPrintKLevelNodes(node.rightNode, k -1);
    }

    public void preOrderTraverse() {
        doPreOrderTraverse(root);
    }

    private void doPreOrderTraverse(TreeNode node) {
        if(node == null) {
            return ;
        }

        System.out.print(node.value + " ");
        doPreOrderTraverse(node.leftNode);
        doPreOrderTraverse(node.rightNode);
    }

    public void postOrderTraverse() {
        doPostOrderTraverse(root);
    }

    private void doPostOrderTraverse(TreeNode node) {
        if(node == null) {
            return ;
        }

        doPreOrderTraverse(node.leftNode);
        doPreOrderTraverse(node.rightNode);
        System.out.print(node.value + " ");
    }

    public void middleOrderTraverse() {
        doMiddleOrderTraverse(root);
    }

    private void doMiddleOrderTraverse(TreeNode node) {
        if(node == null) {
            return ;
        }

        doPreOrderTraverse(node.leftNode);
        System.out.print(node.value + " ");
        doPreOrderTraverse(node.rightNode);
    }

    public void horizontalTraverse() {
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);

        while (!nodeList.isEmpty()) {
            TreeNode node = nodeList.remove(0);
            System.out.print(node.value + " ");
            if(node.leftNode != null) {
                nodeList.add(node.leftNode);
            }
            if(node.rightNode != null) {
                nodeList.add(node.rightNode);
            }
        }
    }

    // https://www.cnblogs.com/ranjiewen/p/5648056.html
    public int getLCA(int a, int b) {
        while (a != b) {
            if(a > b) {
                a = a / 2;
            } else {
                b = b / 2;
            }
        }

        return a;
    }
}
