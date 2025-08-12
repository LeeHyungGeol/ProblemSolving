class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append(c);
                isFirst = true;
            } else {
                if (isFirst) {
                    if (Character.isLetter(c)) {
                        sb.append(Character.toUpperCase(c));
                    } else {
                        sb.append(c);
                    }
                    isFirst = false;
                } else {
                    sb.append(Character.toLowerCase(c));
                }
            }
        }
        
        return sb.toString();
    }
}