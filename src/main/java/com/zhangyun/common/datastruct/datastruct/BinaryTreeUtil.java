package com.zhangyun.common.datastruct.datastruct;

import cn.hutool.core.util.ObjectUtil;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * description: 二叉树工具类
 *
 * @author: zhangyun
 * @date: 2022/8/14 20:33
 * @since: 1.0
 */
public class BinaryTreeUtil {

    /**
     * 二叉树解析器
     *
     * @param integers
     * @return
     */
    public static TreeNode parseTree(Integer[] integers) {
        if (ObjectUtil.isEmpty(integers)) {
            return null;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode root = new TreeNode(integers[0]);
        int index = 1;
        deque.add(root);
        while (ObjectUtil.isNotEmpty(deque)) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                if (index < integers.length) {
                    if (ObjectUtil.isNotEmpty(integers[index])) {
                        TreeNode left = new TreeNode(integers[index]);
                        node.left = left;
                        deque.add(left);
                    }
                    index++;
                } else {
                    break;
                }
                if (index < integers.length) {
                    if (ObjectUtil.isNotEmpty(integers[index])) {
                        TreeNode right = new TreeNode(integers[index]);
                        node.right = right;
                        deque.add(right);
                    }
                    index++;
                } else {
                    break;
                }
            }
        }
        return root;
    }

    public static List<Integer> inorderTraverse(TreeNode root) {
        ArrayList<Integer> integers = new ArrayList<>();
        if (root == null) {
            return integers;
        }
        List<Integer> left = inorderTraverse(root.left);
        integers.addAll(left);
        integers.add(root.val);
        List<Integer> right = inorderTraverse(root.right);
        integers.addAll(right);
        return integers;
    }

}
