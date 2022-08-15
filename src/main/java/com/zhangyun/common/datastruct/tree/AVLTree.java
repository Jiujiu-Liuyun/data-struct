package com.zhangyun.common.datastruct.tree;

/**
 * description: 平衡二叉树 <br/>
 * 1. 是「二叉排序树」<br/>
 *      a. 若左子树非空，则左子树上所有结点关键字的值均小于根节点的关键字的值。<br/>
 *      b. 若右子树非空，则右子树上所有结点关键字的值均大于根节点的关键字的值。<br/>
 *      c. 左右子树本身也分别是一棵二叉排序树。<br/>
 * 2. 任何一个节点的左子树或者右子树都是「平衡二叉树」（左右高度差小于等于 1）<br/>
 *
 * @author: zhangyun
 * @date: 2022/8/15 00:11
 * @since: 1.0
 */
public class AVLTree<T> {
    TreeNode<T> root;


}
