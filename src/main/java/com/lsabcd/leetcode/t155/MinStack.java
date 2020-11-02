package com.lsabcd.leetcode.t155;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

    private List<Integer> stack = new ArrayList<Integer>(10);

    private int cur = -1;

    private Integer min = null;

    public MinStack() {
    }

    public void push(int x) {
        stack.add(x);
        cur++;
        if (null != min && min > x) {
            min = x;
        }
    }

    public void pop() {
        if (cur < 0) {
            throw new RuntimeException();
        }
        int top = top();
        stack.remove(cur);
        cur--;
        if (null!=min && min == top) {
            min = null;
        }
    }

    public int top() {
        return stack.get(cur);
    }

    public int getMin() {
        if (cur < 0) {
            throw new RuntimeException();
        }
        return null == min ?  getMinIntener(): min;
    }

    private int getMinIntener(){
        if (cur < 0) {
            throw new RuntimeException();
        }
        int minIntener = stack.get(0);
        for (int i=1;i< stack.size();i++) {
            int tmp = stack.get(i);
            if (minIntener > tmp) {
                minIntener = tmp;
            }
        }
        min = minIntener;
        return minIntener;
    }
}
