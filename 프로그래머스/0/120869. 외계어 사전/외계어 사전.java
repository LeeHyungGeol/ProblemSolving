class Solution {
    public int solution(String[] spell, String[] dic) {
        boolean check = false;
        for (String word : dic) {
            int count = 0;
            for (String s : spell) {
                if (word.contains(s)) 
                    ++count;
            }
            if (count == spell.length) {
                check = true;
                break;
            }
        }
        return check ? 1 : 2;
    }
}