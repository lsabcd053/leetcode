package leetcode;

public class Trap {
	public static void main(String []argv){
		int []h={4,2,0,3,2,4,3,4};
		System.out.println(trap(h));
	}
	
	public static int trap(int[] height){
		if(height.length<3)
			return 0;
		int count=0;
		int[][]mm = new int[height.length][2];
		
		int lm=height[0];
		int rm = height[height.length-1];
		for(int i=2;i<height.length-1;i++){
			if(height[i] > rm){
				rm = height[i];
			}
		}
		
		for(int i=1;i<height.length-1;i++){
			System.out.println("lm:"+lm+" rm:"+rm+" height[i]:"+height[i]);
			count += Math.min(rm-height[i], lm-height[i]) > 0 ? Math.min(rm-height[i], lm-height[i]):0;

			if(lm < height[i]){
				lm = height[i];
			}
			if(rm==height[i]){
				rm = height[i+1];
				for(int k=i+1;k<height.length;k++){
					if(height[k] > rm){
						rm = height[k];
					}

				}
			}
		}
		return count;
	}
}
