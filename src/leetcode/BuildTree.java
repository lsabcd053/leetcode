package leetcode;

import java.util.Arrays;
/*
 * 耗内存
 * 待改进
 * 
 * */
public class BuildTree {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
	      int tl =  preorder.length;
		  if(tl < 1){
	    	   return null;
	       }
	       TreeNode t = new TreeNode(preorder[0]);
	       int i = indexInArray(preorder[0],inorder);
	      
	       int ln = i;
	       int rn = tl - i -1;
	       
	       int []lpo;
	       int []lio;
	       if(ln>0){
	    	   lpo = Arrays.copyOfRange(preorder, 1, i+1);
	    	   lio = Arrays.copyOfRange(inorder, 0, i);
	       }
	       else{
	    	   lpo = new int[0];
	    	   lio = new int[0];
	       }
	       
	       int []rpo;
	       int []rio;
	       if(rn>0){
	    	   rpo = Arrays.copyOfRange(preorder, i+1, tl);
	    	   rio = Arrays.copyOfRange(inorder, i+1, tl);
	       }
	       else{
	    	   rpo = new int[0];
	    	   rio = new int[0];
	       }

	       t.left = this.buildTree(lpo, lio);
	       t.right = this.buildTree(rpo, rio);
	       
	       return t;
	    }
	
	public int indexInArray(int a,int[]array){
		for(int i=0;i<array.length;i++){
			if(a==array[i]){
				return i;
			}
		}
		return -1;
	}
}
