package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
    public List<String> anagrams(String[] strs) {
        List<String> list = new ArrayList<String>();
        Map<String,List<String>> map = new HashMap<String, List<String>>();
        for(String s:strs){
        	char[]sa = s.toCharArray();
        	Arrays.sort(sa);
        	String key = String.valueOf(sa);
        	if(map.containsKey(key)){
        		map.get(key).add(s);
        	}else{
        		List<String> l = new ArrayList<String>();
        		l.add(s);
        		map.put(key, l);
        	}
        }
        for(String s:map.keySet()){
        	List<String> l = map.get(s);
        	if(l.size() > 1){
        		list.addAll(l);
        	}
        }
        return list;
    }
}
