package com.zhangyun.common.datastruct.util;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson2.JSONObject;
import com.zhangyun.common.datastruct.tree.TreeNode;

import java.util.*;

/**
 * description: 二叉树工具类
 *
 * @author: zhangyun
 * @date: 2022/8/14 20:33
 * @since: 1.0
 */
public class BinaryTreeUtil {

    /**
     * 二叉树中序遍历
     *
     * @param root
     * @return
     */
    public static <T> List<T> inorderTraversal(TreeNode<T> root) {
        ArrayList<T> traversal = new ArrayList<>();
        if (root == null) {
            return traversal;
        }
        List<T> left = inorderTraversal(root.left);
        traversal.addAll(left);
        traversal.add(root.val);
        List<T> right = inorderTraversal(root.right);
        traversal.addAll(right);
        return traversal;
    }


    /**
     * 二叉树解析器
     *
     * @param str
     * @return
     */
    public static <T> TreeNode<T> parseTree(String str, Class clz) {
        // 解析为数组
        String[] nodes = str.split(",");
        Deque<TreeNode<T>> deque = new LinkedList<>();
        TreeNode<T> root = new TreeNode(JSONObject.parseObject(nodes[0], clz));
        int index = 1;
        deque.add(root);
        while (ObjectUtil.isNotEmpty(deque)) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                if (index < nodes.length) {
                    if (!nodes[index].equals("#")) {
                        TreeNode left = new TreeNode(Integer.parseInt(nodes[index]));
                        node.left = left;
                        deque.add(left);
                    }
                    index++;
                } else {
                    break;
                }
                if (index < nodes.length) {
                    if (!nodes[index].equals("#")) {
                        TreeNode right = new TreeNode(Integer.parseInt(nodes[index]));
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

}
