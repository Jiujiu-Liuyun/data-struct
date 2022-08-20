package com.zhangyun.common.datastruct.util;

import com.zhangyun.common.datastruct.tree.AVLTree;

/**
 * description:
 *
 * @author: zhangyun
 * @date: 2022/8/18 00:25
 * @since: 1.0
 */
public class AVLTreeUtil {
    public static void innerTraverse(AVLTree.AVLNode root) {
        if (root == null) {
            return;
        }
        innerTraverse(root.left);
        System.out.println(root.val + " height:"+root.height);
        innerTraverse(root.right);
    }
}
