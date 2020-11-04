package com.lsabcd.leetcode.t59;

public class SolutionV1 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        move(result,0,0,1,'R');
        return result;
    }

    private void move(int[][] result,int i,int j,int value,char d){
        int n = result.length;
        if (result[i][j] == 0){
            result[i][j] = value;
        }
        if (value == n * n) {
            return;
        }
        switch (d) {
            case 'U':
                while (i-1 >= 0 && result[i-1][j] == 0){
                    move(result,--i,j,++value,d);
                }
                move(result,i,++j,++value,'R');
                break;
            case 'D':
                while (i+1 < n && result[i+1][j] == 0){
                    move(result,++i,j,++value,d);
                }
                move(result,i,--j,++value,'L');
                break;
            case 'R':// 右
                while (j+1 < n && result[i][j+1] == 0) {
                    move(result,i,++j,++value,d);
                }
                move(result,++i,j,++value,'D');
                break;
            case 'L':// 左
                while (j-1 >= 0 && result[i][j-1] == 0){
                    move(result,i,--j,++value,d);
                }
                move(result,--i,j,++value,'U');
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        SolutionV1 s = new SolutionV1();
        int n = 5;
        int[][] result = s.generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + "#");
            }
            System.out.println("");
        }
    }
}
