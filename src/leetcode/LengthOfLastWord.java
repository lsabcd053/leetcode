package leetcode;

public class LengthOfLastWord {
	public static void main(String []argv){
		String s=" ";
		System.out.println(lengthOfLastWord(s));
	}
	 public static int lengthOfLastWord(String s) {
		 String regex = " ";
		 String [] lists = s.split(regex);
		 if(lists.length<1){
			 return 0;
		 }
		 return lists[lists.length-1].length();
	    }
}
