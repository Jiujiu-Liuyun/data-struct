package com.zhangyun.common.datastruct.tree;

import cn.hutool.core.util.ObjectUtil;

import java.nio.file.Path;
import java.util.Comparator;

/**
 * description: 平衡二叉树 <br/>
 * 1. 是「二叉排序树」<br/>
 * a. 若左子树非空，则左子树上所有结点关键字的值均小于根节点的关键字的值。<br/>
 * b. 若右子树非空，则右子树上所有结点关键字的值均大于根节点的关键字的值。<br/>
 * c. 左右子树本身也分别是一棵二叉排序树。<br/>
 * 2. 任何一个节点的左子树或者右子树都是「平衡二叉树」（左右高度差小于等于 1）<br/>
 *
 * @author: zhangyun
 * @date: 2022/8/15 00:11
 * @since: 1.0
 */
public class AVLTree {
    /**
     * AVL树的根节点
     */
    private AVLNode root;

    public static class AVLNode {
        public int val;
        public AVLNode left;
        public AVLNode right;
        public AVLNode parent;
        public int height;

        public AVLNode(int val) {
            this.val = val;
        }
    }

    /**
     * 计算某个节点的高度
     *
     * @param root
     * @return
     */
    private void calHeight(AVLNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        if (root.left == null) {
            root.height = root.right.height + 1;
            return;
        }
        if (root.right == null) {
            root.height = root.left.height + 1;
            return;
        }
        root.height = Math.max(root.left.height, root.right.height) + 1;
    }

    /**
     * 计算节点的平衡因子：左子树高度 - 右子树高度
     *
     * @param root
     * @return
     */
    private int calBF(AVLNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = root.left.height;
        }
        if (root.right != null) {
            right = root.right.height;
        }
        return left - right;
    }

    /**
     * 左旋
     * 1. 旧根节点（root）为新根节点（newRoot）的左子树
     * 2. 新根节点的左子树（newRootLeft）为旧根节点的右子树
     *
     * @param root
     * @return
     */
    private AVLNode leftRotate(AVLNode root) {
        AVLNode newRoot = root.right;
        AVLNode newRootLeft = newRoot.left;
        AVLNode parent = root.parent;
        // 1.
        if (parent.val > root.val) {
            parent.left = newRoot;
        } else {
            parent.right = newRoot;
        }
        // 2.
        newRoot.parent = parent;
        // 3.
        newRoot.left = root;
        root.parent = newRoot;
        // 4.
        root.right = newRootLeft;
        if (newRootLeft != null) {
            newRootLeft.parent = root;
        }
        // 5.
        calHeight(root);
        calHeight(newRoot);
        return newRoot;
    }

    /**
     * 右旋
     * 1. 旧根节点（root）为新根节点（newRoot）的右子树
     * 2. 新根节点的右子树（newRootLeft）为旧根节点的左子树
     *
     * @param root
     * @return
     */
    private AVLNode rightRotate(AVLNode root) {
        AVLNode newRoot = root.left;
        AVLNode newRootRight = newRoot.right;
        AVLNode parent = root.parent;
        // 1. new root
        if (parent.val > root.val) {
            parent.right = newRoot;
        } else {
            parent.left = newRoot;
        }
        // 2.
        newRoot.parent = parent;
        // 3.
        newRoot.right = root;
        root.parent = newRoot;
        // 4.
        root.right = newRootRight;
        if (newRootRight != null) {
            newRootRight.parent = root;
        }
        // 5.
        calHeight(root);
        calHeight(newRoot);
        return newRoot;
    }

    /**
     * 插入数据
     */
    public void insertOne(int data) {
        if (this.root == null) {
            root = new AVLNode(data);
            return;
        }
        this.root = insertOne(data, root);
    }

    /**
     * 插入数据 - 递归
     */
    private AVLNode insertOne(int data, AVLNode root) {
        // 不符合要求，直接返回
        if (data == root.val) {
            return root;
        } else if (data > root.val) {
            if (root.right == null) {
                root.right = new AVLNode(data);
            } else {
                insertOne(data, root.right);
            }
        } else {
            if (root.left == null) {
                root.left = new AVLNode(data);
            } else {
                insertOne(data, root.left);
            }
        }
        // 计算高度
        calHeight(root);
        if (calBF(root) == 2) {
            if (calBF(root.left) == -1) {
                root.left = leftRotate(root.left);
            }
            root = rightRotate(root);
        } else if (calBF(root) == -2) {
            if (calBF(root.right) == 1) {
                root.right = rightRotate(root.right);
            }
            root = leftRotate(root);
        }
        return root;
    }
    
}
