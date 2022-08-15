package com.zhangyun.common.datastruct.tree;

/**
 * description: 二叉树节点
 *
 * @author: zhangyun
 * @date: 2022/8/14 20:28
 * @since: 1.0
 */
public class TreeNode<T> {

    public T val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(T val) {
        this.val = val;
    }

    public TreeNode(T val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
