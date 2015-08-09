package leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsValidSudoku {
	public static void main(String[]argv){
		char[][] b = {
				"..5.....6".toCharArray(),
				"....14...".toCharArray(),
				".........".toCharArray(),
				".....92..".toCharArray(),
				"5....2...".toCharArray(),
				".......3.".toCharArray(),
				"...54..6.".toCharArray(),
				"3.....42.".toCharArray(),
				"...27.6..".toCharArray()
				};
		System.out.println(isValidSudoku(b));
	}
    public static boolean isValidSudoku(char[][] board) {
    	Map<Character,Character> map = new HashMap<Character, Character>();
    	Map<Character,Character> map2 = new HashMap<Character, Character>();
    	for(int i=0;i<board.length;i++){
    		for(int j=0;j<board[i].length;j++){
    			if(Character.isDigit(board[i][j])){
    				if(map.containsKey(board[i][j])){
    					return false;
    				}
    				map.put(board[i][j], board[i][j]);
    			}
    			
    			if(Character.isDigit(board[j][i])){
    				if(map2.containsKey(board[j][i])){
    					return false;
    				}
    				map2.put(board[j][i], board[j][i]);
    			}
    		}
    		map.clear();
    		map2.clear();
    	}
    	
    	for(int i=0;i<3;i++){
    		for(int j=0;j<3;j++){
    			for(int k=i*3;k<3*i+3;k++){
    				for(int m=j*3;m<3*j+3;m++){
//    					System.out.println(i+" "+j+" "+k+" "+m);
    					if(Character.isDigit(board[k][m])){
    	    				if(map2.containsKey(board[k][m])){
    	    					return false;
    	    				}
    	    				map2.put(board[k][m], board[k][m]);
    	    			}
    				}
    			}
    			map2.clear();
    		}
    	}
        return true;
    }
}
