package leetcode;

public class SearchMatrix {
	public static void main(String []argv){
		int [][] m = {{1}};
		int t = 1;
		boolean b = searchMatrix(m,t);
		System.out.println(b);
	}
	
	public static boolean searchMatrix(int[][] matrix, int target) {
//	Runtime: 218 ms
		int m = matrix.length;
		int n =0;
		if(m > 0){
			n = matrix[0].length;
		}
		else{
			return false;
		}
		
		if(matrix[0][0] > target ){
			return false;
		}
		
		for(int i=0;i<m;i++){
			if(matrix[i][0] == target){
				return true;
			}
			else if(matrix[i][0] < target){
				for(int j=0;j<n;j++){
					if(matrix[i][j] == target){
						return true;
					}
					else if(matrix[i][j] > target){
						break;
					}
				}
			}
			else{
				break;
			}
		}
        return false;
    }
	
	
	public static boolean searchMatrix2(int[][] matrix, int target) {
		
		//Runtime: 241 ms
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return false;
		}
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		int start = 0;
		int end = m*n - 1;
		int middle = ( start + end)/2;
		
		int mx = middle / n;
		int my = middle % n;
		while(start <= end){
			if(matrix[mx][my] == target){
				return true;
			}
			else if(matrix[mx][my] < target){
				start = middle + 1;
			}
			else {
				end = middle - 1;
			}
			
			middle = ( start + end)/2;
			mx = middle / n;
			my = middle % n;
			
		}
		return false;
	}
}
