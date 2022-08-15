package com.zhangyun.common.datastruct.tree;

import cn.hutool.core.util.ObjectUtil;

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
public class AVLTree<T extends Comparable<T>> {
    private static class AVLNode<T> {
        public T val;
        public AVLNode<T> left;
        public AVLNode<T> right;
        public AVLNode<T> parent;
        public int height;
    }

    /**
     * 计算某个节点的高度
     * @param root
     * @return
     */
    private void calHeight(AVLNode<T> root) {
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
     * @param root
     * @return
     */
    private int calBF(AVLNode<T> root) {
        if (root == null) {
            return 0;
        }
        int left = 0;
        int right = 0;
        if (root.left!=null) {
            left = root.left.height;
        }
        if (root.right!=null) {
            right = root.right.height;
        }
        return left - right;
    }

    /**
     * 左旋
     *      1. 旧根节点（root）为新根节点（newRoot）的左子树
     *      2. 新根节点的左子树（newRootLeft）为旧根节点的右子树
     * @param root
     * @return
     */
    private void leftRotate(AVLNode<T> root) {
        AVLNode<T> newRoot = root.right;
        AVLNode<T> newRootLeft = newRoot.left;
        AVLNode<T> parent = root.parent;
        // 1.
        if (parent.val.compareTo(root.val) > 0) {
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
    }
}
