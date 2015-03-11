package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public SpiralMatrix(){
		
	}
	public List<Integer> spiralOrder(int[][] matrix) {
		    
			List<Integer> l = new ArrayList<Integer>();
	        int m=matrix.length;
	        if(m<=0){
		    	return l;
		    }
	        int n = matrix[0].length;
	        if(n<=0){
		    	return l;
		    }
	        
	        if(m==1){
	        	for(int i=0;i<n;i++){
	        		l.add(matrix[0][i]);
	        	}
	        	return l;
	        }
	        
	        if(n==1){
	        	for(int i=0;i<m;i++){
	        		l.add(matrix[i][0]);
	        	}
	        	return l;
	        }
	        m--;
	        n--;
	        
	        int i=0;
	        while(m-i >= 0 && n-i >= 0){
	        	for(int p=i;p<=n;p++){
	        		l.add(matrix[i][p]);
	        	}
	        	if(m==i) 
	        		break;
	        	for(int q=i+1;q<m;q++){
	        		l.add(matrix[q][n]);
	        	}
	        	
	        	if(matrix[m][n]==matrix[i][i]){
        			break;
        		}
	        	
	        	for(int s=n;s>=i;s--){
	        		
	        		l.add(matrix[m][s]);
	        	}
	        	for(int t=m-1;t>i;t--){
	        		l.add(matrix[t][i]);
	        	}
	        	i++;
	        	m = m - 1;
	        	n = n - 1;
	        }
	        return l;
	    }
}
