package com.zhangyun.common.datastruct.tree;

import com.zhangyun.common.datastruct.util.AVLTreeUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AVLTreeTest {

    @Test
    void testInsertOne() {
        AVLTree tree = new AVLTree();
        tree.insertOne(3);
        tree.insertOne(2);
        tree.insertOne(1);
        tree.insertOne(4);
        tree.insertOne(5);
        tree.insertOne(6);
        tree.insertOne(7);
        tree.insertOne(10);
        tree.insertOne(9);
        tree.insertOne(8);

    }
}