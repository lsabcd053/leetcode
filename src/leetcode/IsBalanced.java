package leetcode;

public class IsBalanced {
	
	
	
	
	public static boolean balance(TreeNode root){
		if (root==null){
			return true;
		}
		if(root.left == null && root.right == null){
			root.val=1;
			return true;
		}
		if(root.left != null && root.right != null){
			boolean lb = balance(root.left);
			boolean rb = balance(root.right);
			
			int rv = root.right.val;
			int lv = root.left.val;
			
			int r = rv > lv ? rv-lv:lv-rv;
			return r < 2;
			
		}
		
		if(root.right != null && root.right == null){
			boolean rb = balance(root.right);
			return root.right.val<2;
		}
		
		if(root.right == null && root.right != null){
			boolean lb = balance(root.left);
			return root.left.val<2;
		}
		return false;
//		root.val = root.right.val>root.left.val?root.right.val+1:root.left.val+1;
		
	}
	
	public boolean isBalanced(TreeNode root) {
		int rl = depth(root.right);
		int ll = depth(root.left);
		
		int r = (rl>ll) ? rl-ll:ll-rl;
		
        return r<2;
    }
	public static int depth(TreeNode root){
		if(root == null){
			return 0;
		}
		
		int rl = depth(root.right);
		int ll = depth(root.left);
		
		return (rl > ll) ? rl+1 : ll+1;
	}
}
