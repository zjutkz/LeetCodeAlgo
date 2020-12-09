package com.zjutkz.leetcode.android.newtree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    public TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public int getNodeCount() {
        return doGetNodeCountInner(root);
    }

    private int doGetNodeCountInner(TreeNode node) {
        if(node  == null) {
            return 0;
        }

        int leftCount = doGetNodeCountInner(node.leftNode);
        int rightCount = doGetNodeCountInner(node.rightNode);
        return leftCount + rightCount + 1;
    }

    public void printTreeVertical() {
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);

        while (nodes.size() > 0) {
            TreeNode node = nodes.remove(0);
            System.out.print(node.value + " ");
            if(node.leftNode != null) {
                nodes.add(node.leftNode);
            }
            if(node.rightNode != null) {
                nodes.add(node.rightNode);
            }
        }
    }

    public void printMaxPerLevel() {
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);

        while (nodes.size() > 0) {
            int max  = -1;
            int floorNodesCount = nodes.size();
            for(int i = 0; i < floorNodesCount; i++) {
                TreeNode node = nodes.remove(0);
                if(max < node.value) {
                    max = node.value;
                }
                if(node.leftNode != null) {
                    nodes.add(node.leftNode);
                }
                if(node.rightNode != null) {
                    nodes.add(node.rightNode);
                }
            }
            System.out.print(max + " ");
        }
    }

    public void preOrderTraverse() {
        doPreOrderTraverseInner(root);
    }

    private void doPreOrderTraverseInner(TreeNode node) {
        if(node == null) {
            return ;
        }

        System.out.print(node.value + " ");
        doPreOrderTraverseInner(node.leftNode);
        doPreOrderTraverseInner(node.rightNode);
    }

    public int findKLevelNodeCount(int k) {
        return doFindKLevelNodeCount(root, k);
    }

    private int doFindKLevelNodeCount(TreeNode node, int k) {
        if(node == null || k < 1) {
            return 0;
        }
        if(k == 1) {
            return 1;
        }

        return doFindKLevelNodeCount(node.leftNode, k - 1) + doFindKLevelNodeCount(node.rightNode, k - 1);
    }

    public int findMinDepth() {
        return doFindMinDepth(root);
    }

    private int doFindMinDepth(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int leftDepth = doFindMinDepth(node.leftNode);
        int rightDepth = doFindMinDepth(node.rightNode);

        return leftDepth < rightDepth ? leftDepth + 1 : rightDepth + 1;
    }
}
