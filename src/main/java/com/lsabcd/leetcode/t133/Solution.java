package com.lsabcd.leetcode.t133;

import java.util.*;

public class Solution {

    public Node cloneGraph(Node node) {
        Map<Integer, Node> map = new HashMap<>();
        return visitNode(node,map);
    }

    private Node visitNode(Node node, Map<Integer, Node> map){
        if (null == node) {
            return null;
        }

        Node result ;
        if (map.get(node.val) == null) {
            result = new Node();
            result.val = node.val;

            if (null == node.neighbors || node.neighbors.size() == 0) {
                result.neighbors = new ArrayList<>();
                return result;
            }
            map.put(result.val, result);

            Deque<Node> queue = new LinkedList<>();
            List<Node> neighbors = new ArrayList<>();
            for (Node n : node.neighbors) {
                if (null == map.get(n.val)) {
                    Node nn = new Node();
                    nn.val = n.val;
                    map.put(n.val, nn);
                    queue.addLast(n);
                    neighbors.add(nn);
                } else {
                    neighbors.add(map.get(n.val));
                }
            }
            result.neighbors = neighbors;
            while (queue.size() != 0) {
                Node toVisit = queue.poll();
                visitNode(toVisit, map);
            }
        } else {
            result = map.get(node.val);

            if (null == node.neighbors || node.neighbors.size() == 0)  {
                result.neighbors = new ArrayList<>();
                return result;
            }
            Deque<Node> queue = new LinkedList<>();
            List<Node> neighbors = new ArrayList<>();
            for (Node n : node.neighbors) {
                if (null == map.get(n.val)) {
                    Node nn = new Node();
                    nn.val = n.val;
                    map.put(n.val, nn);
                    queue.addLast(n);
                    neighbors.add(nn);
                } else {
                    neighbors.add(map.get(n.val));
                }
            }
            result.neighbors = neighbors;
            while (queue.size() != 0) {
                Node toVisit = queue.poll();
                visitNode(toVisit, map);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node node = new Solution.Node();
        node.val = 1;

        Node result = solution.cloneGraph(node);
        System.out.println(result);


    }

    public static void main2(String[] args) {
        Solution solution = new Solution();

        Node node1 = new Solution.Node();
        Node node2 = new Solution.Node();
        Node node3 = new Solution.Node();
        Node node4 = new Solution.Node();

        node1.val = 1;
        List<Node> nn1 = new ArrayList<>();
        nn1.add(node2);
        nn1.add(node4);
        node1.neighbors = nn1;

        node2.val = 2;
        List<Node> nn2 = new ArrayList<>();
        nn2.add(node1);
        nn2.add(node3);
        node2.neighbors = nn2;

        node3.val = 3;
        List<Node> nn3 = new ArrayList<>();
        nn3.add(node2);
        nn3.add(node4);
        node3.neighbors = nn3;

        node4.val = 4;
        List<Node> nn4 = new ArrayList<>();
        nn4.add(node1);
        nn4.add(node3);
        node4.neighbors = nn4;


        Node result = solution.cloneGraph(node1);
        System.out.println(result);
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
