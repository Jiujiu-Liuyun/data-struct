package com.zhangyun.interview.shence;

import com.zhangyun.common.datastruct.tree.TreeNode;

import java.util.*;

/**
 * description:
 *
 * @author: zhangyun
 * @date: 2022/8/19 21:25
 * @since: 1.0
 */
public class ShenCe2 {
    private static Map<Integer, Node> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] routes = new int[n][2];
        for (int i = 0; i < n; i++) {
            routes[i][0] = in.nextInt();
            routes[i][1] = in.nextInt();
        }
        int s1 = in.nextInt();
        int s2 = in.nextInt();
        // 构造地图
        construct(routes);
        Node nearestNode = findNearestNode(map.get(1), map.get(s1), map.get(2));
        if (nearestNode != null) {
            System.out.println(nearestNode.val);
        }
    }

    private static Node findNearestNode(Node root, Node s1, Node s2) {
        if (s1 == root || s2 == root) {
            return root;
        }
        if (root.child.size() == 0) {
            return null;
        }
        int count = 0;
        List<Node> nodes = new ArrayList<>();
        for (Node node : root.child) {
            Node nearestNode = findNearestNode(node, s1, s2);
            if (nearestNode != null) {
                nodes.add(nearestNode);
                count++;
            }
        }
        if (count == 2) {
            return root;
        } else if (count == 1) {
            return nodes.get(0);
        } else {
            return null;
        }
    }

    private static void construct(int[][] routes) {
        Node roman = new Node(1);
        for (int[] route : routes) {
            Node child = map.getOrDefault(route[0], new Node(route[0]));
            Node father = map.getOrDefault(route[1], new Node(route[1]));
            father.child.add(child);
            map.put(route[0], child);
            map.put(route[1], father);
        }
    }

    static class Node {
        int val;
        List<Node> child = new ArrayList<>();

        public Node(int val) {
            this.val = val;
        }
    }
}
