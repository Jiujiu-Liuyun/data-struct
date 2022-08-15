package com.zhangyun.common.datastruct.util;

import com.zhangyun.common.datastruct.tree.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class BinaryTreeUtilTest {

    @Test
    void inorderTraversal() {
        TreeNode<Integer> root = null;
        List<Integer> list = null;

        root = BinaryTreeUtil.parseTree("1,2,3,#", Integer.class);
        list = BinaryTreeUtil.inorderTraversal(root);
        log.info("{}", list);

        root = BinaryTreeUtil.parseTree("1,2,3,4,#,5,#,6,7", Integer.class);
        list = BinaryTreeUtil.inorderTraversal(root);
        log.info("{}", list);
    }

    @Test
    void parseTree() {
        TreeNode root = BinaryTreeUtil.parseTree("1,2,3,#", Integer.class);
//        System.out.println(root);
    }
}