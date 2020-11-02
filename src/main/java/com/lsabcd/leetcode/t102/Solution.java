package com.lsabcd.leetcode.t102;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (null == root) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
            List<Integer> list = singleLevel(q, nextLevel);
            res.add(list);
            q = nextLevel;
        }
        return res;
    }

    private List<Integer> singleLevel(Queue<TreeNode> q,Queue<TreeNode> nextLevel){
        List<Integer> valList = new ArrayList<Integer>();
        if (q.isEmpty()) {
            return null;
        }
        TreeNode node = q.poll();
        while (null != node) {
            valList.add(node.val);
            if (null != node.left) {
                nextLevel.add(node.left);
            }
            if (null != node.rigit) {
                nextLevel.add(node.rigit);
            }
            node = q.poll();
        }
        return valList;
    }
    public class TreeNode {
        public int val;

        public TreeNode left;

        public TreeNode rigit;

        TreeNode(int x){val = x;}

    }
}
