package com.lsabcd.leetcode.t155;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MinStackV2 {

    private int[] stack = new int[10];

    private int cur = -1;

    private Integer min = null;

    public MinStackV2() {
    }

    public void push(int x) {
        cur++;
        if (cur > stack.length - 1) {
            resize();
        }
        stack[cur] = x;
        if (null != min && min > x) {
            min = x;
        }
    }

    public void pop() {
        if (cur < 0) {
            throw new RuntimeException();
        }
        int top = top();
        if (null!=min && min == top) {
            min = null;
        }
        cur--;

        desize();
    }

    public int top() {
        return stack[cur];
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
        int minIntener = stack[0];
        for (int i=1;i <= cur;i++) {
            int tmp = stack[i];
            if (minIntener > tmp) {
                minIntener = tmp;
            }
        }
        min = minIntener;
        return minIntener;
    }

    private void resize(){
        int[] newStack;
        if (stack.length < 50000) {
            newStack = new int[stack.length * 2];
        } else {
            newStack = new int[(stack.length * 3) / 2];
        }
        System.arraycopy(stack,0,newStack,0,stack.length);
        stack = newStack;
    }

    private void desize(){
        if (cur < 0) {
            stack = new int[10];
        }
        if (cur < stack.length / 3) {
            int[] newStack = new int[stack.length*2/3];
            System.arraycopy(stack,0,newStack,0,cur);
            stack = newStack;
        }
    }

    public int[] getStack(){
        return stack;
    }

    public static void main(String[] args) throws NoSuchFieldException, ClassNotFoundException {
        String[] cmd = new String[]{"MinStack", "push", "push", "push", "getMin", "push", "push", "push", "push", "push", "top", "push", "push", "getMin", "push", "getMin", "push", "push", "getMin", "push", "top", "push", "getMin", "push", "push", "push", "push", "getMin", "push", "push", "top", "push", "push", "getMin", "pop", "getMin", "push", "push", "getMin", "getMin", "push", "getMin", "pop", "push", "push", "push", "getMin", "push", "getMin", "getMin", "getMin", "pop", "getMin", "push", "push", "getMin", "top", "getMin", "push", "getMin", "getMin", "getMin", "getMin", "push", "getMin", "getMin", "getMin", "push", "getMin", "push", "getMin", "push", "getMin", "getMin", "getMin", "getMin", "pop", "getMin", "push", "getMin", "getMin", "push", "push", "pop", "push", "getMin", "push", "top", "top", "push", "push", "getMin", "pop", "getMin", "push", "top", "push", "getMin", "push", "getMin", "getMin"};
        int[][] v = new int[][]{
                {},{85},{-99},{67},{},{-27},{61},{-97},{-27},{35},{},{99},{-66},{},{-89},{},{4},{-70},{},{52},{},{54},{},{94},{-41},{-75},{-32},{},{5},{29},{},{-78},{-74},{},{},{},{-58},{-44},{},{},{-64},{},{},{-45},{-99},{-27},{},{-96},{},{},{},{},{},{26},{-58},{},{},{},{25},{},{},{},{},{33},{},{},{},{71},{},{-62},{},{-78},{},{},{},{},{},{},{-30},{},{},{85},{-15},{},{-40},{},{72},{},{},{18},{59},{},{},{},{-59},{},{10},{},{9},{},{}
        };
//        System.out.printf(cmd.length+",");
//        System.out.printf(v.length+"");
        MinStackV2 stackV2 = new MinStackV2();
        for (int i = 1; i < cmd.length; i++) {
            System.out.println("index:" + i);
            print(stackV2.getStack());
            System.out.println("");

            String c = cmd[i];
            if ("push".equals(c)) {
                stackV2.push(v[i][0]);
            } else if ("pop".equals(c)) {
                stackV2.pop();
            } else if ("getMin".equals(c)){
                stackV2.getMin();
//                System.out.printf(stackV2.getMin()+",");
            }
        }
    }

    public static void print(int[] ss){
        for (int s : ss) {
            System.out.printf(s+",");;
        }
    }


}
