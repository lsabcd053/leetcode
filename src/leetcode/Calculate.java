package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class Calculate {
	public static void main(String[]argv){
//		String ss="1+2*3+(4*5+6)*7+1+(2-3*3)";
		String ss = "(12)";
		System.out.println(calculate2(ss));
	}
	
	public static int calculate2(String s) {
	    Stack<Integer> stack = new Stack<Integer>();
	    int result = 0;
	    int number = 0;
	    int sign = 1;
	    for(int i = 0; i < s.length(); i++){
	        char c = s.charAt(i);
	        if(Character.isDigit(c)){
	            number = 10 * number + (int)(c - '0');
	        }else if(c == '+'){
	            result += sign * number;
	            number = 0;
	            sign = 1;
	        }else if(c == '-'){
	            result += sign * number;
	            number = 0;
	            sign = -1;
	        }else if(c == '('){
	            //we push the result first, then sign;
	            stack.push(result);
	            stack.push(sign);
	            //reset the sign and result for the value in the parenthesis
	            sign = 1;   
	            result = 0;
	        }else if(c == ')'){
	            result += sign * number;  
	            number = 0;
	            result *= stack.pop();    //stack.pop() is the sign before the parenthesis
	            result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

	        }
	    }
	    if(number != 0) result += sign * number;
	    return result;
	    }
	
	public static int calculate(String s) {
		s = s.replaceAll(" ", "");
        int res=0;
        String pos = toPostfix(s);
        LinkedList<Integer> ll = new LinkedList<Integer>();
        for(char c : pos.toCharArray()){
        	if(Character.isDigit(c)){
        		ll.addFirst(c-'0');
        	}else{
        		int a = ll.removeFirst();
        		int b = ll.removeFirst();
        		switch (c){
        		case '+':
        			ll.addFirst(b+a);
        			break;
        		case '-':
        			ll.addFirst(b-a);
        			break;
        		case '*':
        			ll.addFirst(b*a);
        			break;
        		default :
        			break;
        		}
        	}
        }
        return ll.removeFirst();
    }
	
	
	public static String toPostfix(String s){
        Map<Character,Integer> mp = new HashMap<Character, Integer>();
        mp.put('*', 2);
        mp.put('/', 2);
        mp.put('+', 1);
        mp.put('-', 1);
        mp.put('(', 0);
        LinkedList<Character> ll = new LinkedList<Character>();
        StringBuffer sb = new StringBuffer();
        for(char c : s.toCharArray()){
        	if (Character.isDigit(c)){
        		sb.append(c);
        	}else{
        		if(ll.size()==0 || c=='('){
        			ll.addFirst(c);
        		}else if(c == ')'){
        			while (ll.size()>0 && ll.getFirst() != '('){
        				sb.append(ll.removeFirst());
        			}
        			ll.removeFirst();
        		}else{
        			while (ll.size()>0 && mp.get(ll.getFirst()) >= mp.get(c)  ){
        				sb.append(ll.removeFirst());
        			}
        			ll.addFirst(c);
        		}     		
        	}
        }
        while(ll.size() != 0){
        	sb.append(ll.removeFirst());
        }
        return sb.toString();
	}

}
