package com.lsabcd.leetcode.t43;

public class SolutionBack {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int n1[] = strToIntArray(num1);
        int n2[] = strToIntArray(num2);
        int result[] = new int[n1.length + n2.length];

        int count = 0;
        for (int i = n1.length - 1; i >=0; i--) {
            caclute(n1[i],n2,count,result);
            count++;
        }

        StringBuilder sb = new StringBuilder();
        boolean isZero = true;
        for (int r : result) {
            if (r == 0 && isZero) {
                continue;
            } else {
                sb.append(r);
                isZero = false;
            }
        }
        return sb.length()==0 ? "0" : sb.toString();
    }

    /**
     *
     * @param b 乘数
     * @param m 被乘数
     * @param zeroCount 乘数的第几位
     * @param result 结果数组
     */
    private void caclute(int b, int[] m, int zeroCount, int[] result){
        int carry = 0;
        int resultCarry = 0;
        int tmpIndex = result.length - 1 - zeroCount;
        for (int i = m.length-1; i >= 0; i--) {
            int r = m[i] * b;
            int tmp = (r + carry) % 10;
            carry = (r + carry) / 10 ;

            int tmpResult = tmp + resultCarry + result[tmpIndex];
            result[tmpIndex] = tmpResult % 10;
            resultCarry = tmpResult / 10 ;

            tmpIndex--;
        }
        result[tmpIndex] = result[tmpIndex] + carry + resultCarry;
        printArray(result);
    }
    // 字符串转整数数组
    private int[] strToIntArray(String num){
        int n[] = new int[num.length()];
        char[] chars = num.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            n[i] = chars[i] - '0';
        }
        return n;
    }


    public static void main(String[] args) {
        String n1 = "123";
        String n2 = "456";

        SolutionBack solution = new SolutionBack();
        System.out.println(solution.multiply(n2,n1));
    }

    private void printArray(int[] m){
        for (int i : m) {
            System.out.print(i + ", ");
        }
        System.out.println("");
    }
}
