class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        for(int i = myString.length()-1; i >= 0; --i){
            if(myString.substring(0, i+1).endsWith(pat)) ++answer;
        }
        return answer;
    }
}