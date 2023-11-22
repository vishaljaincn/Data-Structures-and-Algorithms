package day58_Advanced_Trees_2;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
//TC - O(N * log N), log N for the TreeMap and Priority Queue
// Tuple class to represent a node along with its vertical and level positions
class Tuple {
    TreeNode node;
    int vertical;
    int level;

    public Tuple(TreeNode node, int vertical, int level) {
        this.node = node;
        this.vertical = vertical;
        this.level = level;
    }
}

public class VerticalTraversalOfBT {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Process the TreeMap to generate the final result list
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // TreeMap to store nodes based on their vertical and level positions
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        // Queue for BFS traversal
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0)); // Add the root to the queue with initial positions

        // BFS traversal
        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int vertical = tuple.vertical;
            int level = tuple.level;

            // Add the node to the TreeMap based on vertical and level positions
            if (!map.containsKey(vertical)) {
                map.put(vertical, new TreeMap<>());
            }
            if (!map.get(vertical).containsKey(level)) {
                map.get(vertical).put(level, new PriorityQueue<>());
            }
            map.get(vertical).get(level).offer(node.val);

            // Enqueue the children of the current node with updated positions
            if (node.left != null) {
                q.offer(new Tuple(node.left, vertical - 1, level + 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, vertical + 1, level + 1));
            }
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> levels : map.values()) {
            List<Integer> list = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : levels.values()) {
                while (!nodes.isEmpty()) {
                    list.add(nodes.poll());
                }
            }
            result.add(list);
        }

        return result;
    }
}
