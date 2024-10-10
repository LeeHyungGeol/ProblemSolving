import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        List<String> list1 = getSubSet(str1.toLowerCase());
        List<String> list2 = getSubSet(str2.toLowerCase());
        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>();
        
		Collections.sort(list1);
		Collections.sort(list2);
        
		for (String s : list1) {
			if (list2.remove(s)) { 
				intersection.add(s);
			}
			union.add(s);
		}
        
        for (String s : list2) { 
			union.add(s);
		}
        
   		double jakard = 0;
	
		if (union.size() == 0) {
			jakard = 1;
        } else {
			jakard = (double) intersection.size() / (double) union.size();
        }

		return (int) (jakard * 65536);
    }
    
    private List<String> getSubSet(String str) {
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < str.length()-1; ++i) {
           if (Character.isLetter(str.charAt(i)) && Character.isLetter(str.charAt(i+1))) {
               list.add(str.substring(i,i+2));
           }
        }
        
        return list;
    } 
}